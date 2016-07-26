package hou.forwz.Leetcode.medium;

/**
 * @author houweitao
 * @date 2016年7月26日下午10:39:07
 */

public class HIndexII {

	public int hIndex(int[] citations) {
		for (int i = citations.length - 1; i >= 0; i--) {
			if (citations[i] >= i)
				return citations[i];
		}
		return 0;
	}

}
