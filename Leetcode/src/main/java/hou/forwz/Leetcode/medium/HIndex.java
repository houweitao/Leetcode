package hou.forwz.Leetcode.medium;

/**
 * @author houweitao
 * @date 2016年7月26日下午10:12:37
 */

public class HIndex {

	public int hIndex(int[] citations) {
		int len = citations.length;

		int[] record = new int[len + 1];

		for (int i = 0; i < citations.length; i++) {
			if (citations[i] >= len) {
				record[len]++;
			} else
				record[citations[i]]++;
		}

		int sum = 0;
		for (int i = len; i >= 0; i--) {
			sum = sum + record[i];
			if (sum > i)
				return i;
		}
		return 0;
	}

}
