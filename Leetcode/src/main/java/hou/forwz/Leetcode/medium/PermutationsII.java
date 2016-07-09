//package hou.forwz.Leetcode.medium;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
///**
// * @author houweitao
// * @date 2016年7月10日上午1:42:44
// */
//
//public class PermutationsII {
//
//	public static void main(String[] args) {
//		PermutationsII p = new PermutationsII();
//		int[] nums = { 1, 1, 3, 3 };
//		System.out.println(p.permuteUnique(nums));
//	}
//
//	public List<List<Integer>> permuteUnique(int[] nums) {
//		Arrays.sort(nums);
//		return help(nums, 0);
//	}
//
//	private void swap(int[] nums, int i, int j) {
//		int tmp = nums[i];
//		nums[i] = nums[j];
//		nums[j] = tmp;
//	}
//
//	private List<List<Integer>> help(int[] nums, int begin) {
//		List<List<Integer>> ret = new ArrayList<>();
//		if (nums.length == begin + 1) {
//			List<Integer> tmp = new ArrayList<>();
//			tmp.add(nums[begin]);
//			ret.add(tmp);
//			return ret;
//		} else {
//			List<Integer> list = deal(nums, begin);
//
//			for (int i : list) {
//				swap(nums, begin, i);
//
//				List<List<Integer>> next = help(nums, begin + 1);
//				for (int j = 0; j < next.size(); j++) {
//					List<Integer> tmp = new ArrayList<>();
//					tmp.add(nums[begin]);
//					tmp.addAll(next.get(j));
//					ret.add(tmp);
//				}
//
//				swap(nums, begin, i);
//			}
//
//			return ret;
//		}
//
//	}
//
//	private List<Integer> deal(int[] nums, int begin) {
//		List<Integer> ret = new ArrayList<>();
//		ret.add(begin);
//		for (int i = begin + 1; i < nums.length; i++) {
//			if (nums[i] != nums[i - 1])
//				ret.add(i);
//		}
//
//		return ret;
//	}
//
//}
