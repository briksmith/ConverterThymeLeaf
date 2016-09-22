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
	var areaUnits = ["Square Inches", "Square Feet", "Square Yards"];
	var typeOfUnit = findSelectedUnitButton();
	
	console.log( typeOfUnit.value);
	
	for (i = 0; i < arguments.length; i++) {
		var optionList = document.getElementById(arguments[i]);
		for (var j = 0; j < lengthUnits.length; j++) {
			switch(typeOfUnit.value){
			case "Length" :
				addOption(optionList, lengthUnits[j], lengthUnits[j]);
				break;
			case "Area" :
			addOption(optionList, lengthUnits[j], lengthUnits[j]);
			break;
		}
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