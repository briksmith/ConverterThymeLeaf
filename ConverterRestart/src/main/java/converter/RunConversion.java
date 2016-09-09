package converter;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import model.LengthUnits;
import model.Unit;
import model.UnitType;

@Controller
public class RunConversion
{

	private static final String HELLO = "hello";

	@RequestMapping("/runConversion")
	public String runConversion(HttpServletRequest request, ModelMap map){
		
		String stringOfNumberOfUnitsToConvertFrom = request.getParameter("numberOfUnitsToConvertFrom");
		if ( stringOfNumberOfUnitsToConvertFrom == null || stringOfNumberOfUnitsToConvertFrom.isEmpty() )  {
			return HELLO;
		}
		double numberOfUnitsToConvertFrom = Double.parseDouble(stringOfNumberOfUnitsToConvertFrom);
		String typeOfUnitToConvertFrom = request.getParameter("listOfUnitsToConvertFrom");
		String typeOfUnitToConvertTo = request.getParameter("listOfUnitsToConvertTo");
		
		Unit unitsFrom = new Unit(numberOfUnitsToConvertFrom,typeOfUnitToConvertFrom, UnitType.length);
		Unit unitsTo = new Unit(1, typeOfUnitToConvertTo, UnitType.length);
		double result = LengthUnits.Convert(unitsFrom, unitsTo);
		map.addAttribute("result", result);
		return HELLO;
	}
}
