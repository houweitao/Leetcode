package hou.forwz.Leetcode.hard;

/**
 * @author houweitao
 * @date 2016年8月8日上午2:18:15
 */

public class MedianOfTwoSortedArrays3 {
	public static void main(String[] args) {
		MedianOfTwoSortedArrays3 mt = new MedianOfTwoSortedArrays3();
		int[] nums1 = { 1, 2, 4, 6, 7, 8, 9 };
		int[] nums2 = { 3, 5, 7, 9, 22 };
		System.out.println(mt.findMedianSortedArrays(nums1, nums2));
		// System.out.println(mt.findMedianSortedArrays(nums1, nums2));
	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int len1 = nums1.length, len2 = nums2.length, sumLen = len1 + len2;
		if(len1>len2)
			return findMedianSortedArrays(nums2, nums1);
		if (nums1[len1 - 1] <= nums2[0]) {
		    if(len1==len2)
		        return (double)(nums1[len1-1]+nums2[0])/2;
			if (sumLen % 2 != 0) {
				return nums2[sumLen / 2 + 1 - len1];
			} else {
				return (nums2[sumLen / 2-len1-1] + nums2[sumLen / 2 -len1]) / 2.0;
			}
		}

		if (sumLen % 2 != 0) {
			return findKthSmallest(nums1, len1, 0, nums2, sumLen / 2 + 1);
		} else {
			return (findKthSmallest(nums1, len1, 0, nums2, sumLen / 2)
					+ findKthSmallest(nums1, len1, 0, nums2, sumLen / 2 + 1)) / 2.0;
		}

	}

	private double findKthSmallest(int[] nums1, int up, int down, int[] nums2, int k) {
		while (down <= up) {
			int mid = (down + up) / 2;

			int part = k - mid - 1;

			if (nums1[mid] <= nums2[part] && nums1[mid] >= nums2[part - 1])
				return nums1[mid];
			else if (nums1[mid] < nums2[part - 1])
				down = mid + 1;
			else
				up = mid - 1;

		}
		return -1;
	}

}
