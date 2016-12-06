package hou.forme.GooglePrepare.GooglePrepare.easy;

import java.util.ArrayList;
import java.util.List;

import hou.forme.GooglePrepare.GooglePrepare.structure.TreeNode;

/**
 * @author houweitao
 * @date 2016年12月6日下午3:00:34
 * @end 2016年12月06日15:02:51
 */

public class BinaryTreePaths {

	public List<String> binaryTreePaths(TreeNode root) {
		List<String> ret = new ArrayList<>();
		if (root == null)
			return ret;

		dfs(root, root.val + "", ret);
		return ret;
	}

	private void dfs(TreeNode root, String pre, List<String> ret) {
		if (root == null)
			return;
		else if (root.left == null && root.right == null)
			ret.add(pre);
		else {
			if (root.left != null)
				dfs(root.left, pre + "->" + root.left.val, ret);
			if (root.right != null)
				dfs(root.right, pre + "->" + root.right.val, ret);
		}
	}

}
