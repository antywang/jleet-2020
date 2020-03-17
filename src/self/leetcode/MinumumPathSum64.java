package self.leetcode;

public class MinumumPathSum64 {

	public static int minPathSum(int[][] grid) {
		if (grid.length == 1 && grid[0].length == 1) {
			return grid[0][0];
		}
		int m = grid.length;
		int n = grid[0].length;
		for (int i = 1; i < grid.length; i++) {
			grid[i][0] += grid[i - 1][0];
		}
		for (int j = 1; j < grid[0].length; j++) {
			grid[0][j] += grid[0][j - 1];
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
			}
		}
		return grid[m - 1][n - 1];
	}

	public static void main(String[] args) throws Exception {
		int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
		System.out.println("Test result is: " + minPathSum(grid));
	}
}
