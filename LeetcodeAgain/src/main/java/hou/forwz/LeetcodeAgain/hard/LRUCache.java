package hou.forwz.LeetcodeAgain.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @author houweitao
 * @date 2016年8月23日上午12:13:56
 */

public class LRUCache {
	Node head;
	Node tail;
	int count;
	Map<Integer, Node> map;

	public static void main(String[] args) {
		LRUCache cl = new LRUCache(2);
		cl.set(2, 1);
		cl.set(1, 1);
		cl.set(2, 3);
		cl.set(4, 1);
		System.out.println(cl.get(1));
		System.out.println(cl.get(2));
		// cl.set(1, 1);
		// System.out.println(cl.get(2));
	}

	public LRUCache(int capacity) {
		head = new Node();
		tail = new Node();
		head.next = tail;
		tail.before = head;
		count = capacity;
		map = new HashMap<>(capacity);
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			move2Head(map.get(key));
			return map.get(key).value;
		} else
			return -1;
	}

	private void move2Head(Node node) {
		if (node.before == head)
			return;
		else {
			node.before.next = node.next;
			node.next.before = node.before;

			node.next = head.next;
			node.next.before = node;
			head.next = node;
			node.before = head;
		}
	}

	public void set(int key, int value) {
		if (map.containsKey(key)) {
			Node node = map.get(key);
			node.value = value;
			move2Head(node);
		} else {
			count--;
			Node node = new Node(key, value);
			map.put(key, node);

			node.next = head.next;
			node.before = head;

			head.next.before = node;
			head.next = node;

			if (count == -1)
				delLast();
		}
	}

	private void delLast() {
		Node del = tail.before;

		del.before.next = tail;
		tail.before = del.before;
		map.remove(del.key);
		del = null;
		count++;
	}

	class Node {
		int key;
		int value;
		Node before;
		Node next;

		Node(int key, int value) {
			this.key = key;
			this.value = value;
		}

		Node() {

		}
	}
}
