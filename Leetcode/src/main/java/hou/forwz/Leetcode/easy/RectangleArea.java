package hou.forwz.Leetcode.easy;

/**
 * @author houweitao
 * @date 2016年7月30日下午11:51:42
 */

public class RectangleArea {

	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int left = max(A, E), right = max(min(C, G), left);
		int bottom = max(B, F), top = max(min(D, H), bottom);
		return (C - A) * (D - B) - (right - left) * (top - bottom) + (G - E) * (H - F);

	}

	private int min(int c, int g) {
		return Math.min(c, g);
	}

	private int max(int a, int e) {
		return Math.max(a, e);
	}

}
