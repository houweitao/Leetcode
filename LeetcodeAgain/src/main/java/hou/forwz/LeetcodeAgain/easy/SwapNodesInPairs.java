package hou.forwz.LeetcodeAgain.easy;

import hou.forwz.LeetcodeAgain.structure.ListNode;

/**
 * @author houweitao
 * @date 2016年9月30日下午6:21:26
 */

public class SwapNodesInPairs {
	public static void main(String[] args) {
		SwapNodesInPairs sn = new SwapNodesInPairs();
		sn.init();
	}

	private void init() {
		ListNode test = build("12345");
		print(test);
		print(swapPairs(test));
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

	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode ret = new ListNode(-1);
		ListNode p = ret;
		ListNode q = head;

		while (q != null && q.next != null) {
			ListNode next = q.next.next;
			ListNode sec = q.next;
			p.next = sec;
			sec.next = q;
			p = q;
			q = next;
		}
		p.next = q;
		
		return ret.next;
	}

}
