/**
 * 
 */

function addOption(inSelectbox, inText, inValue)
{
	var optn = document.createElement("OPTION");
	optn.text = inText;
	optn.value = inValue;
	inSelectbox.options.add(optn);
}

function addOption_list(){
	var optionList = document.getElementById("listOfUnitsToConvertFrom");
	var units = new Array("inches", "feet", "yards");
	console.log(units);
	console.log(optionList);
	for ( var i = 0; i < units.length; i++) {
		addOption(optionList, units[i], units[i]);
	}
}