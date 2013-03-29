require([ "dojox/grid/DataGrid", "dojo/data/ObjectStore", "dojo/store/Memory", "dojo/_base/xhr", "dojo/date/stamp" ,"dojo/on","dojo/dom","dojo/domReady!" ], function(DataGrid, ObjectStore, Memory,  xhr, stamp,on, dom) {

	function timestampToFormattedDate(timestampToFormat) {
		var theDate = new Date();
		theDate.setTime(timestampToFormat);
		return stamp.toISOString(theDate, { selector: "date" });
	}
	
	// Define a default Store which loads, potentially all data
    xhr.get({
        url: "services/client/name/%25",
        handleAs: "json"
    }).then(function(data){
		var store = new Memory({ data: data });
		var dataStore = new ObjectStore({ objectStore: store });
		// Define a siple DataGrid and start it
		var grid = new DataGrid({
			store : dataStore,
			autoWidth : true,
			query: { id: "*" },
			structure : [ [ 
			    {name : "Name",field : "name",width : "200px"},
				{name : "Home",field : "homePhone",width : "120px"},
				{name : "Cell",field : "cellPhone",width : "120px"},
				{name : "Mail",field : "email",width : "200px"},
				{name : "Birthday",field : "birthDate",width : "160px", formatter : timestampToFormattedDate},
				{name : "Member since ",field : "membershipDate",width : "160px", formatter : timestampToFormattedDate}
			], [
			    {name : "Address",field : "homeAddress",colSpan : 6}
			] ]
		}, "grid");
		// since we created this grid programmatically, call startup to render it
		grid.startup();
		

    });
    

});

