package hou.forwz.Leetcode.medium;

import hou.forwz.Leetcode.structure.TreeLinkNode;

/**
 * @author houweitao
 * @date 2016年7月16日下午11:38:15
 */

public class PopulatingNextRightPointersInEachNode {

	public void connect(TreeLinkNode root) {
		TreeLinkNode help = new TreeLinkNode(-1);
		help.next = root;

		TreeLinkNode p = root;
		while (p != null) {
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

			p = cur.next;
			help = cur;

		}
	}

}
