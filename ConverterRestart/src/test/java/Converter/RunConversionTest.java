package Converter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
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

	@Mock HttpServletRequest request;
	RunConversion systemUnderTest;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		systemUnderTest = new RunConversion();
	}
	
	@Test
	public void testEmptyNumberOfUnits(){
		Mockito.when(request.getParameter(Consts.NUMBER_OF_UNITS_TO_CONVERT_FROM)).thenReturn("");
		ModelMap map = new ModelMap();
		try{
			String returnString = systemUnderTest.runConversion(request, map);
			verficiationOfEmptyOfNullUnitsNumberString(returnString);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			fail("Should not have gotten here.  No excption should've been thrown.  Did not handle empty number of units correctly.");
		}
	}

	private void verficiationOfEmptyOfNullUnitsNumberString(String returnString)
	{
		assertEquals("hello", returnString);
		verify(request,  never()).getParameter(Consts.LIST_OF_UNITS_TO_CONVERT_FROM);
		verify(request, never()).getParameter(Consts.LIST_OF_UNITS_TO_CONVERT_TO);
	}
	
	@Test
	public void testNullUnits() {
		when(request.getParameter(Consts.NUMBER_OF_UNITS_TO_CONVERT_FROM)).thenReturn(null);
		ModelMap map = new ModelMap();
		try{
			String returnString = systemUnderTest.runConversion(request, map);
			verficiationOfEmptyOfNullUnitsNumberString(returnString);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			fail("Should not have gotten here.  No excption should've been thrown.  Did not handle null number of units string correctly.");
		}
	}
	
	@Test 
	public void testAddedUnitsResultToMap(){
		when(request.getParameter(Consts.NUMBER_OF_UNITS_TO_CONVERT_FROM)).thenReturn("3");
		when(request.getParameter(Consts.LIST_OF_UNITS_TO_CONVERT_FROM)).thenReturn("Inches");
		when(request.getParameter(Consts.LIST_OF_UNITS_TO_CONVERT_TO)).thenReturn("Feet");
		PowerMockito.mockStatic(LengthUnits.class);
		when(LengthUnits.Convert(any(),any())).thenReturn(.25);
		ModelMap map = new ModelMap();
		String returnString = systemUnderTest.runConversion(request, map);
		assertEquals("Return string should've been hello and was not.  Was: " + returnString, Consts.HELLO, returnString);
		double result = (double) map.get(Consts.RESULT);
		assertTrue("Model map should've had .25 as it's answer and did not.  Was: " + result, .25 == result);
	}
}
