package hou.forwz.Leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年7月21日下午11:34:19
 */

public class LargestNumber {

	public static void main(String[] args) {
		LargestNumber ln = new LargestNumber();
		int[] nums = { 3, 30, 34, 5, 9 };
		System.out.println(ln.largestNumber(nums));
	}

	public String largestNumber(int[] nums) {
		if (nums.length < 1)
			return "";

		List<String> list = new ArrayList<>();
		int sum = 0;
		for (int i : nums) {
			sum = sum + i;
			list.add(i + "");
		}

		if (sum == 0)
			return "0";

		Collections.sort(list, new NumComp());

		System.out.println(list);

		StringBuffer sb = new StringBuffer();
		for (int i = list.size() - 1; i >= 0; i--) {
			sb.append(list.get(i));
		}

		return sb.toString();
	}

	class NumComp implements Comparator<String> {

		@Override
		public int compare(String str1, String str2) {
			String s1 = str1 + str2;
			String s2 = str2 + str1;
			return s1.compareTo(s2); // reverse order here, so we can do
										// append() later
		}
	}
}
