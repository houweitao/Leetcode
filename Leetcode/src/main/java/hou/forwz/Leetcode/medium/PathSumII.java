package hou.forwz.Leetcode.medium;

import java.util.ArrayList;
import java.util.List;

import hou.forwz.Leetcode.structure.TreeNode;

/**
 * @author houweitao
 * @date 2016年7月16日下午9:16:17
 */

public class PathSumII {

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> ret = new ArrayList<>();
		List<Integer> tmp = new ArrayList<>();

		help(root, sum, ret, tmp);

		return ret;
	}

	private void help(TreeNode root, int sum, List<List<Integer>> ret, List<Integer> tmp) {
		if (root == null)
			return;
		else if (root.val == sum) {
			if (root.left == null && root.right == null) {
				tmp.add(root.val);
				List<Integer> list = new ArrayList<>(tmp);
				ret.add(list);
				tmp.remove(tmp.size() - 1);
			} else {
				tmp.add(root.val);
				help(root.left, sum - root.val, ret, tmp);
				help(root.right, sum - root.val, ret, tmp);
				tmp.remove(tmp.size() - 1);
			}
		} else {
			tmp.add(root.val);
			help(root.left, sum - root.val, ret, tmp);
			help(root.right, sum - root.val, ret, tmp);
			tmp.remove(tmp.size() - 1);

		}

	}

}
