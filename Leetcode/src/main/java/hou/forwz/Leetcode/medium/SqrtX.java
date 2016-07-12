package hou.forwz.Leetcode.medium;

/**
 * @author houweitao
 * @date 2016年7月12日下午10:09:27
 */

public class SqrtX {
	public static void main(String[] args) {
		SqrtX sx = new SqrtX();
		System.out.println(sx.mySqrt(2147395599));
	}

//	https://discuss.leetcode.com/topic/8680/a-binary-search-solution
	public int sqrt2(int x) {
		if (x == 0)
			return 0;
		int left = 1, right = Integer.MAX_VALUE;
		while (true) {
			int mid = left + (right - left) / 2;
			if (mid > x / mid) {
				right = mid - 1;
			} else {
				if (mid + 1 > x / (mid + 1))
					return mid;
				left = mid + 1;
			}
		}
	}

	public int mySqrt(int x) {
		if (x < 0)
			return -1;
		else if (x < 2)
			return x;
		else {
			int left = 1, right = x;

			while (left < right) {
				System.out.println(left + "," + right);
				if (left == right) {
					if (left * left >= x)
						return left - 1;
					else
						return left;
				} else if (left + 1 == right) {
					if (left * left > x)
						return left - 1;
					else if (right * right < x)
						return right;
					else
						return left;
				} else {
					int mid = (left + right) / 2;
					long shu = mid * mid;
					if (shu < Integer.MAX_VALUE) {
						if (mid * mid > x) {
							if (mid == left)
								return mid - 1;
							right = mid;
						} else if (mid * mid < x) {
							if (left == mid) {
								if (right * right > x)
									return mid;
								else
									return right;
							}
							left = mid;
						} else
							return mid;
					} else {
						right = mid;
					}
				}
			}
			return -1;
		}
	}

}
