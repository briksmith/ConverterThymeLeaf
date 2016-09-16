package converter;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;

import utils.Consts;

public class UnitsInformation
{
	public String numberOfUnitsToConvertFrom;
	public String typeOfUnitToConvertFrom;
	public String typeOfUnitToConvertTo;

	UnitsInformation(HttpServletRequest inRequest){
		numberOfUnitsToConvertFrom = inRequest.getParameter(Consts.NUMBER_OF_UNITS_TO_CONVERT_FROM);
		typeOfUnitToConvertFrom = inRequest.getParameter(Consts.LIST_OF_UNITS_TO_CONVERT_FROM);
		typeOfUnitToConvertTo = inRequest.getParameter(Consts.LIST_OF_UNITS_TO_CONVERT_TO);
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