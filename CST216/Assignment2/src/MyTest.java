

import static org.junit.Assert.*;

import org.junit.Test;

public class MyTest {

	@Test
	public void testParseBinary() {
		Assignment2 Tester = new Assignment2();
		String bString = "";
		assertEquals("A blank string returns 0", 0, Tester.parseBinary(bString));
		bString = "14121";
		try {
			 	Tester.parseBinary(bString);
		        fail(); // if we got here, no exception was thrown, which is bad
		}
		catch (Exception e) {
		        final String expected = "4";
		        assertEquals( expected, e.getMessage());
		}
		
		bString = "110";
		assertEquals("Expecting a 6", 6, Tester.parseBinary(bString));
		
		bString = "-100110";
		try {
			 	Tester.parseBinary(bString);
		        fail(); // if we got here, no exception was thrown, which is bad
		}
		catch (Exception e) {
		        final String expected = "-";
		        assertEquals( expected, e.getMessage());
		}
	}

}
