package hou.forwz.LeetcodeAgain.hard;

import hou.forwz.LeetcodeAgain.structure.TreeLinkNode;

/**
 * @author houweitao
 * @date 2016年9月15日上午1:38:01
 */

public class PopulatingNextRightPointersInEachNodeII {

	public void connect(TreeLinkNode root) {
		TreeLinkNode head = new TreeLinkNode(-1);
		head.next = root;

		TreeLinkNode p;

		while (true) {
			p = head.next;
			TreeLinkNode line = new TreeLinkNode(-1);
//			head.left = tmp;

			boolean find = false;
			while (p != null) {
				if (p.left != null) {
					line.next = p.left;
					line = line.next;
					find = true;
				}
				if (p.right != null) {
					line.next = p.right;
					line = line.next;
					find = true;
				}
				p=p.next;
			}

			if (!find)
				break;

			head = line;
		}
	}

}
