package hou.forwz.Leetcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @author houweitao
 * @date 2016年8月5日上午1:02:56
 */

public class LRUCache {

	int capacity;
	Node head;
	Node tail;
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
		this.capacity = capacity;
		map = new HashMap<>();
		head = new Node(-1, -1);
		tail = new Node(-1, -1);

		head.next = tail;
		tail.before = head;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			move2Head(map.get(key));
			return map.get(key).value;
		} else
			return -1;
	}

	public void set(int key, int value) {
		if (map.containsKey(key)) {
			map.get(key).value = value;
			move2Head(map.get(key));
		} else {
			if (capacity == 0) {
				Node remove = tail.before;
				tail.before = remove.before;

				map.remove(remove.key);

				// System.out.println("remove "+remove);
				// System.out.println(remove.before);
				remove.before.next = tail;
				capacity++;
			}

			map.put(key, new Node(key, value));
			addHead(map.get(key));
			capacity--;
		}

		// System.out.println("容量："+capacity);
	}

	private void move2Head(Node p) {
		p.before.next = p.next;
		p.next.before = p.before;

		p.before = head;
		p.next = head.next;
		head.next = p;
		p.next.before = p;

	}

	private void addHead(Node node) {
		node.next = head.next;
		node.before = head;
		node.before.next = node;
		node.next.before = node;
	}

	class Node {
		int key;
		int value;
		Node before;
		Node next;

		public Node(int key, int value) {
			super();
			this.key = key;
			this.value = value;
		}

		Node(int val) {
			key = val;
		}

		@Override
		public String toString() {
			return "Node [key=" + key + ", value=" + value + "]";
		}
	}
}
