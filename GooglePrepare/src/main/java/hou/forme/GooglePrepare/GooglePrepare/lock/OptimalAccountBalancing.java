package hou.forme.GooglePrepare.GooglePrepare.lock;

import java.util.*;

/**
 * @author houweitao
 * @date 2016年12月16日下午4:15:37
 * @url http://www.cnblogs.com/grandyang/p/6108158.html
 */

public class OptimalAccountBalancing {
	public int minTransfers(int[][] transactions) {
		Map<Integer, Integer> net = new HashMap<>();
		for (int[] t : transactions) {
			// net.put(t[0], net.getOrDefault(t[0], 0) - t[2]);
			// net.put(t[1], net.getOrDefault(t[1], 0) + t[2]);
		}
		int[] a = new int[net.size()];
		int cnt = 0;
		for (int v : net.values()) {
			if (v != 0)
				a[cnt++] = v;
		}
		return helper(a, 0, cnt, 0);
	}

	int helper(int[] a, int start, int n, int num) {
		int ans = Integer.MAX_VALUE;
		while (start < n && a[start] == 0)
			start++;
		for (int i = start + 1; i < n; ++i) {
			if (a[i] < 0 && a[start] > 0 || a[i] > 0 && a[start] < 0) {
				a[i] += a[start];
				ans = Math.min(ans, helper(a, start + 1, n, num + 1));
				a[i] -= a[start];
			}
		}
		return ans == Integer.MAX_VALUE ? num : ans;
	}
}
