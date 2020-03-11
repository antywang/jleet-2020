package self.leetcode;

import java.util.Arrays;

public class CoinChange322 {

	private static int coinChange(int[] coins, int amount) {
		if (amount < 0) {
			return -1;
		}
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, amount + 1);
		dp[0] = 0;
		for (int coin : coins) {
			for (int i = 0; i <= amount; i++) {
				if (i >= coin) {
					dp[i] = Math.min(dp[i], dp[i - coin] + 1);
				}
			}
		}
		if (dp[amount] == amount + 1) {
			return -1;
		}
		return dp[amount];
	}

	public static void main(String[] args) throws Exception {
		int[] coins = {1, 2, 5};
		int amount = 11;
		System.out.println("Test result: " + coinChange(coins, amount));
	}
}
