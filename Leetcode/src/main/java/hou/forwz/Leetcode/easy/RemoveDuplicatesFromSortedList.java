package hou.forwz.Leetcode.easy;

import hou.forwz.Leetcode.structure.ListNode;

/**
 * @author houweitao
 * @date 2016年7月15日下午10:06:48
 */

public class RemoveDuplicatesFromSortedList {

	public ListNode deleteDuplicates(ListNode head) {
		ListNode p = head;
		while (p != null) {
			if (p.next == null)
				return head;
			if (p.val == p.next.val) {
				p.next = p.next.next;
			} else
				p = p.next;
		}
		return head;
	}

}
