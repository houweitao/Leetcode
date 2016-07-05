package hou.forwz.Leetcode.medium;

import hou.forwz.Leetcode.structure.ListNode;

/**
 * @author houweitao
 * @date 2016年7月5日下午10:12:54
 * @end 2016年07月05日22:24:12
 * @end 2016年07月05日23:09:18 好麻烦。。
 * @url https://leetcode.com/problems/add-two-numbers/
 */

public class AddTwoNumbers {
	int add = 0;

	public static void main(String[] args) {
		ListNode l1 = new ListNode(0);
		ListNode l2 = new ListNode(9);
		ListNode l3 = new ListNode(1);
		ListNode l4 = new ListNode(6);
		l2.next = l3;
		l3.next=l4;

		AddTwoNumbers at = new AddTwoNumbers();
		System.out.println(at.addTwoNumbers(l1, l2));

		// System.out.println(at.deal(123));

	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null)
			return null;
		else if (l1 == null)
			return l2;
		else if (l2 == null)
			return l1;
		else {
			return helpCount(l1, l2, add);

		}
	}

	private ListNode helpCount(ListNode l1, ListNode l2, int add) {
		ListNode p = l1, q = l2;
		ListNode ret = new ListNode(-1);
		ListNode help = ret;

		while (p != null && q != null) {
			int sum = p.val + q.val + add;

			ListNode cur = new ListNode(sum % 10);
			add = sum / 10;

			help.next = cur;
			help = help.next;

			p = p.next;
			q = q.next;
		}
		if (p == null && q == null) {
			if (add != 0) {
				ListNode last = deal(add);
				help.next = last;
			}
		} else if (p != null) {
			ListNode last = helpCount(p, add);
			help.next = last;

		} else if (q != null) {
			ListNode last = helpCount(q, add);
			help.next = last;

		}

		return ret.next;
	}

	private ListNode helpCount(ListNode l1, int add) {
		if (add == 0)
			return l1;
		else {
			ListNode node = new ListNode(add);
			return addTwoNumbers(l1, node);
		}
	}

	private ListNode deal(int n) {
		if (n < 10) {
			add = 0;

			return new ListNode(n);
		} else {
			ListNode ret = new ListNode(-1);
			ListNode help = ret;

			while (n > 0) {
				int num = n % 10;
				ListNode cur = new ListNode(num);

				help.next = cur;
				help = cur;
				n = n / 10;
			}
			return ret.next;
		}
	}
}
