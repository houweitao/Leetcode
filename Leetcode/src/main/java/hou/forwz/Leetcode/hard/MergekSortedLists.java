package hou.forwz.Leetcode.hard;

import hou.forwz.Leetcode.structure.ListNode;

/**
 * @author houweitao
 * @date 2016年7月8日下午8:21:48
 */

public class MergekSortedLists {

	public ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0)
			return null;
		else
			return help(lists, 0, lists.length - 1);
	}

	private ListNode help(ListNode[] lists, int begin, int end) {
		if (begin > end)
			return null;
		else if (begin == end)
			return lists[begin];
		else if (begin + 1 == end) {
			return merge(lists[begin], lists[end]);
		} else {
			int mid = (begin + end) / 2;
			ListNode left = help(lists, begin, mid);
			ListNode right = help(lists, mid + 1, end);

			return merge(left, right);
		}
	}

	private ListNode merge(ListNode left, ListNode right) {
		ListNode ret = new ListNode(-1);
		ListNode help = ret;

		ListNode p = left, q = right;
		while (p != null && q != null) {

			if (p.val < q.val) {
				help.next = p;
				help = help.next;
				p = p.next;
			} else {
				help.next = q;
				help = help.next;
				q = q.next;
			}

		}
		if (p != null)
			help.next = p;
		if (q != null)
			help.next = q;

		return ret.next;
	}

}
