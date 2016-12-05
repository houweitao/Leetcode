package hou.forme.GooglePrepare.GooglePrepare.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @author houweitao
 * @date 2016年12月5日下午8:44:59
 * @end 2016年12月05日21:04:27
 * @ps 太不细心了..
 */

public class LRUCache {
	Node head;
	Node tail;
	int max;
	Map<Integer, Node> map;

	public LRUCache(int capacity) {
		head = new Node(-1, -1);
		tail = new Node(-1, -1);

		head.next = tail;
		tail.pre = head;

		max = capacity;
		map = new HashMap<>();
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			Node node = map.get(key);
			moveFirst(node);

			return map.get(key).value;
		} else
			return -1;
	}

	private void moveFirst(Node node) {
		if (node.pre == head)
			return;
		node.pre.next = node.next;
		node.next.pre = node.pre;

		node.pre = head;
		node.next = head.next;
		node.next.pre = node;
		head.next = node;
	}

	public void set(int key, int value) {
		if (map.containsKey(key)) {
			Node node = map.get(key);
			node.value = value;
			moveFirst(node);// TODO
		} else {
			Node node = new Node(key, value);
			node.next = head.next;
			node.next.pre = node;
			node.pre = head;
			head.next = node;
			map.put(key, node);// TODO
			checkNum();
		}

	}

	private void checkNum() {
		if (map.size() > max) {
			Node rm = tail.pre;
			tail.pre = rm.pre;
			rm.pre.next = tail;
			map.remove(rm.key);
		}
	}

	class Node {
		Node pre;
		Node next;
		int key;
		int value;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public int hashCode() {
			return key;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Node) {
				Node o = (Node) obj;
				return o.key == key;
			}
			return false;
		}
	}
}
