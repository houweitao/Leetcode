package hou.forwz.Leetcode.medium;

import hou.forwz.Leetcode.structure.ListNode;

/**
 * @author houweitao
 * @date 2016年7月25日上午1:42:06
 */

public class OddEvenLinkedList {

	// 理解错了题意。不过也算另外一种锻炼 2016年07月25日02:25:19
	public ListNode oddEvenList(ListNode head) {
		ListNode ret = new ListNode(-1);
		ListNode even = new ListNode(0);

		ListNode oddLast = ret;
		ListNode evenFirst = even, evenLast = even;

		ret.next = even;

		ListNode p = head;

		while (p != null) {
			if (p.val % 2 == 0) {
				evenLast.next = p;
				evenLast = evenLast.next;
			} else {
				evenLast.next = p.next;

				oddLast.next = p;
				oddLast = oddLast.next;

				p.next = evenFirst;

				p = evenLast.next;
			}
		}

		oddLast.next = oddLast.next.next;

		return ret.next;
	}

}
