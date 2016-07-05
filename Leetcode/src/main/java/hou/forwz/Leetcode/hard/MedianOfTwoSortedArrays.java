//package hou.forwz.Leetcode.hard;
//
///**
// * @author houweitao
// * @date 2016年7月5日下午11:31:01
// */
//
//public class MedianOfTwoSortedArrays {
//	public static void main(String[] args) {
//		MedianOfTwoSortedArrays mt = new MedianOfTwoSortedArrays();
//
//		int[] nums = { 1, 3, 4, 5, 6, 8 };
//
//		System.out.println(mt.getPost(nums, 5));
//	}
//
//	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//		int len1 = nums1.length;
//		int len2 = nums2.length;
//
//		return 0;
//	}
//
//	int getTar(int[] nums1, int[] nums2, int tar) {
//
//		int left = 0, right = nums1.length;
//
//		while (left < right) {
//			int mid = (left + right) / 2 + 1;
//
//		}
//
//	}
//
//	int getPost(int[] nums, int tar) {
//		if (tar < nums[0])
//			return -1;
//		else if (tar > nums[nums.length - 1])
//			return -2;
//		else {
//			int left = 0, right = nums.length - 1;
//
//			while (left < right) {
//				if (left == right) {
//					if (tar < nums[left])
//						return left - 1;
//					else if (tar == nums[left])
//						return left;
//					else
//						return right;
//				}
//
//				if (left + 1 == right) {
//					if (tar < nums[left])
//						return left - 1;
//					else if (tar >= nums[left] && tar <= nums[right])
//						return left;
//					else
//						return right;
//				} else {
//					int mid = (left + right) / 2 + 1;
//
//					if (tar == nums[mid]) {
//						return mid;
//					} else if (tar < nums[mid]) {
//						right = mid - 1;
//					} else {
//						left = mid + 1;
//					}
//
//				}
//
//			}
//
//			return 0;
//
//		}
//	}
//
//}
