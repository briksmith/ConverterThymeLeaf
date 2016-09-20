package converter;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import converter.UnitsInformation;
import model.Unit;
import model.UnitType;
import utils.Consts;

public class UnitsInformationTest
{
	UnitsInformation systemUnderTest;
	public static final String validString = "test";
	public static final String emptyString = "";
	public static final String nullString = null;

	@Mock
	HttpServletRequest request;

	@Before
	public void setUp()
	{
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testValidateAllInformationNumberOfUnitsToConvertFromEmptyOthersValid()
	{

		when(request.getParameter(Consts.NUMBER_OF_UNITS_TO_CONVERT_FROM)).thenReturn(emptyString);
		when(request.getParameter(Consts.LIST_OF_UNITS_TO_CONVERT_FROM)).thenReturn(validString);
		when(request.getParameter(Consts.LIST_OF_UNITS_TO_CONVERT_TO)).thenReturn(validString);

		systemUnderTest = new UnitsInformation(request);

		assertFalse("Given " + Consts.NUMBER_OF_UNITS_TO_CONVERT_FROM + " was empty, should be false.",
				systemUnderTest.validateAllInformation());
	}

	@Test
	public void testValidateAllInformationListOfUnitsToConvertFromEmptyOthersValid()
	{

		when(request.getParameter(Consts.NUMBER_OF_UNITS_TO_CONVERT_FROM)).thenReturn(validString);
		when(request.getParameter(Consts.LIST_OF_UNITS_TO_CONVERT_FROM)).thenReturn(emptyString);
		when(request.getParameter(Consts.LIST_OF_UNITS_TO_CONVERT_TO)).thenReturn(validString);

		systemUnderTest = new UnitsInformation(request);

		assertFalse("Given " + Consts.LIST_OF_UNITS_TO_CONVERT_FROM + " was empty, should be false.",
				systemUnderTest.validateAllInformation());

	}

	@Test
	public void testValidateAllInformationListOfUnitsToConvertToEmptyOthersValid()
	{

		when(request.getParameter(Consts.NUMBER_OF_UNITS_TO_CONVERT_FROM)).thenReturn(validString);
		when(request.getParameter(Consts.LIST_OF_UNITS_TO_CONVERT_FROM)).thenReturn(validString);
		when(request.getParameter(Consts.LIST_OF_UNITS_TO_CONVERT_TO)).thenReturn(emptyString);

		systemUnderTest = new UnitsInformation(request);

		assertFalse("Given " + Consts.LIST_OF_UNITS_TO_CONVERT_TO + " was empty, should be false.",
				systemUnderTest.validateAllInformation());

	}

	@Test
	public void testValidateAllInformationNumberOfUnitsToConvertFromNullOthersValid()
	{

		when(request.getParameter(Consts.NUMBER_OF_UNITS_TO_CONVERT_FROM)).thenReturn(nullString);
		when(request.getParameter(Consts.LIST_OF_UNITS_TO_CONVERT_FROM)).thenReturn(validString);
		when(request.getParameter(Consts.LIST_OF_UNITS_TO_CONVERT_TO)).thenReturn(validString);

		systemUnderTest = new UnitsInformation(request);

		assertFalse("Given " + Consts.NUMBER_OF_UNITS_TO_CONVERT_FROM + " was null, should be false.",
				systemUnderTest.validateAllInformation());
	}

	@Test
	public void testValidateAllInformationListOfUnitsToConvertFromNullOthersValid()
	{

		when(request.getParameter(Consts.NUMBER_OF_UNITS_TO_CONVERT_FROM)).thenReturn(validString);
		when(request.getParameter(Consts.LIST_OF_UNITS_TO_CONVERT_FROM)).thenReturn(nullString);
		when(request.getParameter(Consts.LIST_OF_UNITS_TO_CONVERT_TO)).thenReturn(validString);

		systemUnderTest = new UnitsInformation(request);

		assertFalse("Given " + Consts.LIST_OF_UNITS_TO_CONVERT_FROM + " was null, should be false.",
				systemUnderTest.validateAllInformation());

	}

	@Test
	public void testValidateAllInformationListOfUnitsToConvertToNullOthersValid()
	{

		when(request.getParameter(Consts.NUMBER_OF_UNITS_TO_CONVERT_FROM)).thenReturn(validString);
		when(request.getParameter(Consts.LIST_OF_UNITS_TO_CONVERT_FROM)).thenReturn(validString);
		when(request.getParameter(Consts.LIST_OF_UNITS_TO_CONVERT_TO)).thenReturn(nullString);

		systemUnderTest = new UnitsInformation(request);

		assertFalse("Given " + Consts.LIST_OF_UNITS_TO_CONVERT_TO + " was null, should be false.",
				systemUnderTest.validateAllInformation());

	}

	@Test
	public void testAllInformationValid()
	{

		when(request.getParameter(Consts.NUMBER_OF_UNITS_TO_CONVERT_FROM)).thenReturn(validString);
		when(request.getParameter(Consts.LIST_OF_UNITS_TO_CONVERT_FROM)).thenReturn(validString);
		when(request.getParameter(Consts.LIST_OF_UNITS_TO_CONVERT_TO)).thenReturn(validString);

		systemUnderTest = new UnitsInformation(request);

		assertTrue("Given all information was valid, should be true.", systemUnderTest.validateAllInformation());

	}

	@Test
	public void TestConstructUnitsToConvertFrom()
	{
		when(request.getParameter(Consts.NUMBER_OF_UNITS_TO_CONVERT_FROM)).thenReturn("412");
		when(request.getParameter(Consts.LIST_OF_UNITS_TO_CONVERT_FROM)).thenReturn(Consts.FEET);

		systemUnderTest = new UnitsInformation(request);

		Unit result = systemUnderTest.constructUnitsToConvertFrom();

		assertTrue("constructUnitsToConvertFrom should have converted string \"412\" to 412 and did not.",
				412 == result.getNumber());
		assertTrue(
				"constructUnitsToConvertFrom should have been populated with feet as the unit of measure and did not.  Was: "
						+ result.getUnitOfMeasure(),
				Consts.FEET.equals(result.getUnitOfMeasure()));
	}
	
	@Test
	public void TestConstructUnitsToConvertTo()
	{
		when(request.getParameter(Consts.NUMBER_OF_UNITS_TO_CONVERT_FROM)).thenReturn(anyString());
		when(request.getParameter(Consts.LIST_OF_UNITS_TO_CONVERT_TO)).thenReturn(Consts.INCHES);
		
		systemUnderTest = new UnitsInformation(request);
		
		Unit result = systemUnderTest.constructUnitsToConvertTo();
		
		assertTrue("constructUnitsToConvert to should have put a 1 in the number of units and did not.  Was: " +
					result.getNumber(), Consts.NUMBER_OF_UNITS_TO_CONVERT_TO == result.getNumber());
		assertTrue("constructUnitsToConvertTo should have been populated with inches as the unit of measure and did not.  Was: " +
					result.getUnitOfMeasure(), Consts.INCHES.equals(result.getUnitOfMeasure()));
	}
}
