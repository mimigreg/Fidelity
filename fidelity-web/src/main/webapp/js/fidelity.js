require(["dojo/store/Memory", "dojox/grid/DataGrid","dojo/data/ObjectStore","dojo/dom","dojo/_base/xhr","dojo/domReady!"], function(Memory,DataGrid,ObjectStore,dom,xhr){
    //"dojo/i18n!fidelity-web/js/i18n/resources", ,resources
	var grid, store, dataStore;
	
	xhr.get({
		url: "http://localhost:8080/fidelity-web/services/client/M",
		handleAs: "json"
	}).then(function(data){
		store = new Memory({ data: data.items });
		dataStore = new ObjectStore({ objectStore: store });
	    grid = new DataGrid({
	        store: dataStore,
	        query: { id: "*" },
	        structure: [[
	            { name: "First Name", field: "firstName", width: "200px" },
	            { name: "Given Name", field: "givenName", width: "200px" },
	            { name: "Home", field: "homePhone", width: "120px" },
	            { name: "Cell", field: "cellPhone", width: "120px" },
	            { name: "Mail", field: "email", width: "200px" },
	            { name: "Birthday", field: "birthDate", width: "160px" },
	            { name: "Member since ", field: "membershipDate", width: "160px" }
	        ], [
	            { name: "Address", field: "homeAddress", colSpan: 7 }
	        ]]
	        
	    }, "grid");
	 // since we created this grid programmatically, call startup to render it
	    grid.startup();
	});
});
