package hou.forwz.Leetcode.easy;

/**
 * @author houweitao
 * @date 2016年7月17日下午10:41:36
 */

public class GuessNumberHigherOrLower {

	public int guessNumber(int n) {

		int left = 1, right = n;

		while (left <= right) {
			if (left == right)
				return left;

			int mid = left + (right - left) / 2;

			int guess = guess(mid);
			if (guess == 0)
				return mid;
			else if (guess > 0)
				right = mid - 1;
			else
				left = mid + 1;
		}

		return -1;

	}

	private int guess(int mid) {
		// TODO Auto-generated method stub
		return 0;
	}

}
