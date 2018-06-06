package section1;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class ReverseStringTestCases {
	private ReverseString reverseString;

	@Before
	public void setUp() {
		reverseString = new ReverseString();
	}

	@Test
	public void test() {
		//null string
		assertEquals(null, reverseString.reverseString(null));
		//empty string
		assertEquals("", reverseString.reverseString(""));
		//string with space
		assertEquals("   ", reverseString.reverseString("   "));		
		//string with two words
		assertEquals("esrever tset", reverseString.reverseString("test reverse"));
		//string with odd number of characters
		assertEquals("ddo", reverseString.reverseString("odd"));		
		//string with even number of characters
		assertEquals("neve", reverseString.reverseString("even"));
		//string with number
		assertEquals("7", reverseString.reverseString("7"));
		//string with special characters
		assertEquals("%#$%$#@ *=-~", reverseString.reverseString("~-=* @#$%$#%"));
		//string with same characters
		assertEquals("bbbbbbbbbb", reverseString.reverseString("bbbbbbbbbb"));
        //pallindrome string
		assertEquals("ababa", reverseString.reverseString("ababa"));		
		//string with numbers
		assertEquals("79812", reverseString.reverseString("21897"));
		//string with space at the begining
		assertEquals("    dne eht ta ecaps", reverseString.reverseString("space at the end    "));

	}
}
