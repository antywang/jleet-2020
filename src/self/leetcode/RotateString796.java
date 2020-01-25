package self.leetcode;

public class RotateString796 {

	private static boolean rotateString(String A, String B) {
		if (A == null || B == null) {
			return false;
		}
		if (A.equals("") && B.equals("")) {
			return true;
		}
		for (int i = 0; i < A.length(); i++) {
			String transA = A.substring(i) + A.substring(0, i);
			if (transA.equals(B)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(rotateString("abcde", "bcdea"));
	}
}
