package hou.forwz.Leetcode.medium;

/**
 * @author houweitao
 * @date 2016年7月31日上午2:39:10
 */

public class CountingBits {
	public static void main(String[] args) {
		CountingBits cb = new CountingBits();
		System.out.println(cb.countBits(2));
	}

	public int[] countBits(int num) {
		int[] ret = new int[num + 1];

		if (num == 0) {
			ret = new int[1];
			return ret;
		} else if (num == 1) {
			ret = new int[2];
			ret[0] = 0;
			ret[1] = 1;
			return ret;
		}

		ret[0] = 0;
		ret[1] = 1;
		// ret[2] = 1;
		// ret[3] = 2;
		// ret[4] = 1;

		for (int i = 1; i < num; i++) {
			int begin = (int) Math.pow(2, i);
			if (begin > num)
				break;
			ret[begin] = 1;
			for (int j = (int) Math.pow(2, i) + 1; j<=num&&j < (int) Math.pow(2, i + 1); j++) {
				ret[j] = ret[begin] + ret[j - begin];
				if (j == num)
					break;
			}
		}
		for (int i : ret)
			System.out.print(i + ",");
		System.out.println();
		return ret;

	}

}
