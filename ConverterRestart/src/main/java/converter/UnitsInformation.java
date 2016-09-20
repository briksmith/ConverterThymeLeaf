package converter;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;

import utils.Consts;
import utils.Methods;

public class UnitsInformation
{
	private String numberOfUnitsToConvertFrom;
	private String typeOfUnitToConvertFrom;
	private String typeOfUnitToConvertTo;

	UnitsInformation(HttpServletRequest inRequest){
		numberOfUnitsToConvertFrom = inRequest.getParameter(Consts.NUMBER_OF_UNITS_TO_CONVERT_FROM);
		typeOfUnitToConvertFrom = inRequest.getParameter(Consts.LIST_OF_UNITS_TO_CONVERT_FROM);
		typeOfUnitToConvertTo = inRequest.getParameter(Consts.LIST_OF_UNITS_TO_CONVERT_TO);
	}

	public boolean validateAllInformation() {
		
		if ( validateNumberOfUnitsToConvertTo() == false ){
			return false;
		} else if ( validateTypeOfUnitToConvertFrom() == false ) {
			return false;
		} else if ( validateTypeOfUnitToConvertTo() == false ) {
			return false;
		}
		return true;
	}
	
	private boolean validateNumberOfUnitsToConvertTo(){
		return Methods.verifyString(numberOfUnitsToConvertFrom);
	}
	
	private boolean validateTypeOfUnitToConvertFrom() {
		return Methods.verifyString(typeOfUnitToConvertFrom);
	}
	
	private boolean validateTypeOfUnitToConvertTo() {
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