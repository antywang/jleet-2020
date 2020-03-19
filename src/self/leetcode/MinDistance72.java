package self.leetcode;

public class MinDistance72 {

	private static int minDistance(String word1, String word2) {
		int l1 = word1.length();
		int l2 = word2.length();
		int[][] dp = new int[l1 + 1][l2 + 1];
		for (int i = 0; i <= l1; i++) {
			dp[i][0] = i;
		}
		for (int j = 0; j <= l2; j++) {
			dp[0][j] = j;
		}
		char[] w1 = word1.toCharArray();
		char[] w2 = word2.toCharArray();
		for (int i = 1; i <= l1; i++) {
			for (int j = 1; j <= l2; j++) {
				int flag;
				if (w1[i - 1] == w2[j - 1]) {
					flag = dp[i - 1][j - 1];
				} else {
					flag = dp[i - 1][j - 1] + 1;
				}
				dp[i][j] = Math.min(flag, Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
			}
		}
		return dp[l1][l2];
	}

	public static void main(String[] args) throws Exception {
		String word1 = "intention";
		String word2 = "execution";
		System.out.println("Test result is: " + minDistance(word1, word2));
	}
}
