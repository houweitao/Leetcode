package hou.forwz.Leetcode.hard;

/**
 * @author houweitao
 * @date 2016年8月7日下午11:55:11
 */

public class MedianOfTwoSortedArrays2 {
	public static void main(String[] args) {
		MedianOfTwoSortedArrays2 mt = new MedianOfTwoSortedArrays2();
		int[] nums1 = { 1, 3 };
		int[] nums2 = { 2 };
		System.out.println(mt.findMedianSortedArraysMe(nums1, nums2));
	}


	public double findMedianSortedArraysMe(int[] nums1, int[] nums2) {
		int s1 = nums1.length;
		int s2 = nums2.length;
		int size = s1 + s2;
		if (s1 > s2) {
			return findMedianSortedArraysMe(nums2, nums1);
		}

		int low = 0, high = 2 * s1;
		int mid1, mid2;
		int l1, l2, r1, r2;

		while (low <= high) {
			mid1 = (low + high) >> 1;
			mid2 = size - mid1;
			
//			System.out.println(mid1+","+mid2);


			l1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[(mid1 - 1) / 2];
			r1 = (mid1 == s1 * 2) ? Integer.MAX_VALUE : nums1[mid1 / 2];
			l2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[(mid2 - 1) / 2];
			r2 = (mid2 == s2 * 2) ? Integer.MAX_VALUE : nums2[mid2 / 2];

			if (l1 > r2) {
				high = mid1 - 1;
			} else if (l2 > r1) {
				low = mid1 + 1;
			} else
				return (double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
		}
		return -1;
	}

	public int findKthSmallest(int[] a, int m, int begin1, int[] b, int n, int begin2, int k) {

		if (m > n)
			return findKthSmallest(b, n, begin2, a, m, begin1, k);
		if (m == 0)
			return b[begin2 + k - 1];
		if (k == 1)
			return Math.min(a[begin1], b[begin2]);
		int partA = Math.min(k / 2, m), partB = k - partA;
		if (a[begin1 + partA - 1] == b[begin2 + partB - 1])
			return a[begin1 + partA - 1];
		else if (a[begin1 + partA - 1] > b[begin2 + partB - 1])
			return findKthSmallest(a, m, begin1, b, n - partB, begin2 + partB, k - partB);
		else
			return findKthSmallest(a, m - partA, begin1 + partA, b, n, begin2, k - partA);

	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int len1 = nums1.length, len2 = nums2.length, sumLen = len1 + len2;
		if (sumLen % 2 != 0) {
			return findKthSmallest(nums1, len1, 0, nums2, len2, 0, sumLen / 2 + 1);
		} else {
			return (findKthSmallest(nums1, len1, 0, nums2, len2, 0, sumLen / 2)
					+ findKthSmallest(nums1, len1, 0, nums2, len2, 0, sumLen / 2 + 1)) / 2.0;
		}

	}
}
