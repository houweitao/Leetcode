package hou.forme.GooglePrepare.GooglePrepare.lock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hou.forme.GooglePrepare.GooglePrepare.structure.TreeNode;

// BinaryTreeVerticalOrderTraversal.java
// http://www.programcreek.com/2014/04/leetcode-binary-tree-vertical-order-traversal-java/
class BinaryTreeVerticalOrderTraversal {
	int min = 0, max = 0;

	List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> ret = new ArrayList<>();
		if (root == null)
			return ret;

		Map<Integer, List<Integer>> map = new HashMap<>();

		deal(root, 0, map);

		for (int i = min; i <= max; i++) {
			ret.add(map.get(i));
		}
		return ret;
	}

	void deal(TreeNode root, int num, Map<Integer, List<Integer>> map) {
		if (root == null)
			return;
		min = Math.min(min, num);
		max = Math.max(max, num);

		if (!map.containsKey(num)) {
			map.put(num, new ArrayList<Integer>());
		}
		map.get(num).add(root.val);

		deal(root.left, num - 1, map);
		deal(root.right, num = 1, map);
	}
}