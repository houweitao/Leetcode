package hou.forwz.Leetcode.medium;

/**
 * @author houweitao
 * @date 2016年7月6日下午10:20:40
 */

public class ContainerWithMostWater {

	public int maxArea(int[] height) {
		int ll = 0, rr = height.length - 1;
		int max = 0;
		while (ll <= rr) {
			int l = height[ll];
			int r = height[rr];

			int hei = Math.min(r, l);
			max = Math.max(max, (rr - ll - 1) * hei);

			if (l < hei)
				ll++;
			else
				rr--;
		}
		return max;
	}

}
