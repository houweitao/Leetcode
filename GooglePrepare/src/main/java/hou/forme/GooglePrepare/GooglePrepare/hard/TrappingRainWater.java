package hou.forme.GooglePrepare.GooglePrepare.hard;

/**
 * @author houweitao
 * @date 2016年12月5日下午4:14:39
 * @end 2016年12月05日16:20:23
 */

public class TrappingRainWater {

	public int trap(int[] height) {
		if (height == null || height.length < 3)
			return 0;

		int[] leftMax = new int[height.length];
		int[] rightMax = new int[height.length];

		int max = height[0];
		for (int i = 0; i < height.length; i++) {
			leftMax[i] = max;
			max = Math.max(max, height[i]);
		}

		max = height[height.length - 1];
		for (int i = height.length - 1; i >= 0; i--) {
			rightMax[i] = max;
			max = Math.max(max, height[i]);
		}

		int sum = 0;
		for (int i = 0; i < height.length; i++) {
			sum += Math.max(Math.min(leftMax[i], rightMax[i]) - height[i], 0);
		}
		return sum;
	}

}
