package hou.forme.GooglePrepare.GooglePrepare.hard;

import hou.forme.GooglePrepare.GooglePrepare.structure.ListNode;

/**
 * @author houweitao
 * @date 2016年12月5日下午3:56:02
 * @end 2016年12月05日16:06:07
 */

public class MergeKSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0)
			return null;
		return merge(lists, 0, lists.length - 1);
	}

	private ListNode mergeTwo(ListNode left, ListNode right) {
		if (left == null)
			return right;
		else if (right == null)
			return left;
		else {
			ListNode l = left, r = right;
			ListNode ret = new ListNode(-1);

			ListNode head = ret;
			while (l != null && r != null) {
				if (l.val > r.val) {
					head.next = r;
					head = head.next;
					r = r.next;
				} else {
					head.next = l;
					head = head.next;
					l = l.next;
				}
			}

			if (l != null)
				head.next = l;
			if (r != null)
				head.next = r;

			return ret.next;
		}
	}

	private ListNode merge(ListNode[] lists, int left, int right) {
		if (left == right)
			return lists[left];
		else if (left < right) {
			int mid = left + (right - left) / 2;
			return mergeTwo(merge(lists, left, mid), merge(lists, mid + 1, right));
		} else
			return null;
	}
}
