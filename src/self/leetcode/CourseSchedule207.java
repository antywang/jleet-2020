package self.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CourseSchedule207 {

	private static boolean canFinish(int numCourses, int[][] prerequisites) {
		int[] rec = new int[numCourses];
		for (int i = 0; i < numCourses; i++) {
			rec[i] = 0;
		}
		Set<String> edgeSet = new HashSet<>();
		for (int[] prerequisite : prerequisites) {
			edgeSet.add(prerequisite[0] + ":" + prerequisite[1]);
		}
		for (int i = 0; i < numCourses; i++) {
			if (rec[i] == 0) {
				if (!dfs(i, rec, edgeSet, numCourses)) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean dfs(int s, int[] rec, Set<String> edgeSet, int numCourses) {
		rec[s] = -1;
		for (int i = 0; i < numCourses; i++) {
			String edgeStr = s + ":" + i;
			if (edgeSet.contains(edgeStr)) {
				if (rec[i] < 0) {
					return false;
				} else if (rec[i] == 0 && !dfs(i, rec, edgeSet, numCourses)) {
					return false;
				}
			}
		}
		rec[s] = 1;
		return true;
	}

	public static void main(String[] args) throws Exception {
		int num = 2;
		int[][] pres = new int[][]{{0, 1}, {1, 0}};
		System.out.println("Test result is: " + canFinish(num, pres));
	}
}
