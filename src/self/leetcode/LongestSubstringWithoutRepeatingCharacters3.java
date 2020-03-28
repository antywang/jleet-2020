package self.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters3 {

	private static int lengthOfLongestSubstring(String s) {
		Set<Character> charSet = new HashSet<>();
		char[] charArray = s.toCharArray();
		int ret = 0;
		int j = 0;
		int i = 0;
		while (j < charArray.length) {
			if (!charSet.contains(charArray[j])) {
				charSet.add(charArray[j]);
				j++;
			} else {
				while (charArray[i] != charArray[j]) {
					charSet.remove(charArray[i]);
					i++;
				}
				i++;
				j++;
			}
			ret = Math.max(ret, j - i);
		}
		return ret;
	}

	public static void main(String[] args) throws Exception {
		String s = "abcabcbb";
		System.out.println("Test result is: " + lengthOfLongestSubstring(s));
	}
}
