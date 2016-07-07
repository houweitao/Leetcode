package hou.forwz.Leetcode.easy;

import hou.forwz.Leetcode.structure.ListNode;

/**
 * @author houweitao
 * @date 2016年7月8日上午12:52:13
 */

public class MergeTwoSortedLists {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		else if (l2 == null)
			return l1;
		else {
			ListNode p = l1;
			ListNode q = l2;
			ListNode ret = new ListNode(-1);
			ListNode co = ret;

			while (p != null && q != null) {
				if (p.val < q.val) {
					co.next = p;
					co = co.next;

					p = p.next;
				} else {
					co.next = q;
					co = co.next;

					q = q.next;
				}
			}

			if (p != null)
				co.next = p;

			if (q != null)
				co.next = q;

			return ret.next;
		}
	}

}
