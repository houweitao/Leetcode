package hou.forwz.Leetcode.medium;

import hou.forwz.Leetcode.structure.ListNode;

/**
 * @author houweitao
 * @date 2016年7月19日上午1:16:41
 */

public class SortList {
	public static void main(String[] args) {
		SortList sl = new SortList();
		ListNode node = new ListNode(2);
		node.next = new ListNode(8);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);

		System.out.println(sl.sortList(node).val);
	}

	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		else if(head.next.next==null){
			ListNode ret = new ListNode(-1);
			if(head.val>head.next.val){
				ret.next=head.next;ret.next.next=head;head.next=null;
				return ret.next;
			}else
				return head;
		}

		ListNode fast = head, low = head;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			low = low.next;
		}

		ListNode next = low.next;
		ListNode right = sortList(next);
		low.next = null;
		ListNode left = sortList(head);

		return merge(left, right);
	}

	private ListNode merge(ListNode left, ListNode right) {
		ListNode ret = new ListNode(-1);
		ListNode p = ret;

		while (left != null && right != null) {
			if (left.val <= right.val) {
				p.next = left;
				left = left.next;
			} else {
				p.next = right;
				right = right.next;
			}
			p = p.next;

		}

		if (left != null)
			p.next = left;
		if (right != null)
			p.next = right;

		return ret.next;
	}

}
