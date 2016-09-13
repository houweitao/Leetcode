package hou.forwz.LeetcodeAgain.medium;

import java.util.ArrayList;
import java.util.List;

import hou.forwz.LeetcodeAgain.structure.TreeNode;

/**
 * @author houweitao
 * @date 2016年9月14日上午1:56:16
 */

public class UniqueBinarySearchTreesII {

	public List<TreeNode> generateTrees(int n) {
		List<TreeNode> ret = new ArrayList<TreeNode>();
		if (n < 1)
			return ret;
		NodeList[][] dp = new NodeList[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			dp[i][i] = new NodeList();
			dp[i][i].list.add(new TreeNode(i));
		}

		for (int i = 1; i < n; i++) {
			TreeNode one = new TreeNode(i);
			one.right = new TreeNode(i + 1);
			TreeNode two = new TreeNode(i + 1);
			two.left = new TreeNode(i);
			dp[i][i + 1] = new NodeList();
			dp[i][i + 1].add(one);
			dp[i][i + 1].add(two);
		}

		for (int i = n; i >= 1; i--) {
			for (int j = 2; j + i <= n; j++) {
				dp[i][i + j] = generate(dp, i, i + j);
			}
		}

		return dp[1][n].list;
	}

	private NodeList generate(NodeList[][] map, int begin, int end) {
		NodeList nodeList = new NodeList();
		for (int i = begin; i <= end; i++) {
			NodeList left = i == begin ? null : map[begin][i - 1];
			NodeList right = i == end ? null : map[i + 1][end];

			if (left == null) {
				for (TreeNode r : right.list) {
					TreeNode cur = new TreeNode(i);
					cur.right = r;
					nodeList.list.add(cur);
				}
			} else if (right == null) {
				for (TreeNode l : left.list) {
					TreeNode cur = new TreeNode(i);
					cur.left = l;
					nodeList.list.add(cur);
				}
			} else {
				for (TreeNode l : left.list) {
					for (TreeNode r : right.list) {
						TreeNode cur = new TreeNode(i);
						cur.left = l;
						cur.right = r;
						nodeList.list.add(cur);
					}
				}
			}
		}

		return nodeList;
	}

	class NodeList {
		List<TreeNode> list;

		public NodeList() {
			list = new ArrayList<>();
		}

		public void add(TreeNode e) {
			list.add(e);
		}
	}
}
