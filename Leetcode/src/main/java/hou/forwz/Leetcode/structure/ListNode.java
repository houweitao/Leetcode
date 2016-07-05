package hou.forwz.Leetcode.structure;

/**
 * @author houweitao
 * @date 2016年7月5日下午10:13:33
 */

public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int x) {
		val = x;
	}

	@Override
	public String toString() {
		String ret = "";

		ListNode cur = this;

		while (cur != null) {
			ret = ret + cur.val + "->";

			cur = cur.next;
		}

		return ret;
	}
}
