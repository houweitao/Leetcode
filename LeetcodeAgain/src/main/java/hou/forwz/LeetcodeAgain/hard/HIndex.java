package hou.forwz.LeetcodeAgain.hard;

/**
 * @author houweitao
 * @date 2016年9月18日上午1:46:17
 */

public class HIndex {

	public int hIndex(int[] citations) {
		if (citations.length == 0)
			return 0;
		int[] help = new int[citations.length + 1];
		int num = citations.length;
		for (int x : citations) {
			if (x > num)
				help[num]++;
			else
				help[x]++;
		}

		int sum = 0;
		for (int i = help.length - 1; i >= 0; i--) {
			sum += help[i];
			if (sum >= i)
				return i;
		}

		return 0;

	}

}
