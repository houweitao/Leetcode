package hou.forwz.Leetcode.medium;

import hou.forwz.Leetcode.structure.ListNode;

/**
 * @author houweitao
 * @date 2016年7月25日上午2:02:10
 */

public class OddEvenLinkedList2 {
	// 其实写麻烦了。不用多一次判断的 2016年07月25日02:25:23
	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode ret = new ListNode(-1);
		ListNode help = new ListNode(-1);

		ret.next = help;

		help.next = head;
		ListNode oddLast = ret, evenFirst = help, evenLast = help;

		ListNode p = head;

		while (p != null && p.next != null) {
			ListNode tmp = p;
			p = p.next.next;

			evenLast.next = tmp.next;
			evenLast = evenLast.next;

			oddLast.next = tmp;
			tmp.next = evenFirst;
			oddLast = oddLast.next;
		}

		if (p != null) {
			evenLast.next = null;
			oddLast.next = p;
			p.next = evenFirst;
			oddLast = oddLast.next;

		}

		oddLast.next = oddLast.next;

		return ret.next;

	}
}
