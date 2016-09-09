package converter;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import model.LengthUnits;
import model.Unit;
import model.UnitType;
import utils.Consts;

@Controller
public class RunConversion
{

	@RequestMapping("/runConversion")
	public String runConversion(HttpServletRequest request, ModelMap map){
		
		String stringOfNumberOfUnitsToConvertFrom = request.getParameter(Consts.NUMBER_OF_UNITS_TO_CONVERT_FROM);
		if ( stringOfNumberOfUnitsToConvertFrom == null || stringOfNumberOfUnitsToConvertFrom.isEmpty() )  {
			return Consts.HELLO;
		}
		double numberOfUnitsToConvertFrom = Double.parseDouble(stringOfNumberOfUnitsToConvertFrom);
		String typeOfUnitToConvertFrom = request.getParameter(Consts.LIST_OF_UNITS_TO_CONVERT_FROM);
		String typeOfUnitToConvertTo = request.getParameter(Consts.LIST_OF_UNITS_TO_CONVERT_TO);
		
		Unit unitsFrom = new Unit(numberOfUnitsToConvertFrom,typeOfUnitToConvertFrom, UnitType.length);
		Unit unitsTo = new Unit(1, typeOfUnitToConvertTo, UnitType.length);
		double result = LengthUnits.Convert(unitsFrom, unitsTo);
		map.addAttribute(Consts.RESULT, result);
		return Consts.HELLO;
	}
}
