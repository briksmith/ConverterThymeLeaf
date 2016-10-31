/**
 * 
 */
var lengthUnits = [ "Inches", "Feet", "Yards" ];
	var areaUnits = ["Square Inches", "Square Feet", "Square Yards"];
	var volumeUnits = ["Cubic Inches", "Cubic Feet", "Cubic Yards"];
	var temporalUnits = ["MilliSeconds", "Seconds", "Minutes", "Hours", "Days"];

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
	console.log("in addOptions for dialog");
	var typeOfUnit = findSelectedUnitButton();
	
	console.log("value of unit before case: " + typeOfUnit.value);
	
	for (i = 0; i < arguments.length; i++) {
		var optionList = document.getElementById(arguments[i]);
		flushOptionList(optionList);
		for (var j = 0; j < lengthUnits.length; j++) {
			switch(typeOfUnit.value){
			case "LENGTH" :
				addOption(optionList, lengthUnits[j], lengthUnits[j]);
				break;
			case "AREA" :
			addOption(optionList, areaUnits[j], areaUnits[j]);
			break;
			case "VOLUME":
			addOption(optionList, volumeUnits[j], volumeUnits[j]);
			break;
			case "TEMPORAL":
			addOption(optionList, temporalUnits[j], temporalUnits[j]);
		}
		}
	}
}

function findSelectedUnitButton() {
	
	var unitTypes = [ "LENGTH", "AREA", "VOLUME", "TEMPORAL"];
	
	for(var i = 0; i < unitTypes.length; i++){
		var button = document.getElementById(unitTypes[i]);
		console.log(button);
		console.log(button.checked);
		if ( button.checked===true){
			return button;
		}
	}
	return null;
}

function flushOptionList(optionList) {
	
	var length = optionList.options.length;
	for( var i = length - 1; i >= 0; i--){
		var option = optionList.options[i];
		optionList.options.remove(i);
		console.log("flushing");
	}
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