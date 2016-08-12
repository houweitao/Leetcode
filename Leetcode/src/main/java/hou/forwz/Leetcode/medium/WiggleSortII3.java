//package hou.forwz.Leetcode.medium;
//
///**
// * @author houweitao
// * @date 2016年8月12日下午11:25:31
// */
//
//public class WiggleSortII3 {
//	public static void main(String[] args) {
//		WiggleSortII3 ws = new WiggleSortII3();
//		int[] nums = { 3, 1, 4, 6, 2, 5, 7 };
//		System.out.println(ws.get(nums, 0, nums.length - 1, 3));
//	}
//
//	public void wiggleSort(int[] nums) {
//		int median = findKthLargest(nums, (nums.length + 1) / 2);
//		int n = nums.length;
//
//		int left = 0, i = 0, right = n - 1;
//
//		while (i <= right) {
//
//			if (nums[newIndex(i, n)] > median) {
//				swap(nums, newIndex(left++, n), newIndex(i++, n));
//			} else if (nums[newIndex(i, n)] < median) {
//				swap(nums, newIndex(right--, n), newIndex(i, n));
//			} else {
//				i++;
//			}
//		}
//
//	}
//
//	private int findKthLargest(int[] nums, int i) {
//		return get(nums, 0, nums.length - 1, i);
//	}
//
//	private int newIndex(int index, int n) {
//		return (1 + 2 * index) % (n | 1);
//	}
//
//	public void wiggleSortMe(int[] nums) {
//		int med = nums.length / 2;
//		int tar = get(nums, 0, nums.length - 1, med);
//
//		int pos = med - 1;
//		for (int i = 0; i <= pos;) {
//			if (nums[i] == tar)
//				swap(nums, i, pos--);
//			else
//				i++;
//		}
//
//		pos = med + 1;
//		for (int i = nums.length - 1; i >= pos;) {
//			if (nums[i] == tar)
//				swap(nums, i, pos++);
//			else
//				i--;
//		}
//
//	}
//
//	private void swap(int[] nums, int i, int j) {
//		int tmp = nums[i];
//		nums[i] = nums[j];
//		nums[j] = tmp;
//	}
//
//	private int get(int[] nums, int begin, int end, int mid) {
//		print(nums);
//		System.out.println(begin + "," + end + ": " + mid);
//		System.out.println();
//
//		int head = nums[begin];
//		int left = begin, right = end;
//
//		if (begin == end)
//			return nums[begin];
//
//		while (left < right) {
//			while (nums[right] >= head && right > left)
//				right--;
//			nums[left] = nums[right];
//
//			while (nums[left] < head && left < right) {
//				left++;
//			}
//			nums[right] = nums[left];
//		}
//
//		nums[left] = head;
//		System.out.println(left);
//
//		if (left == mid)
//			return nums[left];
//		else if (left < mid)
//			return get(nums, left + 1, end, mid - left);
//		else
//			return get(nums, begin, left, mid);
//	}
//
//	private void print(int[] nums) {
//		for (int n : nums)
//			System.out.print(n + ",");
//		System.out.println();
//	}
//
//}
