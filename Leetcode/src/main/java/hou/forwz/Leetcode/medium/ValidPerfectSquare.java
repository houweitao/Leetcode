package hou.forwz.Leetcode.medium;

/**
 * @author houweitao
 * @date 2016年7月12日下午10:30:41
 */

public class ValidPerfectSquare {
	public static void main(String[] args) {
		ValidPerfectSquare vp = new ValidPerfectSquare();
		System.out.println(vp.isPerfectSquare(5));
	}

	public boolean isPerfectSquare(int num) {
		if (num < 0)
			return false;
		else if (num <= 1)
			return true;
		else {
			int left = 1, right = Integer.MAX_VALUE-1;

			while (left < right) {
				System.out.println(left + "," + right);
				if (left + 1 == right) {
					if (left * left == num || right * right == num)
						return true;
					else
						return false;
				}

				int mid = (left + right) / 2;

				if (mid > num / mid) {
					right = mid;
				} else if (mid < num / mid) {
					if ((mid + 1) > num / (mid + 1)) {
						return false;
					} else
						left = mid;
				} else
					return mid*mid==num;

			}
			return false;
		}
	}

}
