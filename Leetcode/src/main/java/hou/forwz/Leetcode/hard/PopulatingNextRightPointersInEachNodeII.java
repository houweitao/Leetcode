package hou.forwz.Leetcode.hard;

import hou.forwz.Leetcode.structure.TreeLinkNode;

/**
 * @author houweitao
 * @date 2016年7月16日下午11:13:25
 */

public class PopulatingNextRightPointersInEachNodeII {
	public static void main(String[] args) {
		PopulatingNextRightPointersInEachNodeII pn = new PopulatingNextRightPointersInEachNodeII();
		TreeLinkNode node = new TreeLinkNode(1);
		TreeLinkNode left = new TreeLinkNode(1);
		TreeLinkNode right = new TreeLinkNode(1);

		node.left = left;
		node.right = right;
		pn.connect(node);

	}

	public void connect(TreeLinkNode root) {
		TreeLinkNode help = new TreeLinkNode(-1);
		help.next = root;

		while (help.next != null) {
			TreeLinkNode cur = new TreeLinkNode(-1);
			TreeLinkNode line = cur;
			TreeLinkNode first = help.next;

			while (first != null) {
				if (first.left != null) {
					line.next = first.left;
					line = line.next;
				}
				if (first.right != null) {
					line.next = first.right;
					line = line.next;
				}
				first = first.next;
			}

			help=cur;

		}
	}

}
