package hou.forme.GooglePrepare.GooglePrepare.medium;

import java.util.PriorityQueue;

/**
 * @author houweitao
 * @date 2016年12月15日下午4:24:24
 */

public class SuperUglyNumber {

	public int nthSuperUglyNumberMeReDo(int n, int[] primes) {
		int[] ret = new int[n];
		ret[0] = 1;

		// 记录最小可能的位置。primes[j]去乘以 ret[] 的位置 很巧妙 2016年08月04日02:02:37
		// 之前都是想乘出来的数在那个位置，这个方法反过来提供了另一种思路
		int[] record = new int[primes.length];

		for (int i = 1; i < n; i++) {
			ret[i] = Integer.MAX_VALUE;

			for (int j = 0; j < primes.length; j++) {
				ret[i] = Math.min(ret[i], primes[j] * ret[record[j]]);
			}

			for (int j = 0; j < primes.length; j++) {
				if (ret[i] == primes[j] * ret[record[j]])
					record[j]++;
			}
		}

		return ret[n - 1];

	}

	// timeout
	public int nthSuperUglyNumberMe(int n, int[] primes) {
		if (n == 1)
			return 1;
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		queue.add(1);

		int pos = 1;
		boolean goon = true;
		while (!queue.isEmpty()) {
			// System.out.println(queue);
			int cur = queue.poll();
			if (pos == n)
				return cur;

			pos++;

			// if (goon)
			for (int i = 0; i < primes.length; i++) {
				long tmp = cur * primes[i];
				if (tmp >= Integer.MAX_VALUE) {
					break;
				} else
					queue.offer(cur * primes[i]);
			}

			while (queue.peek() == cur) {
				queue.poll();
			}
		}

		return -1;

	}

	public int nthSuperUglyNumber(int n, int[] primes) {
		int[] ret = new int[n];
		ret[0] = 1;

		int[] indexes = new int[primes.length];

		for (int i = 1; i < n; i++) {
			ret[i] = Integer.MAX_VALUE;

			for (int j = 0; j < primes.length; j++) {
				ret[i] = Math.min(ret[i], primes[j] * ret[indexes[j]]);
			}

			for (int j = 0; j < indexes.length; j++) {
				if (ret[i] == primes[j] * ret[indexes[j]]) {
					indexes[j]++;
				}
			}
		}

		return ret[n - 1];
	}
}
