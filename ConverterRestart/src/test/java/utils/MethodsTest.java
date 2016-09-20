package utils;

import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
public class MethodsTest
{

	@Test
	public void testReturnsFalseOnEmptyString(){
		String test = "";
		assertFalse("Was supposed to return false on an empty string and did not.  String: " + test, Methods.verifyString(test));
		
	}
	
	@Test
	public void testReturnsFalseOnNullString(){
		String test = null;
		assertFalse("Was supposed to return false on a null string and did not.  String: " + test, Methods.verifyString(test));
	}

	@Test
	public void testReturnsTrueForAnActualString() {
		String test = "test";
		assertTrue("Was supposed to return true on an actual string and did not.  String: " + test, Methods.verifyString(test));
	}
	
}
