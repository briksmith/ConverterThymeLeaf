/**
 * 
 */


function addOption(Selectbox, Text, Value) {
	var optn = document.createElement("OPTION");
	optn.text = Text;
	optn.value = Value;
	Selectbox.options.add(optn);
}

function echo(item, index) {
	console.log(item);
}

function addOptionsForDialog(UnitsToConvertFrom, UnitsToConvertTo) {
	var lengthUnits = [ "Inches", "Feet", "Yards" ];
	
	var selected;
	for(var i = 0; i < unitTypes.length; i++){
		var button = document.getElementById(unitTypes[i]);
		console.log(button);
		if ( button.checked="checked"){
			selected = button;
		}
	}
	console.log(selected);
	var unitType = document.getElementById("unitButtons");
	console.log(unitType);
	for (i = 0; i < arguments.length; i++) {
		var optionList = document.getElementById(arguments[i]);
		console.log(lengthUnits);
		console.log(optionList);
		for (var j = 0; j < lengthUnits.length; j++) {
			addOption(optionList, lengthUnits[j], lengthUnits[j]);
		}
	}
}

function findSelectedUnitButton() {
	
	var unitTypes = [ "Length", "Area", "Volume", "Temporal"];
	
	
	for(var i = 0; i < unitTypes.length; i++){
		var button = document.getElementById(unitTypes[i]);
		console.log(button);
		if ( button.checked="checked"){
			return button;
		}
	}
	return null;
}

function testPushToArray() {
	
	var array = [];
	array.push("FUCK");
	console.log(array[0]);
}

function test() {
	console.log("test");
	return "test";
}