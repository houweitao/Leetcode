//package hou.forwz.LeetcodeAgain.medium;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
///**
// * @author houweitao
// * @date 2016年9月15日下午9:18:37
// */
//
//public class SubsetsII {
//	public static void main(String[] args) {
//		SubsetsII sub = new SubsetsII();
//		int[] nums = { 1, 1, 3 };
//		System.out.println(sub.subsetsWithDup(nums));
//	}
//
//	public List<List<Integer>> subsetsWithDup(int[] nums) {
//		List<List<Integer>> ret = new ArrayList<>();
//		if (nums.length == 0)
//			return ret;
//		else {
//			Arrays.sort(nums);
//			List<Integer> tmp = new ArrayList<>();
//			dfs(nums, 0, tmp, ret);
//			return ret;
//		}
//	}
//
//	private void dfs(int[] nums, int pos, List<Integer> tmp, List<List<Integer>> ret) {
//		if (pos == nums.length - 1) {
//			tmp.add(nums[pos]);
//			ret.add(new ArrayList<>(tmp));
//			tmp.remove(tmp.size() - 1);
//		} else {
//			tmp.add(nums[pos]);
//			for (int i = pos+1 ; i < nums.length; i++) {
//				if (i != pos && nums[i] == nums[i - 1])
//					continue;
//				dfs(nums, pos + 1, tmp, ret);
//			}
//			tmp.remove(tmp.size()-1);
//		}
//
//	}
//
//}
