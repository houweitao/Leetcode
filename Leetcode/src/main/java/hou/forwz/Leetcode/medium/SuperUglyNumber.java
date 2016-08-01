package hou.forwz.Leetcode.medium;

import java.util.PriorityQueue;

/**
 * @author houweitao
 * @date 2016年8月2日上午1:12:56
 */

public class SuperUglyNumber {
	public int nthSuperUglyNumber2(int n, int[] primes) {

		int[] indexs = new int[primes.length];
		int[] uglyNums = new int[n];
		uglyNums[0] = 1;

		for (int i = 1; i < n; ++i) {
			int min = uglyNums[indexs[0]] * primes[0];

			for (int j = 1; j < primes.length; ++j) {
				int temp = uglyNums[indexs[j]] * primes[j];

				if (min > temp & temp > 0)
					min = temp;
			}
			uglyNums[i] = min;
			for (int j = 0; j < primes.length; ++j) {
				if (uglyNums[indexs[j]] * primes[j] == min)
					++indexs[j];
			}
		}
		return uglyNums[n - 1];
	}

	public int nthSuperUglyNumber(int n, int[] primes) {
		if (primes.length == 1)
			return primes[0] * n;
		PriorityQueue<Long> queue = new PriorityQueue<>();
		// for (int j = 0; j < primes.length; j++)
		queue.add(1l);
		for (int i = 0; i < n; i++) {
			long tmp = queue.poll();
			while (!queue.isEmpty() && queue.peek() == tmp) {
				tmp = queue.poll();
			}

			for (int j = 0; j < primes.length; j++)
				queue.add((long) tmp * primes[j]);
		}

		return queue.poll().intValue();
	}

}
