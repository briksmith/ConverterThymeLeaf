package utils;

public class Methods
{
	private Methods() {}
	
	public static boolean verifyString(String inString){
		
		if ( inString == null){
			return false;
		}
		
		if ( inString.isEmpty()){
			return false;
		}
		
		return true;
	}
}
