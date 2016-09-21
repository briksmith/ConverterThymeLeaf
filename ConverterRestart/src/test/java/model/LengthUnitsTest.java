package model;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import utils.Consts;

@RunWith(MockitoJUnitRunner.class)
public class LengthUnitsTest
{
	@Mock
	Unit to;

	@Before
	public void setUp()
	{

	}

	@Test
	public void testFoundInches()
	{
		String Inches = "Inches";
		LengthUnits FoundUnit = LengthUnits.convertStringToLengthEnum(Inches);
		assertTrue("Should have found Inches and did not.  Was: " + FoundUnit, FoundUnit.equals(LengthUnits.Inches));
	}

	@Test
	public void testFoundFeet()
	{
		String Feet = "Feet";
		LengthUnits FoundUnit = LengthUnits.convertStringToLengthEnum(Feet);
		assertTrue("Should have found Feet and did not.  Was: " + FoundUnit, FoundUnit.equals(LengthUnits.Feet));
	}

	@Test
	public void testFoundYards()
	{
		String Yards = "Yards";
		LengthUnits FoundUnit = LengthUnits.convertStringToLengthEnum(Yards);
		assertTrue("Should have found Yards and did not.  Was: " + FoundUnit, FoundUnit.equals(LengthUnits.Yards));
	}

	@Test
	public void testMissingUnit()
	{
		String Garbage = "GarbageUnit82375";
		LengthUnits FoundUnit = LengthUnits.convertStringToLengthEnum(Garbage);
		assertTrue("Should have returned NotAUnit and did not.  Was: " + FoundUnit,
				FoundUnit.equals(LengthUnits.NotAUnit));
	}

	@Test
	public void testCalcSignPositive()
	{
		int sign = LengthUnits.CalculateSteps(LengthUnits.Inches, LengthUnits.Feet);
		assertTrue("Sign should be positive and was not.  Was: " + sign, sign > 0);
	}

	@Test
	public void testCalcSignZero()
	{
		int sign = LengthUnits.CalculateSteps(LengthUnits.Feet, LengthUnits.Feet);
		assertTrue("Sign should be zero and was not.  Was: " + sign, sign == 0);
	}

	@Test
	public void testCalcSignNegative()
	{
		int sign = LengthUnits.CalculateSteps(LengthUnits.Feet, LengthUnits.Inches);
		assertTrue("Sign should be negative and was not.  Was: " + sign, sign < 0);
	}

	@Test
	public void testYardsToInches()
	{
		Unit from = new Unit(3, "Yards", UnitType.length);
		Unit to = new Unit(1, "Inches", UnitType.length);
		double result = from.Convert(to);

		assertTrue("Expected 3 yards to be 108 inches, and it was not.  Was: " + result, 108.0 == result);
	}

	@Test
	public void testInchesToYards()
	{
		Unit from = new Unit(45, "Inches", UnitType.length);
		Unit to = new Unit(1, "Yards", UnitType.length);
		double result = from.Convert(to);
		assertTrue("Expected 45 inches to be 1.25 yards, and it was not.  Was: " + result, 1.25 == result);
	}

	@Test
	public void testYardsToFeet()
	{
		final double expected = 36;
		Unit from = new Unit(12, Consts.YARDS, UnitType.length);
		Unit to = new Unit(Consts.NUMBER_OF_UNITS_TO_CONVERT_TO, Consts.FEET, UnitType.length);
		double result = from.Convert(to);
		assertTrue(errorMessage(from, to, expected, result), expected == result);
	}

	private String errorMessage(Unit fromUnit, Unit toUnit, double expected, double result)
	{
		return "Expected " + fromUnit.getNumber() + " " + fromUnit.getUnitOfMeasure() + " to be " + expected + " "
				+ toUnit.getUnitOfMeasure() + " and it was not.  Was: " + result;
	}

	@Test
	public void testSameUnit()
	{
		Unit from = new Unit(3, "Yards", UnitType.length);
		Unit to = new Unit(1, "Yards", UnitType.length);
		double result = from.Convert(to);

		assertTrue("Expected 3 yards to be 3 yards, and it was not.  Was: " + result, 3 == result);
	}

}
