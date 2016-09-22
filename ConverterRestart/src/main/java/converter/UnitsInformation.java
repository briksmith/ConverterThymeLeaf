package converter;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;

import model.Unit;
import model.UnitType;
import utils.Consts;
import utils.Methods;

public class UnitsInformation
{
	private String numberOfUnitsToConvertFrom;
	private String typeOfUnitToConvertFrom;
	private String typeOfUnitToConvertTo;
	private UnitType unitType = UnitType.Length;

	UnitsInformation(HttpServletRequest inRequest)
	{
		numberOfUnitsToConvertFrom = inRequest.getParameter(Consts.NUMBER_OF_UNITS_TO_CONVERT_FROM);
		typeOfUnitToConvertFrom = inRequest.getParameter(Consts.LIST_OF_UNITS_TO_CONVERT_FROM);
		typeOfUnitToConvertTo = inRequest.getParameter(Consts.LIST_OF_UNITS_TO_CONVERT_TO);
	}

	public boolean validateAllInformation()
	{

		if (validateNumberOfUnitsToConvertTo() && validateTypeOfUnitToConvertFrom()
				&& validateTypeOfUnitToConvertTo())
		{
			return true;
		}
		return false;
	}
	
	public Unit constructUnitsToConvertFrom(){
		
		double numberOfUnits = convertNumberOfUnitsStringToDouble();
		return new Unit(numberOfUnits, typeOfUnitToConvertFrom, unitType);
	}
	
	private double convertNumberOfUnitsStringToDouble()
	{
		return Double.parseDouble(numberOfUnitsToConvertFrom);
	}

	public Unit constructUnitsToConvertTo() {
		
		return new Unit(Consts.NUMBER_OF_UNITS_TO_CONVERT_TO, typeOfUnitToConvertTo, unitType);
	}

	private boolean validateNumberOfUnitsToConvertTo()
	{
		return Methods.verifyString(numberOfUnitsToConvertFrom);
	}

	private boolean validateTypeOfUnitToConvertFrom()
	{
		return Methods.verifyString(typeOfUnitToConvertFrom);
	}

	private boolean validateTypeOfUnitToConvertTo()
	{
		return Methods.verifyString(typeOfUnitToConvertTo);
	}

	public String getNumberOfUnitsToConvertFrom()
	{
		return numberOfUnitsToConvertFrom;
	}

	public String getTypeOfUnitToConvertFrom()
	{
		return typeOfUnitToConvertFrom;
	}

	public String getTypeOfUnitToConvertTo()
	{
		return typeOfUnitToConvertTo;
	}
}