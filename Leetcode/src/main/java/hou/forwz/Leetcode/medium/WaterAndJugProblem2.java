package hou.forwz.Leetcode.medium;

/**
 * @author houweitao
 * @date 2016年8月6日上午12:33:47
 */

public class WaterAndJugProblem2 {
	public boolean canMeasureWater(int x, int y, int z) {
		if (x + y < z)
			return false;
		if (x == z || y == z)
			return true;

		return z % gcd(x, y) == 0;
	}

	private int gcd(int x, int y) {
		if (y == 0)
			return x;

		int tmp = y;
		y = x % y;
		x = tmp;
		return gcd(x, y);
	}
}
