package hou.forwz.LeetcodeAgain.hard;

import hou.forwz.LeetcodeAgain.structure.ListNode;

/**
 * @author houweitao
 * @date 2016年9月6日下午4:01:58
 */

public class MergeKSortedLists {

	public ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0)
			return null;
		else if (lists.length == 1)
			return lists[0];
		else
			return help(lists, 0, lists.length - 1);
	}

	private ListNode help(ListNode[] lists, int begin, int end) {
		if (begin == end)
			return lists[begin];
		else if (begin + 1 == end)
			return merge(lists[begin], lists[end]);
		else {
			int mid = (begin + end) / 2;
			return merge(help(lists, begin, mid), help(lists, mid + 1, end));
		}
	}

	private ListNode merge(ListNode left, ListNode right) {
		ListNode ret = new ListNode(-1);
		ListNode help = ret;
		while (left != null && right != null) {
			if (left.val < right.val) {
				help.next = new ListNode(left.val);
				help = help.next;
				left = left.next;
			} else if (left.val > right.val) {
				help.next = new ListNode(right.val);
				help = help.next;
				right = right.next;
			} else {
				help.next = new ListNode(right.val);
				help = help.next;
				help.next = new ListNode(right.val);
				help = help.next;
				left = left.next;
				right = right.next;
			}
		}

		if (left != null)
			help.next = left;
		if (right != null)
			help.next = right;

		return ret.next;
	}

}
