package self.leetcode;

public class NumArray307 {

	private static int[] rec;
	private static int[] rawNums;
	private static int numLength;

	public NumArray307(int[] nums) {
		rawNums = nums;
		numLength = nums.length;
		rec = new int[numLength + 1];
		for (int i = 1; i <= numLength; i++) {
			int sum = 0;
			int start = 1;
			int end = lowbit(i);
			while (start <= end) {
				sum += nums[i - start];
				start += 1;
			}
			rec[i] = sum;
		}
	}

	private static void update(int i, int val) {
		int diff = val - rawNums[i];
		rawNums[i] = val;
		int start = i + 1;
		while (start <= numLength) {
			rec[start] += diff;
			start += lowbit(start);
		}
	}

	private static int sumRange(int i, int j) {
		return sum(j + 1) - sum(i);
	}

	private static int lowbit(int index) {
		return index & (-index);
	}

	private static int sum(int index) {
		int ret = 0;
		while (index > 0) {
			ret += rec[index];
			index -= lowbit(index);
		}
		return ret;
	}

	public static void main(String[] args) throws Exception {
		int[] nums = new int[] {1, 3, 5};
		NumArray307 numArray307 = new NumArray307(nums);
		System.out.println("Test result is: " + numArray307.sumRange(0, 2));
	}
}
