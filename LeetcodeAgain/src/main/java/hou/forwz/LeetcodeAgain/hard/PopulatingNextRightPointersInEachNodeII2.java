package hou.forwz.LeetcodeAgain.hard;

import hou.forwz.LeetcodeAgain.structure.TreeLinkNode;

/**
 * @author houweitao
 * @date 2016年9月15日上午2:08:00
 */

public class PopulatingNextRightPointersInEachNodeII2 {
	public void connect(TreeLinkNode root) {
		TreeLinkNode head = new TreeLinkNode(-1);
		head.next = root;

		TreeLinkNode p = head.next;

		while (p != null) {
			TreeLinkNode line = new TreeLinkNode(-1);
			TreeLinkNode q = line;

			while (p != null) {
				if (p.left != null) {
					q.next = p.left;
					q = q.next;
				}
				if (p.right != null) {
					q.next = p.right;
					q = q.next;
				}
				p = p.next;
			}

			head = line;
			p = head.next;
		}

	}
}
