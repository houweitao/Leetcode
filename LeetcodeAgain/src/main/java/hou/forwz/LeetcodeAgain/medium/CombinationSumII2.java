//package hou.forwz.LeetcodeAgain.medium;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
///**
// * @author houweitao
// * @date 2016年10月7日下午7:18:55
// */
//
//public class CombinationSumII2 {
//	public static void main(String[] args) {
//		CombinationSumII2 com = new CombinationSumII2();
//		int[] cand = { 10, 1, 2, 7, 6, 1, 5 };
//		System.out.println(com.combinationSum2(cand, 8));
//	}
//
//	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//		List<List<Integer>> ret = new ArrayList<>();
//		List<Integer> tmp = new ArrayList<>();
//		Arrays.sort(candidates);
//		for (int i = 0; i < candidates.length; i++)
//			dfs(candidates, i, target, tmp, ret);
//		return ret;
//	}
//
//	private void dfs(int[] candidates, int pos, int target, List<Integer> tmp, List<List<Integer>> ret) {
//		if (pos == candidates.length)
//			return;
//		else if (candidates[pos] > target)
//			return;
//		else if (candidates[pos] == target) {
//			tmp.add(candidates[pos]);
//			ret.add(new ArrayList<>(tmp));
//			tmp.remove(tmp.size() - 1);
//		} else {
//			tmp.add(candidates[pos]);
//			for (int i = pos + 1; i < candidates.length; i++) {
//				if (candidates[i] == candidates[i - 1] && i != pos + 1)
//					continue;
//				dfs(candidates, i, target - candidates[pos], tmp, ret);
//			}
//			tmp.remove(tmp.size() - 1);
//		}
//	}
//}
