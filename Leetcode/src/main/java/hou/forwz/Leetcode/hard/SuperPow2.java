package hou.forwz.Leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年8月17日下午9:27:28
 */

public class SuperPow2 {
	int div = 1337;

	List<Integer> findLoop(int a) {
		boolean[] con = new boolean[div];
		List<Integer> ret = new ArrayList<>();

		int num = a % div;
		while (!con[num]) {
			con[num] = true;
			ret.add(num);
			num = (num * a) % div;
		}

		return ret;
	}

	public int superPow(int a, int[] b) {
		if (a == 0)
			return 0;
		if (a == 1)
			return 1;
		if (b == null || b.length == 0)
			return 1;

		if (a > div)
			return superPow(a % div, b);

		List<Integer> index = findLoop(a);
		int loopsize = index.size();
		int rem = modBy(b, loopsize);
		rem = rem == 0 ? loopsize : rem;
		return index.get(rem - 1);
	}

	private int modBy(int[] b, int m) {

		int rem = 0;
		for (int i = 0; i < b.length; i++) {
			rem = (rem * 10 + b[i]) % m;
		}
		return rem;
	}
}
