//package hou.forwz.Leetcode.medium;
//
//import hou.forwz.Leetcode.structure.ListNode;
//
///**
// * @author houweitao
// * @date 2016年7月15日下午11:54:41
// */
//
//public class ReverseLinkedListII {
//
//	public ListNode reverseBetween(ListNode head, int m, int n) {
//		if (m == n)
//			return head;
//
//		ListNode ret = new ListNode(-1);
//		ret.next = head;
//
//		ListNode p = ret, q = ret, move = head;
//		for (int i = 1; i <= n; i++) {
//			if (i == m - 1)
//				p = move;
//
//			if (i == n - 1)
//				q = move;
//
//			move = move.next;
//		}
//
//		if (m == 1)
//			p = ret;
//		if (n == 1)
//			q = ret;
//
//		ListNode mnext = p.next.next;
//		ListNode curm = p.next;
//		ListNode nnext = q.next.next;
//
//		if (m + 1 == n) {
//			p.next = q.next;
//			p.next.next = q;
//			q.next = nnext;
//		} else {
//			p.next = q.next;
//			p.next.next = mnext;
//
//			q.next = curm;
//			curm.next = nnext;
//		}
//		return ret.next;
//
//	}
//
//}
