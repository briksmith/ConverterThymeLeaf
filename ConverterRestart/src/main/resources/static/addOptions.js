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
	for (i = 0; i < arguments.length; i++) {
		var optionList = document.getElementById(arguments[i]);
		console.log(lengthUnits);
		console.log(optionList);
		for (var j = 0; j < lengthUnits.length; j++) {
			addOption(optionList, lengthUnits[j], lengthUnits[j]);
		}
	}
}

function test() {
	console.log("test");
	return "test";
}