package section4;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class GroupingKeyValuePairsTestCases {

	@Test
	public static void test() {
		//no key,value pairs in the data
		String[] testData = {};
		String expectedResult = "";
		assertEquals(expectedResult, GroupingKeyValuePairs.groupPairs(testData));
		
		//key value pairs with unique keys
		String[] testData1 = {"key1,val", "key2,val2"};
		expectedResult = "\nKey: key1\n" + 
				"Values:\nval\n" + 
				"Key: key2\n" + 
				"Values:\nval2";
		assertEquals(expectedResult, GroupingKeyValuePairs.groupPairs(testData1));
		
		//key value pairs with non unique keys
		String[] testData2 = {"key1,val", "key2,val2", "key2,val3"};
		expectedResult = "\nKey: key1\n" + 
				"Values:\nval\n" + 
				"Key: key2\n" + 
				"Values:\nval2\nval3";
		assertEquals(expectedResult, GroupingKeyValuePairs.groupPairs(testData2));
		
		//key value pairs with invalid string i.e. string without comma seperator
		String[] testData3 = {"", "key2,val2", "key2,val3"};
		expectedResult = "Group pairs operation could not be performed. Please try again.";
		assertEquals(expectedResult, GroupingKeyValuePairs.groupPairs(testData3));
		
		//when input is null
		String[] testData4 = null;
		expectedResult = "Group pairs operation could not be performed. Please try again.";
		assertEquals(expectedResult, GroupingKeyValuePairs.groupPairs(testData4));
		
		//when there is more than one comma in key,value pair string
		String[] testData5 = {"", "key2,val,2", "key2,val,3"};
		expectedResult = "Group pairs operation could not be performed. Please try again.";
		assertEquals(expectedResult, GroupingKeyValuePairs.groupPairs(testData5));
	}
}