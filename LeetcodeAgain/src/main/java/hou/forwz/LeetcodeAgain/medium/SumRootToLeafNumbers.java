package hou.forwz.LeetcodeAgain.medium;

import hou.forwz.LeetcodeAgain.structure.TreeNode;

/**
 * @author houweitao
 * @date 2016年9月15日上午1:33:40
 */

public class SumRootToLeafNumbers {
	int sum = 0;

	public int sumNumbers(TreeNode root) {
		if (root == null)
			return 0;
		dfs(root, 0);
		return sum;
	}

	private void dfs(TreeNode root, int pre) {
		if (root == null)
			return;
		else if (root.left == null && root.right == null) {
			sum+=pre*10+root.val;
		}else{
			dfs(root.left,pre*10+root.val);
			dfs(root.right,pre*10+root.val);
		}
	}

}
