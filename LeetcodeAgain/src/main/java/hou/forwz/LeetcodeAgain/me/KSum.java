package hou.forwz.LeetcodeAgain.me;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author houweitao
 * @date 2016年11月27日下午2:53:46
 */

public class KSum {

	/**
	 * @param A: an integer array.
	 * @param k: a positive integer (k <= length(A))
	 * @param target: a integer
	 * @return an integer
	 */

	Map<P, Integer> map = new HashMap<>();

	public static void main(String[] args) {
		new KSum().init();
	}

	private void init() {
		int[] A = { 1, 3, 4, 5, 8, 10, 11, 12, 14, 17, 20, 22, 24, 25, 28, 30, 31, 34, 35, 37, 38, 40, 42, 44, 45, 48,
				51, 54, 56, 59, 60, 61, 63, 66 };
		int k = 24;
		int target = 842;
		System.out.println(kSum(A, k, target));
	}

	public int kSum(int A[], int k, int target) {
		// write your code here
		if (A == null || A.length < k)
			return 0;
		Arrays.sort(A);
		dfs(A, -1, k, target);
		P p = new P(-1, k, target);
		return map.get(p);
	}

	int dfs(int[] A, int pos, int k, int target) {
		P p = new P(pos, k, target);
		if (map.containsKey(p))
			return map.get(p);
		if (k == 0) {
			if (target == 0) {
				// System.out.println(tmp);
				return 1;
			}
		} else if (k < 0 || target <= 0) {
			return 0;
		}
		int count = 0;
		for (int i = pos + 1; i < A.length; i++) {
			if (i > pos + 1 && A[i] == A[i - 1])
				continue;
			count += dfs(A, i, k - 1, target - A[i]);
		}
		map.put(p, count);

		return count;
	}

	class P {
		int pos;
		int k;
		int target;

		public P(int pos, int k, int target) {
			super();
			this.pos = pos;
			this.k = k;
			this.target = target;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + k;
			result = prime * result + pos;
			result = prime * result + target;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;

			if (obj instanceof P) {
				if (getClass() != obj.getClass())
					return false;
				P other = (P) obj;
				if (k != other.k)
					return false;
				if (pos != other.pos)
					return false;
				if (target != other.target)
					return false;
				return true;
			}
			return false;
		}

	}
}
