package hou.forwz.Leetcode.medium;

import hou.forwz.Leetcode.structure.ListNode;

/**
 * @author houweitao
 * @date 2016年7月12日上午12:52:05
 */

public class RotateList {
	public static void main(String[] args) {
		RotateList rl = new RotateList();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);

		System.out.println(rl.rotateRight(head, 2));
	}

	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null || k == 0)
			return head;

		ListNode p = head;
		ListNode q = head;
		int size = 1;
		while (q.next != null) {
			size++;
			q=q.next;
		}

		int step = k % size;
		if (step == 0)
			return head;

		step = size - step;

		q.next = p;
		for (int i = 0; i < step; i++) {
			p = p.next;
			q = q.next;
		}

		q.next = null;
		return p;

	}

}
