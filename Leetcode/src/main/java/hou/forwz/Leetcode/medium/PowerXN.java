package hou.forwz.Leetcode.medium;

/**
 * @author houweitao
 * @date 2016年7月11日上午12:03:23
 */

public class PowerXN {
	public static void main(String[] args) {
		PowerXN px = new PowerXN();
		System.out.println(px.myPow(0.01, Integer.MAX_VALUE));
	}

	public double myPow(double x, int n) {
		if (x == 0)
			return 0;
		else if (n < 0)
			return 1 / myPow(x, -n);
		else if (n == 0)
			return 1;
		else {
			double ret = 1;
			for (int i = 0; i < n; i++) {
				ret = ret * x;
				if (ret == 0)
					return 0;
			}
			return ret;
		}

	}

}
