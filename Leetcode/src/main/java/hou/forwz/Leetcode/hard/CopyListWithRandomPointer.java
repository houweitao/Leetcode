package hou.forwz.Leetcode.hard;

import java.util.HashMap;
import java.util.Map;

import hou.forwz.Leetcode.structure.RandomListNode;

/**
 * @author houweitao
 * @date 2016年7月18日上午12:29:15
 */

public class CopyListWithRandomPointer {
	Map<Integer, RandomListNode> line = new HashMap<>();
	Map<Integer, RandomListNode> random = new HashMap<>();

	public RandomListNode copyRandomList2(RandomListNode head) {
		if (head == null)
			return null;
		else {
			RandomListNode ret = new RandomListNode(-1);
			RandomListNode q = ret;
			ret.next = head;
			RandomListNode p = head;

			while (p != null) {
				q.next = new RandomListNode(p.label);
				p = p.next;
				q = q.next;
				line.put(q.label, q);
			}

			p = head;
			while (p != null) {
				if (p.random != null)
					line.get(p.label).random = line.get(p.random.label);
				p = p.next;
			}

			return ret.next;
		}

	}

	// why not
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null)
			return head;
		else if (random.containsKey(head.label)) {
			line.put(head.label, random.get(head.label));
			line.get(head.label).next = copyRandomList(head.next);
			random.remove(head.label);
			return line.get(head.label);
		} else {
			RandomListNode ret = new RandomListNode(head.label);
			line.put(ret.label, ret);
			if (head.random != null) {
				if (line.containsKey(head.random.label))
					ret.random = line.get(head.random.label);
				else if (random.containsKey(head.random.label))
					ret.random = random.get(head.random.label);
				else {
					random.put(head.random.label, new RandomListNode(head.random.label));
				}
			}

			ret.next = copyRandomList(head.next);

			return ret;
		}
	}

}
