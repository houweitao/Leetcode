package hou.forwz.Leetcode.easy;

import hou.forwz.Leetcode.structure.ListNode;

/**
 * @author houweitao
 * @date 2016年7月23日上午1:30:34
 */

public class DeleteNodeInALinkedList {

	public void deleteNode(ListNode node) {
		ListNode help = new ListNode(-1);
		help.next = node;

		while (help.next != null) {
			if (help.next == node) {
				help.next = help.next.next;
			}
		}
		
		
	}

}
