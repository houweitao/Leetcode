package hou.forme.GooglePrepare.GooglePrepare.hard;

/**
 * @author houweitao
 * @date 2016年12月17日下午1:37:50
 * @url http://www.programcreek.com/2012/12/leetcode-median-of-two-sorted-arrays-java/
 */

public class MedianOfTwoSortedArrays {
	public static void main(String[] args) {
		MedianOfTwoSortedArrays mt = new MedianOfTwoSortedArrays();
		int[] nums1 = { 1, 3, 5 };
		int[] nums2 = { 2 };

		System.out.println(mt.help(nums1, 0, nums2, 0, 3));
	}

	public double findMedianSortedArraysMe(int[] nums1, int[] nums2) {
		if (nums1 == null || nums1.length == 0)
			return easyFind(nums2);
		if (nums2 == null || nums2.length == 0)
			return easyFind(nums1);
		int all = nums1.length + nums2.length;

		if (all % 2 == 0) {
			return ((double)help(nums1, 0, nums2, 0, all / 2) + (double)help(nums1, 0, nums2, 0, all / 2 + 1)) / 2;
		} else {
			return help(nums1, 0, nums2, 0, all / 2 + 1);
		}

	}

	private int help(int[] nums1, int a, int[] nums2, int b, int k) {
		if (a >= nums1.length)
			return nums2[b + k - 1];
		if (b >= nums2.length)
			return nums1[a + k - 1];
		if (k == 1)
			return Math.min(nums1[a], nums2[b]);

		int nexta = a + k / 2 - 1;
		int nextb = b + k / 2 - 1;

		int mid1, mid2;

		if (nexta >= nums1.length)
			mid1 = Integer.MAX_VALUE;
		else
			mid1 = nums1[nexta];

		if (nextb >= nums2.length)
			mid2 = Integer.MAX_VALUE;
		else
			mid2 = nums2[nextb];

		if (mid1 > mid2) {
			return help(nums1, a, nums2, nextb + 1, k - k / 2);
		} else {
			return help(nums1, nexta + 1, nums2, b, k - k / 2);
		}
	}

	private double easyFind(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int len = nums.length;
		if (len % 2 == 0)
			return ((double) (nums[nums.length / 2]) + (double) (nums[nums.length / 2 - 1])) / 2;
		else
			return (double) nums[nums.length / 2];
	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int total = nums1.length + nums2.length;
		if (total % 2 == 0) {
			return (findKth(total / 2 + 1, nums1, nums2, 0, 0) + findKth(total / 2, nums1, nums2, 0, 0)) / 2.0;
		} else {
			return findKth(total / 2 + 1, nums1, nums2, 0, 0);
		}
	}

	public int findKth(int k, int[] nums1, int[] nums2, int s1, int s2) {
		if (s1 >= nums1.length)
			return nums2[s2 + k - 1];

		if (s2 >= nums2.length)
			return nums1[s1 + k - 1];

		if (k == 1)
			return Math.min(nums1[s1], nums2[s2]);

		int m1 = s1 + k / 2 - 1;
		int m2 = s2 + k / 2 - 1;

		int mid1 = m1 < nums1.length ? nums1[m1] : Integer.MAX_VALUE;
		int mid2 = m2 < nums2.length ? nums2[m2] : Integer.MAX_VALUE;

		if (mid1 < mid2) {
			return findKth(k - k / 2, nums1, nums2, m1 + 1, s2);
		} else {
			return findKth(k - k / 2, nums1, nums2, s1, m2 + 1);
		}
	}
}
