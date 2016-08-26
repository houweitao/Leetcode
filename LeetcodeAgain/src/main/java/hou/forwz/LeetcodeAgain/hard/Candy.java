package hou.forwz.LeetcodeAgain.hard;

/**
 * @author houweitao
 * @date 2016年8月25日下午5:33:00
 */

public class Candy {

	public int candy(int[] ratings) {
		if (ratings.length < 2)
			return ratings.length;

		int[] candy = new int[ratings.length];
		candy[0] = 1;
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1])
				candy[i] = candy[i - 1] + 1;
			else
				candy[i] = 1;
		}

		for (int i = ratings.length - 1; i > 0; i--) {
			if (ratings[i - 1] > ratings[i])
				candy[i - 1] = Math.max(candy[i - 1], candy[i] + 1);
		}

		int sum = 0;
		for (int i : candy)
			sum += i;

		return sum;

	}

}
