package self.leetcode;

public class PartitionEqualSubsetSum416 {

	private static boolean canPartition(int[] nums) {
		if (nums == null || nums.length == 0) {
			return false;
		}
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		if (sum % 2 != 0) {
			return false;
		}
		int targetSum = sum / 2;
		int[] dp = new int[targetSum + 1];
		dp[0] = 1;
		for (int num : nums) {
			for (int j = targetSum; j >= 0; j--) {
				if (j >= num) {
					dp[j] += dp[j - num];
				}
			}
		}
		return dp[targetSum] > 0;
	}

	public static void main(String[] args) throws Exception {
		int[] testNums = {100, 100, 100};
		System.out.println("The test result is:" + canPartition(testNums));
	}
}
