package self.leetcode;

public class NQueensII52 {

	private static int count = 0;

	private static void dfs(int cur, int N, int[] queens) {
		if (cur == N) {
			count += 1;
			return;
		}
		for (int i = 0; i < N; i++) {
			boolean ok = true;
			queens[cur] = i;
			for (int j = 0; j < cur; j++) {
				if (queens[j] == queens[cur] || queens[cur] - cur == queens[j] - j || queens[cur] + cur == queens[j] + j) {
					ok = false;
					break;
				}
			}
			if (ok) {
				dfs(cur + 1, N, queens);
			}
		}
	}

	private static int totalNQueens(int n) {
		if (n < 1) {
			return 0;
		}
		int[] queens = new int[n];
		for (int i = 0; i < n; i++) {
			queens[i] = 0;
		}
		dfs(0, n, queens);
		return count;
	}

	public static void main(String[] args) throws Exception {
		System.out.println("Test result is: " + totalNQueens(1));
	}
}
