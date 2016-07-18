package hou.forwz.Leetcode.medium;

import hou.forwz.Leetcode.structure.ListNode;

/**
 * @author houweitao
 * @date 2016年7月19日上午1:39:22
 */

public class InsertionSortList {
	public static void main(String[] args) {
		InsertionSortList is = new InsertionSortList();
		ListNode node = new ListNode(5);
		node.next = new ListNode(8);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);

		System.out.println(is.insertionSortList(node).val);
	}

	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		else {
			ListNode ret = new ListNode(Integer.MIN_VALUE);
			while (head != null) {
				ListNode p = ret;
				ListNode next = head.next;
				deal(p, head);

				head = next;

			}

			return ret.next;

		}
	}

	private void deal(ListNode p, ListNode head) {
		if (p.next == null) {
			p.next = head;
			head.next = null;
		} else {
			while (p.next != null && p.val < head.val && p.next.val < head.val) {
				p = p.next;
			}
			ListNode tmp = p.next;
			p.next = head;
			head.next = tmp;
		}

	}

}
