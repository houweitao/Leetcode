package hou.forwz.Leetcode.hard;

/**
 * @author houweitao
 * @date 2016年7月26日上午12:14:43
 */

public class MaximumGap {
	public static void main(String[] args) {
		MaximumGap mg = new MaximumGap();
		int[] nums = { 1, 1, 1, 1, 1, 5, 5, 5, 5, 5 };
		System.out.println(mg.maximumGap(nums));
	}

	public int maximumGap(int[] nums) {
		if (nums.length < 2)
			return 0;

		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

		for (int x : nums) {
			min = Math.min(min, x);
			max = Math.max(max, x);
		}

		int backetSize = (int) Math.ceil((double) (max - min) / (nums.length - 1));
		if (backetSize == 0)
			return 0;

		int[] xiao = new int[nums.length - 1];
		int[] da = new int[nums.length - 1];

		for (int i = 0; i < da.length; i++) {
			xiao[i] = Integer.MAX_VALUE;
			da[i] = Integer.MIN_VALUE;
		}

		for (int x : nums) {
			int pos = (x - min) / (backetSize);

			if (pos == da.length)
				pos--;

			xiao[pos] = Math.min(xiao[pos], x);
			da[pos] = Math.max(da[pos], x);
		}

		int ret = 0;
		int previous = da[0];
		for (int i = 1; i < da.length; i++) {
			if (xiao[i] == Integer.MAX_VALUE && da[i] == Integer.MIN_VALUE)
				// empty bucket
				continue;
			// min value minus the previous value is the current gap
			ret = Math.max(ret, xiao[i] - previous);
			// update previous bucket value
			previous = da[i];
		}

		if (xiao[xiao.length - 1] != Integer.MAX_VALUE && da[xiao.length - 1] != Integer.MIN_VALUE)
			ret = Math.max(ret, xiao[xiao.length - 1] - previous);

		print(xiao);
		print(da);

		return ret;

	}

	private void print(int[] xiao) {
		for (int i : xiao)
			System.out.print(i + ",");
		System.out.println();
	}

}
