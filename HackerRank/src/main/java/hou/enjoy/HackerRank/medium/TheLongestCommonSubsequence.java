package hou.enjoy.HackerRank.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author houweitao
 * @date 2016年10月31日下午9:49:47
 * @url https://www.hackerrank.com/challenges/dynamic-programming-classics-the-
 *      longest-common-subsequence
 */

public class TheLongestCommonSubsequence {
	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */

		init();
	}

	private static void init() {
		Scanner scanner = new Scanner(System.in);
		int la = scanner.nextInt(), lb = scanner.nextInt();

		int[] nums1 = new int[la];
		for (int i = 0; i < la; i++) {
			nums1[i] = scanner.nextInt();
		}
		int[] nums2 = new int[lb];
		for (int i = 0; i < lb; i++) {
			nums2[i] = scanner.nextInt();
		}
		scanner.close();

		// print(nums1);
		// print(nums2);

		String longest = getLong(nums1, nums2);
		System.out.println(longest);
	}

	private static void print(int[] nums) {
		StringBuilder sb = new StringBuilder();
		for (int i : nums)
			sb.append(i + " ");
		System.out.println(sb);
	}

	private static String getLong(int[] nums1, int[] nums2) {
		if (nums1.length == 0 || nums2.length == 0)
			return "";

		int[][] dp = new int[nums1.length + 1][nums2.length + 1];
		for (int i = 1; i <= nums1.length; i++) {
			int heng = nums1[i - 1];
			for (int j = 1; j <= nums2.length; j++) {
				int shu = nums2[j - 1];
				if (heng == shu)
					dp[i][j] = dp[i - 1][j - 1] + 1;
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}
		// System.out.println(dp[nums1.length][nums2.length]);
		// System.out.println(dp[5][6]);
		// print(dp);

		ListContiner[][] strs = new ListContiner[nums1.length + 1][nums2.length + 1];
		for (int i = 0; i <= nums1.length; i++) {
			for (int j = 0; j <= nums2.length; j++) {
				strs[i][j] = new ListContiner();
			}
		}

		for (int i = 1; i <= nums1.length; i++) {
			int heng = nums1[i - 1];
			for (int j = 1; j <= nums2.length; j++) {
				int shu = nums2[j - 1];
				if (heng == shu) {
					ListContiner xie = new ListContiner(strs[i - 1][j - 1].list);
					xie.add(shu);
					strs[i][j] = xie;
				} else {
					if (strs[i - 1][j].getLen() >= strs[i][j - 1].getLen())
						strs[i][j] = new ListContiner(strs[i - 1][j]);
					else
						strs[i][j] = new ListContiner(strs[i][j - 1]);
				}
			}
		}

		return strs[nums1.length][nums2.length].toString();
	}

	private static void print(int[][] dp) {
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp.length; j++) {
				System.out.print(dp[i][j] + ",");
			}
			System.out.println();
		}
		System.out.println();
	}

	static class ListContiner {
		List<Integer> list;

		public ListContiner() {
			list = new ArrayList<>();
		}

		public ListContiner(ListContiner con) {
			this.list = new ArrayList<>(con.list);
		}

		public ListContiner(List<Integer> list) {
			this.list = new ArrayList<>(list);
		}

		void add(int num) {
			list.add(num);
		}

		int getLen() {
			return list.size();
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			for (int i : list) {
				sb.append(i);
				sb.append(" ");
			}
			return sb.toString().trim();
		}

	}
}
