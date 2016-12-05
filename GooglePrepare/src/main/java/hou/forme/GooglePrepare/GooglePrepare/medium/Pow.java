package hou.forme.GooglePrepare.GooglePrepare.medium;

/**
 * @author houweitao
 * @date 2016年12月5日下午4:38:34
 * @end 2016年12月05日16:45:03
 * @tips 注意边界条件 正无穷和负无穷不是一样大
 */

public class Pow {
	public double myPow(double x, int n) {
		return bigPow(x, n);
	}

	private double bigPow(double x, long n) {
		if (x == 1)
			return x;
		else if (n == 0)
			return 1;
		else if (n < 0)
			return bigPow(1 / x, -n);
		else {
			if (n % 2 == 0)
				return bigPow(x * x, n / 2);
			else
				return x * bigPow(x * x, n / 2);
		}
	}
}
