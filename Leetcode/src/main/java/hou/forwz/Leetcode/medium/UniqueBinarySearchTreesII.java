package hou.forwz.Leetcode.medium;

import java.util.ArrayList;
import java.util.List;

import hou.forwz.Leetcode.structure.TreeNode;

/**
 * @author houweitao
 * @date 2016年7月13日上午12:27:17
 */

public class UniqueBinarySearchTreesII {
	public List<TreeNode> generateTrees(int n) {
		List<TreeNode> list=new ArrayList<>();
		
		if (n < 1)
			return list;

		NodeList[][] map = new NodeList[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			NodeList tmp = new NodeList();
			tmp.list.add(new TreeNode(i));
			map[i][i] = tmp;
		}

		for (int i = 1; i < n; i++) {
			NodeList tmp = new NodeList();
			TreeNode node1 = new TreeNode(i);
			TreeNode node2 = new TreeNode(i + 1);
			TreeNode node3 = new TreeNode(i);
			TreeNode node4 = new TreeNode(i + 1);

			node1.right = node2;
			node4.left = node3;

			tmp.list.add(node4);
			tmp.list.add(node1);

			map[i][i + 1] = tmp;
		}

		for (int i = n; i >= 1; i--) {
			for (int j = i + 2; j <= n; j++) {
				map[i][j] = generate(map, i, j);
			}
		}

		return map[1][n].list;

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

		NodeList(List<TreeNode> list) {
			this.list = list;
		}

		NodeList() {
			list = new ArrayList<>();
		}
	}
}
