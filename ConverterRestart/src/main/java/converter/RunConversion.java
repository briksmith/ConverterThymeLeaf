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
	public String runConversion(HttpServletRequest request, ModelMap map)
	{
		UnitsInformation units = new UnitsInformation(request);
		
		if ( !verifyUnits(units) )
		{
			return Consts.HELLO;
		}
		double numberOfUnitsToConvertFrom = Double.parseDouble(units.getNumberOfUnitsToConvertFrom() );

		Unit unitsFrom = new Unit(numberOfUnitsToConvertFrom, units.getTypeOfUnitToConvertFrom(), UnitType.length);
		Unit unitsTo = new Unit(1, units.getTypeOfUnitToConvertTo(), UnitType.length);
		double result = LengthUnits.Convert(unitsFrom, unitsTo);
		map.addAttribute(Consts.RESULT, result);
		map.addAttribute(Consts.LIST_OF_UNITS_TO_CONVERT_FROM, unitsFrom.getUnitOfMeasure());
		return Consts.HELLO;
	}
	
	private boolean verifyUnits(UnitsInformation inUnits){
		return inUnits.validateAllInformation();
	}

}