package hou.forme.GooglePrepare.GooglePrepare.hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author houweitao
 * @date 2016年12月6日下午1:57:27
 */

public class SlidingWindowMaximum {

	public int[] maxSlidingWindowOther(int[] nums, int k) {
		if (nums == null || k <= 0) {
			return new int[0];
		}
		int n = nums.length;
		int[] r = new int[n - k + 1];
		int ri = 0;
		// store index
		Deque<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < nums.length; i++) {
			// remove numbers out of range k
			while (!q.isEmpty() && q.peek() < i - k + 1) {
				q.poll();
			}
			// remove smaller numbers in k range as they are useless
			while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
				q.pollLast();
			}
			// q contains index... r contains content
			q.offer(i);
			if (i >= k - 1) {
				r[ri++] = nums[q.peek()];
			}
			System.out.println(q);
		}
		return r;
	}

	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k < 1)
			return new int[0];
		if (nums.length < k) {
			Arrays.sort(nums);
			int[] tmp = new int[1];
			tmp[0] = nums[nums.length - 1];
			return tmp;
		}

		int[] ret = new int[nums.length - k + 1];
		PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o2, o1);
			}
		});

		for (int i = 0; i < k - 1; i++) {
			queue.offer(nums[i]);
		}

		int j = 0;
		for (int i = k - 1; i < nums.length; i++) {
			queue.offer(nums[i]);
			ret[j++] = queue.peek();
			queue.remove(nums[i - k + 1]);
		}
		return ret;
	}
}
