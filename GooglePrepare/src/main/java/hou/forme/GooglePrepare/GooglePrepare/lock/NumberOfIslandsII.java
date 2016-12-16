package hou.forme.GooglePrepare.GooglePrepare.lock;

import java.util.ArrayList;
import java.util.List;

// NumberOfIslandsII.java
// http://www.programcreek.com/2015/01/leetcode-number-of-islands-ii-java/
class NumberOfIslandsII {
	public List<Integer> numIslands2(int m, int n, int[][] positions) {
		List<Integer> ret = new ArrayList<>();
		if (positions == null || positions.length == 0)
			return ret;

		int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

		int[] root = new int[m * n];
		int count = 0;

		for (int i = 0; i < positions.length; i++) {
			count++;

			int[] p = positions[i];
			int index = p[0] * n + p[1];

			root[index] = index;

			for (int j = 0; i < directions.length; j++) {
				int x = p[0] + directions[j][0];
				int y = p[1] + directions[j][1];

				if (yes(m, n, x, y) && root[x * n + y] != -1) {
					int curRoot = getRoot(root, x * n + y);
					if (curRoot != index) {
						root[curRoot] = index;
						count--;
					}
				}
			}

			ret.add(count);
		}
		return ret;
	}

	boolean yes(int m, int n, int x, int y) {
		if (x >= 0 && x < m && y >= 0 & y < n)
			return true;
		else
			return false;
	}

	int getRoot(int[] root, int i) {
		while (i != root[i]) {
			i = root[i];
		}
		return i;
	}

}