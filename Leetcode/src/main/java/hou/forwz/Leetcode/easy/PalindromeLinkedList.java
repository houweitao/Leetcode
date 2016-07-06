package hou.forwz.Leetcode.easy;

import java.util.ArrayList;
import java.util.List;

import hou.forwz.Leetcode.structure.ListNode;

/**
 * @author houweitao
 * @date 2016年7月6日下午9:09:45
 */

public class PalindromeLinkedList {

	public static void main(String[] args) {
		PalindromeLinkedList pl = new PalindromeLinkedList();
		pl.init();
	}

	void init() {
		NewString ns1 = new NewString(-2);
		NewString ns2 = new NewString(1);
		NewString ns3 = new NewString(-2);

		List<NewString> list = new ArrayList<>();

		list.add(ns1);
		list.add(ns2);
		list.add(ns3);

		System.out.println(is(list));
	}

	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null)
			return true;

		List<NewString> list = new ArrayList<>();
		while (head != null) {
			list.add(new NewString(head.val));
			head = head.next;
		}

		System.out.println(list);

		return is(list);
	}

	private boolean is(List<NewString> list) {
		int left = 0, right = list.size() - 1;

		while (left <= right) {
			if (!(list.get(left).str.equals(list.get(right).str))) {
//				System.out.println("not");
				return false;
			}
			left++;
			right--;
		}
		System.out.println("over");
		return true;
	}

	class NewString {
		String str;

		public NewString(int str) {
			this.str = str + "";
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof NewString) {
				NewString tmp = (NewString) (obj);
				return str == tmp.str;
			} else
				return false;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return str;
		}
	}
}
