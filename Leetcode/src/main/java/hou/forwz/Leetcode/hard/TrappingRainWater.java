package hou.forwz.Leetcode.hard;

/**
 * @author houweitao
 * @date 2016年7月6日下午10:58:19
 */

public class TrappingRainWater {

	public int trap(int[] height) {
		if (height.length < 3)
			return 0;

		int len = height.length;
		int left[] = new int[len];
		int right[] = new int[len];

		int max = -1;
		for (int i = 0; i < len; i++) {
			max = Math.max(max, height[i]);
			left[i] = max;
		}
		max = -1;
		for (int i = len - 1; i >= 0; i--) {
			max = Math.max(max, height[i]);
			right[i] = max;
		}

		int ret = 0;

		for (int i = 0; i < len; i++) {
			ret = ret + Math.min(left[i], right[i]) - height[i];
		}

		return ret;
	}

}
