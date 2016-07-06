package hou.forwz.Leetcode.easy;

import hou.forwz.Leetcode.structure.ListNode;

/**
 * @author houweitao
 * @date 2016年7月6日下午9:38:08
 */

public class ReverseLinkedList {

	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		else {

			ListNode ret = new ListNode(-1);

			while (head != null) {
				ListNode cur = head;
				head = head.next;

				ListNode help = ret.next;
				ret.next = cur;
				cur.next = help;
			}

			return ret.next;
		}
	}

}
