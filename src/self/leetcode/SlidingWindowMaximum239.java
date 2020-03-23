package self.leetcode;

import java.util.*;

public class SlidingWindowMaximum239 {

	public static int[] maxSlidingWindow(int[] nums, int k) {
		if (nums.length == 0) {
			return nums;
		}
		int[] ret = new int[nums.length - k + 1];
		Deque<Integer> queue = new ArrayDeque<>();
		for (int i = 0; i < nums.length; i++) {
			if (!queue.isEmpty() && queue.peekFirst() <= i - k) {
				queue.pollFirst();
			}
			while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
				queue.pollLast();
			}
			queue.add(i);
			if (i >= k - 1) {
				ret[i - k + 1] = nums[queue.peekFirst()];
			}
		}
		return ret;
	}

	public static void main(String[] args) throws Exception {
		int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
		int k = 3;
		System.out.println("Test result is: " + Arrays.toString(maxSlidingWindow(nums, k)));
	}
}
