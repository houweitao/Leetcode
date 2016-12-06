package hou.forme.GooglePrepare.GooglePrepare.medium;

/**
 * @author houweitao
 * @date 2016年12月6日下午3:06:17
 */

public class HIndex {
	public int hIndex(int[] citations) {
		int[] help = new int[citations.length + 1];
		for (int i = 0; i < citations.length; i++) {
			if (citations[i] >= citations.length)
				help[citations.length]++;
			else
				help[citations[i]]++;
		}

		int num = 0;
		for (int i = help.length - 1; i >= 0; i--) {
			num += help[i];
			if (num >= i)
				return i;
		}
		return 0;
	}
}
