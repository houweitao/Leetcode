package hou.forwz.Leetcode.medium;

import hou.forwz.Leetcode.structure.ListNode;

/**
 * @author houweitao
 * @date 2016年8月10日下午10:35:58
 */

public class LinkedListRandomNode {
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			System.out.println((int)(Math.random()*3));
		}
	}

	public class Solution {
		int len;
		ListNode node;

		/**
		 * @param head
		 *            The linked list's head. Note that the head is guanranteed
		 *            to be not null, so it contains at least one node.
		 */
		public Solution(ListNode head) {
			node = head;
			len = 0;
			ListNode tmp = node;

			while (tmp.next != null) {
				tmp = tmp.next;
				len++;
			}
			len++;
		}

		/** Returns a random node's value. */
		public int getRandom() {
			int pos = (int)(Math.random()*len);
			ListNode tmp = node;
			while (pos > 0) {
				tmp = tmp.next;
				pos--;
			}
			return tmp.val;
		}
	}

	/**
	 * Your Solution object will be instantiated and called as such: Solution
	 * obj = new Solution(head); int param_1 = obj.getRandom();
	 */
}
