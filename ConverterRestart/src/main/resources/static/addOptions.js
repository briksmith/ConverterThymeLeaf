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
	console.log("in addOptions for dialog");
	var typeOfUnit = findSelectedUnitButton();
	
	console.log("value of unit before case: " + typeOfUnit.value);
	
	for (i = 0; i < arguments.length; i++) {
		var optionList = document.getElementById(arguments[i]);
		flushOptionList(optionList);
		for (var j = 0; j < lengthUnits.length; j++) {
			switch(typeOfUnit.value){
			case "Length" :
				addOption(optionList, lengthUnits[j], lengthUnits[j]);
				break;
			case "Area" :
			addOption(optionList, areaUnits[j], areaUnits[j]);
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