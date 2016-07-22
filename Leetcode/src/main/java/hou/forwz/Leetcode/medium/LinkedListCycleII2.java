package hou.forwz.Leetcode.medium;

import java.util.HashMap;
import java.util.Map;

import hou.forwz.Leetcode.structure.ListNode;

/**
 * @author houweitao
 * @date 2016年7月23日上午12:13:23
 */

public class LinkedListCycleII2 {

	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null)
			return null;

		ListNode fast = head, low = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			low = low.next;

			if (fast == low) {
				Map<ListNode, Integer> map = new HashMap<>();
				low = head;
				while (true) {
					if (map.containsKey(low)) {
						return low;
					} else
						map.put(low, 1);

					low = low.next;
				}
			}
		}
		return null;

	}

}
