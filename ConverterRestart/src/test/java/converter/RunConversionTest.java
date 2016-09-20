package converter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import org.springframework.ui.ModelMap;
import org.powermock.core.classloader.annotations.*;
import org.powermock.api.mockito.*;
import org.powermock.modules.junit4.*;
import converter.RunConversion;
import model.LengthUnits;
import utils.Consts;

@RunWith(PowerMockRunner.class)
@PrepareForTest(LengthUnits.class)
public class RunConversionTest
{

	@Mock
	HttpServletRequest request;
	RunConversion systemUnderTest;

	@Before
	public void setUp()
	{
		MockitoAnnotations.initMocks(this);
		systemUnderTest = new RunConversion();
	}

	private void verifyNullOrEmptyConditions(String inReturnString, ModelMap inMap)
	{
		assertEquals(Consts.HELLO, inReturnString);
		assertNull(inMap.get(Consts.RESULT));
		
	}

	@Test
	public void testEmptyNumberOfUnits()
	{
		when(request.getParameter(Consts.NUMBER_OF_UNITS_TO_CONVERT_FROM)).thenReturn("");
		when(request.getParameter(Consts.LIST_OF_UNITS_TO_CONVERT_FROM)).thenReturn(Consts.FEET);
		when(request.getParameter(Consts.LIST_OF_UNITS_TO_CONVERT_TO)).thenReturn(Consts.FEET);
		ModelMap map = new ModelMap();
		try
		{
			String returnString = systemUnderTest.runConversion(request, map);
			verifyNullOrEmptyConditions(returnString, map);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			fail("Should not have gotten here.  No excption should've been thrown.  Did not handle empty number of units correctly.");
		}
	}

	@Test
	public void testNullNumberOfUnits()
	{
		when(request.getParameter(Consts.NUMBER_OF_UNITS_TO_CONVERT_FROM)).thenReturn(null);
		when(request.getParameter(Consts.LIST_OF_UNITS_TO_CONVERT_FROM)).thenReturn(Consts.FEET);
		when(request.getParameter(Consts.LIST_OF_UNITS_TO_CONVERT_TO)).thenReturn(Consts.FEET);
		ModelMap map = new ModelMap();
		try
		{
			String returnString = systemUnderTest.runConversion(request, map);
			verifyNullOrEmptyConditions(returnString, map);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			fail("Should not have gotten here.  No excption should've been thrown.  Did not handle null number of units string correctly.");
		}
	}

	@Test
	public void testNullUnitsToConvertFrom()
	{
		when(request.getParameter(Consts.NUMBER_OF_UNITS_TO_CONVERT_FROM)).thenReturn("1");
		when(request.getParameter(Consts.LIST_OF_UNITS_TO_CONVERT_FROM)).thenReturn(null);
		when(request.getParameter(Consts.LIST_OF_UNITS_TO_CONVERT_TO)).thenReturn(Consts.FEET);
		ModelMap map = new ModelMap();
		try
		{
			String returnString = systemUnderTest.runConversion(request, map);
			verifyNullOrEmptyConditions(returnString, map);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			fail("Should not have gotten here.  No exception should've been throw.  Did not handle null units to convert from correctly.");
		}
	}
	
	@Test
	public void testEmptyUnitsToConvertFrom()
	{
		when(request.getParameter(Consts.NUMBER_OF_UNITS_TO_CONVERT_FROM)).thenReturn("1");
		when(request.getParameter(Consts.LIST_OF_UNITS_TO_CONVERT_FROM)).thenReturn("");
		when(request.getParameter(Consts.LIST_OF_UNITS_TO_CONVERT_TO)).thenReturn(Consts.FEET);
		ModelMap map = new ModelMap();
		try
		{
			String returnString = systemUnderTest.runConversion(request, map);
			verifyNullOrEmptyConditions(returnString, map);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			fail("Should not have gotten here.  No exception should've been throw.  Did not handle empty units to convert from correctly.");
		}
	}

	@Test
	public void testNullUnitstoConvertTo()
	{
		when(request.getParameter(Consts.NUMBER_OF_UNITS_TO_CONVERT_FROM)).thenReturn("1");
		when(request.getParameter(Consts.LIST_OF_UNITS_TO_CONVERT_FROM)).thenReturn(Consts.FEET);
		when(request.getParameter(Consts.LIST_OF_UNITS_TO_CONVERT_TO)).thenReturn(null);
		ModelMap map = new ModelMap();
		try
		{
			String returnString = systemUnderTest.runConversion(request, map);
			verifyNullOrEmptyConditions(returnString, map);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			fail("Should not have gotten here.  No exception should've been thrown.  Did not handle null units to convert to correctly.");
		}
	}
	
	@Test
	public void testEmptyUnitstoConvertTo()
	{
		when(request.getParameter(Consts.NUMBER_OF_UNITS_TO_CONVERT_FROM)).thenReturn("1");
		when(request.getParameter(Consts.LIST_OF_UNITS_TO_CONVERT_FROM)).thenReturn(Consts.FEET);
		when(request.getParameter(Consts.LIST_OF_UNITS_TO_CONVERT_TO)).thenReturn("");
		ModelMap map = new ModelMap();
		try
		{
			String returnString = systemUnderTest.runConversion(request, map);
			verifyNullOrEmptyConditions(returnString, map);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			fail("Should not have gotten here.  No exception should've been thrown.  Did not handle empty units to convert to correctly.");
		}
	}

	@Test
	public void testAddedUnitsResultToMap()
	{
		when(request.getParameter(Consts.NUMBER_OF_UNITS_TO_CONVERT_FROM)).thenReturn("3");
		when(request.getParameter(Consts.LIST_OF_UNITS_TO_CONVERT_FROM)).thenReturn("Inches");
		when(request.getParameter(Consts.LIST_OF_UNITS_TO_CONVERT_TO)).thenReturn("Feet");
		PowerMockito.mockStatic(LengthUnits.class);
		when(LengthUnits.Convert(any(), any())).thenReturn(.25);
		ModelMap map = new ModelMap();
		String returnString = systemUnderTest.runConversion(request, map);
		assertEquals("Return string should've been hello and was not.  Was: " + returnString, Consts.HELLO,
				returnString);
		double result = (double) map.get(Consts.RESULT);
		assertTrue("Model map should've had .25 as it's answer and did not.  Was: " + result, .25 == result);
	}
	
}
