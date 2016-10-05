package hou.forwz.LeetcodeAgain.hard;

import hou.forwz.LeetcodeAgain.structure.ListNode;

/**
 * @author houweitao
 * @date 2016年9月30日下午6:37:51
 */

public class ReverseNodesInKGroup {
	public static void main(String[] args) {
		ReverseNodesInKGroup rn = new ReverseNodesInKGroup();
		rn.init();
	}

	private void init() {
		ListNode test = build("12345678");
		print(test);
		print(reverseKGroup(test, 3));
	}

	private void print(ListNode head) {
		if (head == null)
			return;
		StringBuilder sb = new StringBuilder();
		while (head != null) {
			sb.append(head.val + "->");
			head = head.next;
		}
		System.out.println(sb.toString());
	}

	private ListNode build(String str) {
		ListNode ret = new ListNode(-1);
		ListNode p = ret;
		for (int i = 0; i < str.length(); i++) {
			p.next = new ListNode(str.charAt(i) - '0');
			p = p.next;
		}

		return ret.next;
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		if (k < 2 || head == null || head.next == null)
			return head;

		int count = 0;
		ListNode p = head;
		while (p != null) {
			count++;
			if (count > k)
				break;
			p = p.next;
		}

		if (count < k)
			return head;
		else {
			ListNode ret = new ListNode(-1);
			ListNode help = ret;
			ListNode record = head;
			p = head;
			for (int i = 0; i < k; i++) {
				ListNode next = p.next;
				ListNode tmp = help.next;
				help.next = p;
				p.next = tmp;
				p = next;
			}

			ListNode nextNode = reverseKGroup(p, k);
			record.next = nextNode;

			return ret.next;
		}
	}

}
