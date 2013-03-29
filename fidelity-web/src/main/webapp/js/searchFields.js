require([ "dojo/on","dojo/dom","dojo/_base/xhr","dojo/data/ObjectStore","dojo/store/Memory","dijit/form/TextBox","dijit/form/DateTextBox",
		"dojo/domReady!" ], function(on, dom, xhr, ObjectStore, Memory, TextBox,DateTextBox) {
	
	var inputnameField = new TextBox({
	    name: "rechName",
	    value: "" /* no or empty value! */,
	    placeHolder: "type in the name"		
	},"rechName");
	var inputdobField = new DateTextBox({
	    name: "rechDOB",
	    placeHolder: "Select the date"		
	},"rechDOB");
	
	var oldValue = inputnameField.get("value");
	// Cablage du changement dans le champs nom
	on(inputnameField,"keyUp", function (event) {
		if(oldValue.equals(inputnameField.get("value"))){
			oldValue =inputnameField.get("value");
		    xhr.get({
		        url: "services/client/name/"+escape("%"+inputnameField.get("value")+"%"),
		        handleAs: "json",
		        load: function (data) {
		    		var myStore = new Memory({ data: data });
		    		var myDataStore = new ObjectStore({ objectStore: myStore });
		    		dijit.byId("grid").setStore(myDataStore);
		          }
		    });
		 }
	});
	
	// Cablage du changement dans le champs date
	on(inputdobField,"change", function (event) {
		if(inputdobField.value!=null) {
		    xhr.get({
		        url: "services/client/birthdate/"+escape(inputdobField.value),
		        handleAs: "json",
		        load: function (data) {
		    		var myStore = new Memory({ data: data });
		    		var myDataStore = new ObjectStore({ objectStore: myStore });
		    		dijit.byId("grid").setStore(myDataStore);
		          }
		    });
	    }
	});

});
