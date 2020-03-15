package self.leetcode;

public class OnesAndZeroes474 {

	public static int findMaxForm(String[] strs, int m, int n) {
		if (m < 1 && n < 1) {
			return 0;
		}
		int[][] dp = new int[m + 1][n + 1];
		dp[0][0] = 0;
		for (String str : strs) {
			int count0 = 0;
			int count1 = 0;
			for (char c : str.toCharArray()) {
				if (c == '0') {
					count0 += 1;
				}
				if (c == '1') {
					count1 += 1;
				}
			}
			for (int i = m; i >= count0; i--) {
				for (int j = n; j >= count1; j--) {
					dp[i][j] = Math.max(dp[i][j], dp[i - count0][j - count1] + 1);
				}
			}
		}
		return dp[m][n];
	}

	public static void main(String[] args) throws Exception {
		String[] testStrs = {"10", "0001", "111001", "1", "0"};
		int m = 5;
		int n = 3;
		System.out.println("The test result is: " + findMaxForm(testStrs, m, n));
	}
}
