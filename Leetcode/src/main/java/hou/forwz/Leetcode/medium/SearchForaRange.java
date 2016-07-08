//package hou.forwz.Leetcode.medium;
//
///**
// * @author houweitao
// * @date 2016年7月8日下午11:00:58
// */
//
//public class SearchForaRange {
//
//	public int[] searchRange(int[] nums, int target) {
//		int start = findLeft(nums, target);
//		int end = findRight(nums, target);
//		return new int[] { start, end };
//	}
//
//	private int findRight(int[] nums, int target) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	private int findLeft(int[] nums, int target) {
//		int left = 0, right = nums.length - 1;
//		int ret = -1;
//		while (left <= right) {
//			int mid = (left + right) / 2;
//
//			if (nums[mid] > target) {
//				left = mid + 1;
//			} else if (nums[mid] < target) {
//				right = mid - 1;
//			} else
//				ret = mid;
//		}
//
//		return ret;
//	}
//
//}
