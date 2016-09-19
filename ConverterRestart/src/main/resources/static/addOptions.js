/**
 * 
 */

function addOption(Selectbox, Text, Value)
{
	var optn = document.createElement("OPTION");
	optn.text = Text;
	optn.value = Value;
	Selectbox.options.add(optn);
}

function addOption_list(){
	var optionList = document.getElementById("listOfUnitsToConvertFrom");
	var units = ["inches", "feet", "yards"];
	console.log(units);
	console.log(optionList);
	for ( var i = 0; i < units.length; i++) {
		addOption(optionList, units[i], units[i]);
	}
}

function test(){
	console.log("test");
	return "test";
}