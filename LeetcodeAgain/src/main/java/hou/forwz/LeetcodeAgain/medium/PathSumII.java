package hou.forwz.LeetcodeAgain.medium;

import java.util.ArrayList;
import java.util.List;

import hou.forwz.LeetcodeAgain.structure.TreeNode;

/**
 * @author houweitao
 * @date 2016年9月14日下午5:48:33
 */

public class PathSumII {

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> ret = new ArrayList<>();
		if (root == null)
			return ret;
		else {
			List<Integer> tmp = new ArrayList<>();
			dfs(root, tmp, ret, sum);
			return ret;
		}
	}

	void dfs(TreeNode root, List<Integer> tmp, List<List<Integer>> ret, int tar) {
		if (tar < 0)
			return;
		else if (root == null)
			return;
		// else if (root.left == null && root.right == null) {
		// if (tar == root.val) {
		// tmp.add(root.val);
		// ret.add(new ArrayList<Integer>(tmp));
		// tmp.remove(tmp.size() - 1);
		// }
		// }
		else {
			if (root.val == tar) {
				if (root.left == null && root.right == null) {
					tmp.add(root.val);
					ret.add(new ArrayList<Integer>(tmp));
					tmp.remove(tmp.size() - 1);
				}
			} else {
				tmp.add(root.val);
				dfs(root.left, tmp, ret, tar - root.val);
				dfs(root.right, tmp, ret, tar - root.val);
				tmp.remove(tmp.size() - 1);
			}
		}
	}

}
