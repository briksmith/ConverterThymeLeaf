package converter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ModelMap;
import utils.Consts;

import converter.ConverterHome;

public class ConvertHomeTest
{
	private ConverterHome systemUnderTest;
	
	@Before
	public void setUp()
	{
		systemUnderTest = new ConverterHome();
	}
	
	@Test
	public void testInitLengthUnits()
	{
		ModelMap map = new ModelMap();
		systemUnderTest.convert(map);
		List<String> result = (List<String>) map.get(Consts.LENGTH_UNITS);
		assertEquals("Arrays of returned length units should equal the length of consts units and was not.", Consts.LENGTH_UNITS_LIST.size(), result.size());
		for ( int i = 0; i < result.size(); i++){
			assertTrue("Expected to get a matching array of length units.  Mismatch here.", Consts.LENGTH_UNITS_LIST.get(i).equals(result.get(i)));
		}
	}
}
