package section1;

public class ReverseString {
	/*Reverses string
	 * @Parameters: str -> input string
	 * returns reversed string
	 * Time Complexity: O(n/2) => O(n) where n is the length of string
	 * Space Complexity: O(n) where n is the length of string*/
	public String reverseString(String str) {
		//base cases
		if(str == null || str.length() == 0 || str.length() == 1) {
			return str;
		}
		//swap characters at low and high indices to get a reversed string
		int low=0, high=str.length()-1;
		char[] inputArray = str.toCharArray();
		while(low<high) {
			char temp = inputArray[low];
			inputArray[low] = inputArray[high];
			inputArray[high] = temp;
			low++; high--;
		}
        return String.valueOf(inputArray);
	}
}
