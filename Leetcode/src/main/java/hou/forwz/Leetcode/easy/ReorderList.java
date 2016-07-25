package hou.forwz.Leetcode.easy;

import hou.forwz.Leetcode.structure.ListNode;

/**
 * @author houweitao
 * @date 2016年7月25日下午11:33:37
 */

public class ReorderList {
	public static void main(String[] args) {
		ReorderList rl = new ReorderList();
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
//		node.next.next.next.next = new ListNode(5);
		rl.reorderList(node);
		rl.print(node);
	}

	private void print(ListNode node) {
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println();
	}

	public void reorderList(ListNode head) {
		if (head == null || head.next == null || head.next.next == null)
			return;

//		print(head);

		ListNode ret = new ListNode(-1);
		ret.next = head;

		ListNode low = ret, fast = ret;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			low = low.next;
		}

//		if (fast != null)
//			low = low.next;

		ListNode p = low.next;

		low.next = null;

		while (p != null) {
			ListNode help = p;
			p = p.next;

			help.next = low.next;
			low.next = help;
		}

//		print(head);
		
		p=low.next;
		low.next=null;

		ListNode node = head;
		while (p != null) {
			ListNode help=p;
			p=p.next;
			help.next=node.next;
			node.next=help;
			node=help;
			node=node.next;
		
		}

	}

}
