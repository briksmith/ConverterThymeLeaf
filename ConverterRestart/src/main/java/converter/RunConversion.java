package converter;

import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import model.LengthUnits;
import model.Unit;
import utils.Consts;

@Controller
public class RunConversion
{
	
	private Unit unitsFrom;
	private Unit unitsTo;
	
	@RequestMapping("/runConversion")
	public String runConversion(HttpServletRequest request, HttpServletResponse response, ModelMap map)
	{
		UnitsInformation unitsInformation = new UnitsInformation(request);
		
		if ( !verifyUnits(unitsInformation) )
		{
			return Consts.HELLO;
		}

		constructUnits(unitsInformation);
		double result = convertUnits();
		populateModel(map, result);
		return Consts.HELLO;
	}

	private boolean verifyUnits(UnitsInformation inUnits){
		return inUnits.validateAllInformation();
	}
	
	private void constructUnits(UnitsInformation units) {
		unitsFrom = units.constructUnitsToConvertFrom(); 
		unitsTo =  units.constructUnitsToConvertTo();
	}

	private double convertUnits()
	{
		return LengthUnits.Convert(unitsFrom, unitsTo);
	}

	private void populateModel(ModelMap map, double result)
	{
		map.addAttribute(Consts.RESULT, result);
		map.addAttribute(Consts.LIST_OF_UNITS_TO_CONVERT_FROM, unitsFrom.getUnitOfMeasure());
	}

}