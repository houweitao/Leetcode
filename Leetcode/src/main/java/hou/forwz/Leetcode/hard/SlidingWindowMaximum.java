package hou.forwz.Leetcode.hard;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author houweitao
 * @date 2016年8月11日下午11:22:45
 */

public class SlidingWindowMaximum {
	public static void main(String[] args) {
		int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 3;
		SlidingWindowMaximum sw = new SlidingWindowMaximum();
		int[] ret = sw.maxSlidingWindow(nums, k);
		for (int i : ret)
			System.out.print(i + ",");
		System.out.println();

		ret = sw.maxSlidingWindowOther(nums, k);
		for (int i : ret)
			System.out.print(i + ",");
		System.out.println();

		Deque<Integer> q = new ArrayDeque<>();
		q.push(3);
		q.push(1);
		q.push(5);
		q.add(7);
		System.out.println(q);
	}

	public int[] maxSlidingWindow(int[] nums, int k) {
		int[] ret = new int[nums.length - k + 1];
		int pos = k - 1;

		for (int i = 0; i < k; i++) {
			ret[0] = ret[0] + nums[i];
		}

		for (int i = pos + 1; i < nums.length; i++) {
			ret[i - pos] = ret[i - pos - 1] + nums[i] - nums[i - k];
		}

		return ret;
	}

	public int[] maxSlidingWindowOther(int[] a, int k) {
		if (a == null || k <= 0) {
			return new int[0];
		}
		int n = a.length;
		int[] r = new int[n - k + 1];
		int ri = 0;
		// store index
		Deque<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < a.length; i++) {
			// remove numbers out of range k
			while (!q.isEmpty() && q.peek() < i - k + 1) {
				q.poll();
			}
			// remove smaller numbers in k range as they are useless
			while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
				q.pollLast();
			}
			// q contains index... r contains content
			q.offer(i);
			if (i >= k - 1) {
				r[ri++] = a[q.peek()];
			}
		}
		return r;
	}
}
