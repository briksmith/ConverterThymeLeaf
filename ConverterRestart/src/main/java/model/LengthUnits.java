package model;

public enum LengthUnits
{
	Inches(12), Feet(3), Yards(2), NotAUnit(1);
	private LengthUnits(int inNumberOfNextUnit)
	{
		numberOfNextUnit = inNumberOfNextUnit;
	}

	private int numberOfNextUnit;
	private static UnitType unitType = UnitType.length;

	public int getNumberOfNextUnit()
	{
		return numberOfNextUnit;
	}

	public static double Convert(Unit fromUnit, Unit toUnit)
	{
		LengthUnits fromUnitEnum = convertStringToLengthEnum(fromUnit.getUnitOfMeasure());
		LengthUnits toUnitEnum = convertStringToLengthEnum(toUnit.getUnitOfMeasure());
		
		int steps = CalculateSteps(fromUnitEnum, toUnitEnum);
		if (steps == 0)
		{
			return fromUnit.getNumber();
		}
		int sign = getStepSign(steps);
		LengthUnits[] values = LengthUnits.values();
		double originalValue = fromUnit.getNumber();
		int index = fromUnitEnum.ordinal();
		for (int i = 0; i < steps ; i++)
		{
			if ( sign > 0 ){
				originalValue /= values[index].numberOfNextUnit;
			}
			else {
				originalValue *= values[index].numberOfNextUnit;
			}
			index += sign;
		}
		return originalValue;
	}

	private static int getStepSign(int inSteps)
	{
		return inSteps > 0 ? 1 : -1;
	}

	static LengthUnits convertStringToLengthEnum(String toConvertFromName)
	{
		LengthUnits[] units = LengthUnits.values();
		for (LengthUnits unit : units)
		{
			if (toConvertFromName.equals(unit.name()))
			{
				return unit;
			}
		}
		return NotAUnit;
	}

	static int CalculateSteps(LengthUnits toConvertFromName, LengthUnits toConvertToName)
	{
		return toConvertToName.ordinal() - toConvertFromName.ordinal();
	}

	public static UnitType getUnitType()
	{
		return unitType;
	}

	public boolean Equals(Object o)
	{
		if (o instanceof LengthUnits)
		{
			LengthUnits inUnits = (LengthUnits) o;
			if (inUnits.name().equals(this.name()))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		return false;
	}
}
