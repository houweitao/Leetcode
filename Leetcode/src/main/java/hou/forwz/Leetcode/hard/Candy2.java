package hou.forwz.Leetcode.hard;

/**
 * @author houweitao
 * @date 2016年7月25日下午11:03:38
 */

public class Candy2 {
	public static void main(String[] args) {
		Candy2 c = new Candy2();
		int[] ratings = { 2, 3, 2 };
		System.out.println(c.candy(ratings));
	}

	public int candy(int[] ratings) {
		if (ratings.length < 2)
			return ratings.length;

		int[] candys = new int[ratings.length];

		for (int i = 0; i < ratings.length; i++) {
			candys[i] = 1;
			if (i > 0) {
				if (ratings[i] > ratings[i - 1]) {
					candys[i] = candys[i - 1] + 1;
				}
			}
		}

		for (int i = ratings.length - 1; i > 0; i--) {
			if (ratings[i - 1] > ratings[i]) {
				candys[i - 1] = Math.max(candys[i - 1], candys[i] + 1);
			}
		}

		int sum = 0;
		for (int n : candys) {
			sum = sum + n;
		}
		return sum;
	}

}
