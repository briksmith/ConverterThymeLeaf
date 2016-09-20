package converter;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import converter.UnitsInformation;
import utils.Consts;

public class UnitsInformationTest
{
	UnitsInformation systemUnderTest;
	public static final String validString = "test";
	public static final String emptyString = "";
	public static final String nullString = null;
	
	@Mock HttpServletRequest request;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		systemUnderTest = new UnitsInformation(request);
	}
	
	@Test
	public void testValidateAllInformationNumberOfUnitsToConvertFromEmptyOthersValid(){
		
		when(request.getParameter(Consts.NUMBER_OF_UNITS_TO_CONVERT_FROM)).thenReturn(emptyString);
		when(request.getParameter(Consts.LIST_OF_UNITS_TO_CONVERT_FROM)).thenReturn(validString);
		when(request.getParameter(Consts.LIST_OF_UNITS_TO_CONVERT_TO)).thenReturn(validString);
		
		systemUnderTest = new UnitsInformation(request);
		
		assertFalse("Given " + Consts.NUMBER_OF_UNITS_TO_CONVERT_FROM + " was empty, should be false.", systemUnderTest.validateAllInformation());
	}
	
	@Test
	public void testValidateAllInformationListOfUnitsToConvertFromEmptyOthersValid() {
		
		when(request.getParameter(Consts.NUMBER_OF_UNITS_TO_CONVERT_FROM)).thenReturn(validString);
		when(request.getParameter(Consts.LIST_OF_UNITS_TO_CONVERT_FROM)).thenReturn(emptyString);
		when(request.getParameter(Consts.LIST_OF_UNITS_TO_CONVERT_TO)).thenReturn(validString);
		
		systemUnderTest = new UnitsInformation(request);
		
		assertFalse("Given " + Consts.LIST_OF_UNITS_TO_CONVERT_FROM + " was empty, should be false.", systemUnderTest.validateAllInformation());

	}
	
	@Test
	public void testValidateAllInformationListOfUnitsToConvertToEmptyOthersValid() {
		
		when(request.getParameter(Consts.NUMBER_OF_UNITS_TO_CONVERT_FROM)).thenReturn(validString);
		when(request.getParameter(Consts.LIST_OF_UNITS_TO_CONVERT_FROM)).thenReturn(validString);
		when(request.getParameter(Consts.LIST_OF_UNITS_TO_CONVERT_TO)).thenReturn(emptyString);
		
		systemUnderTest = new UnitsInformation(request);
		
		assertFalse("Given " + Consts.LIST_OF_UNITS_TO_CONVERT_TO + " was empty, should be false.", systemUnderTest.validateAllInformation());

	}
	
	@Test
	public void testValidateAllInformationNumberOfUnitsToConvertFromNullOthersValid(){
		
		when(request.getParameter(Consts.NUMBER_OF_UNITS_TO_CONVERT_FROM)).thenReturn(nullString);
		when(request.getParameter(Consts.LIST_OF_UNITS_TO_CONVERT_FROM)).thenReturn(validString);
		when(request.getParameter(Consts.LIST_OF_UNITS_TO_CONVERT_TO)).thenReturn(validString);
		
		systemUnderTest = new UnitsInformation(request);
		
		assertFalse("Given " + Consts.NUMBER_OF_UNITS_TO_CONVERT_FROM + " was null, should be false.", systemUnderTest.validateAllInformation());
	}
	
	@Test
	public void testValidateAllInformationListOfUnitsToConvertFromNullOthersValid() {
		
		when(request.getParameter(Consts.NUMBER_OF_UNITS_TO_CONVERT_FROM)).thenReturn(validString);
		when(request.getParameter(Consts.LIST_OF_UNITS_TO_CONVERT_FROM)).thenReturn(nullString);
		when(request.getParameter(Consts.LIST_OF_UNITS_TO_CONVERT_TO)).thenReturn(validString);
		
		systemUnderTest = new UnitsInformation(request);
		
		assertFalse("Given " + Consts.LIST_OF_UNITS_TO_CONVERT_FROM + " was null, should be false.", systemUnderTest.validateAllInformation());

	}
	
	@Test
	public void testValidateAllInformationListOfUnitsToConvertToNullOthersValid() {
		
		when(request.getParameter(Consts.NUMBER_OF_UNITS_TO_CONVERT_FROM)).thenReturn(validString);
		when(request.getParameter(Consts.LIST_OF_UNITS_TO_CONVERT_FROM)).thenReturn(validString);
		when(request.getParameter(Consts.LIST_OF_UNITS_TO_CONVERT_TO)).thenReturn(nullString);
		
		systemUnderTest = new UnitsInformation(request);
		
		assertFalse("Given " + Consts.LIST_OF_UNITS_TO_CONVERT_TO + " was null, should be false.", systemUnderTest.validateAllInformation());

	}
	
	@Test
	public void testAllInformationValid() {
		
		when(request.getParameter(Consts.NUMBER_OF_UNITS_TO_CONVERT_FROM)).thenReturn(validString);
		when(request.getParameter(Consts.LIST_OF_UNITS_TO_CONVERT_FROM)).thenReturn(validString);
		when(request.getParameter(Consts.LIST_OF_UNITS_TO_CONVERT_TO)).thenReturn(validString);
		
		systemUnderTest = new UnitsInformation(request);
		
		assertTrue("Given all information was valid, should be true.", systemUnderTest.validateAllInformation());

	}
}
