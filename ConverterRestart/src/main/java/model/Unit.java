package model;

public class Unit
{
	private double number;
	private String unitOfMeasure;
	private UnitType unitType;

	public Unit()
	{
		number = (0.0);
		unitOfMeasure = "";
		unitType = null;
	}

	public Unit(double inNumber, String inUnitOfMeasure, UnitType inUnitType)
	{
		number = inNumber;
		unitOfMeasure = inUnitOfMeasure;
		unitType = inUnitType;
	}

	public double Convert(Unit unitToConvertTo){
		
		if( unitType.equals(LengthUnits.getUnitType()))
		{
			return LengthUnits.Convert(this, unitToConvertTo);
		}

	return Double.NaN;
}
	
	public String getUnitOfMeasure(){
		return unitOfMeasure;
	}

	public double getNumber()
	{
		return number;
	}

	public void setNumber(double number)
	{
		this.number = number;
	}

}
