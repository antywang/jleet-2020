package self.leetcode;

public class ImplementstrSt28 {

	private static int strStr(String haystack, String needle) {
		if (needle.length() == 0) {
			return 0;
		}
		if (needle.length() > haystack.length()) {
			return -1;
		}
		boolean foundFlag;
		char[] hayCharArray = haystack.toCharArray();
		char[] needleCharArray = needle.toCharArray();
		for (int i = 0; i <= hayCharArray.length - needleCharArray.length; i++) {
			if (hayCharArray[i] == needleCharArray[0]) {
				foundFlag = true;
				for (int j = 0; j < needleCharArray.length; j++) {
					if (hayCharArray[i + j] != needleCharArray[j]) {
						foundFlag = false;
						break;
					}
				}
				if (foundFlag) {
					return i;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) throws Exception {
		String hayStack = "hello";
		String needle = "ll";
		System.out.println("Test result is: " + strStr(hayStack, needle));
	}
}
