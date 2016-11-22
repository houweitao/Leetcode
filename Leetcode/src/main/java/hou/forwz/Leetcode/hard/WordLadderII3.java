package hou.forwz.Leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author houweitao
 * @date 2016年11月21日下午10:03:03
 */

public class WordLadderII3 {

	public static void main(String[] args) {

		WordLadderII2 wl = new WordLadderII2();
		Set<String> wordList = new HashSet<>();
		String[] strs = { "ted", "tex", "red", "tax", "tad", "den", "rex", "pee" };

		for (String str : strs) {
			wordList.add(str);
		}

		String beginWord = "red", endWord = "tax";

		System.out.println(wl.findLadders(beginWord, endWord, wordList));
	}

	public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
		Map<String, Node> map = new HashMap<>();
		for (String str : wordList) {
			map.put(str, new Node(str));
		}

		Queue<Node> queue = new LinkedList<>();
		queue.offer(map.get(beginWord));
		boolean notEnd = true;
		Set<Node> nice = new HashSet<>();

		while (queue.size() > 0 && notEnd) {

			Queue<Node> tmp = new LinkedList<>();

			Node curNode = queue.poll();
			String curStr = curNode.val;

			char[] chs = curStr.toCharArray();

			for (int i = 0; i < chs.length; i++) {
				char curChar = chs[i];
				for (char c = 'a'; c < 'z'; c++) {
					if (c == curChar)
						continue;
					chs[i] = c;
					String s = new String(chs);

					if (s.equals(endWord)) {
						notEnd = false;
						nice.add(curNode);
					} else if (wordList.contains(s)) {
						Node next = map.get(s);
						if (next.dep > curNode.dep) {
							next.dep = curNode.dep + 1;
							next.pre.add(curNode);
							tmp.offer(next);
						}
					}

				}
				chs[i] = curChar;
			}

			queue = tmp;
		}

		List<List<String>> ret = new ArrayList<>();
		for (Node node : nice) {
			List<String> list = new LinkedList<String>();
			list.add(node.val);
			list.add(endWord);
			generate(list, node, ret);
		}

		return ret;
	}

	private void generate(List<String> list, Node node, List<List<String>> ret) {
		if (node.dep > 0) {
			for (Node n : node.pre) {
				list.add(0, n.val);
				generate(list, n, ret);
				list.remove(0);
			}
		} else {
			ret.add(new ArrayList<>(list));
		}
	}

	class Node {
		String val;
		Set<Node> pre;
		int dep;

		Node(String val) {
			this.val = val;
			pre = new HashSet<>();
			dep = Integer.MAX_VALUE;
		}

		@Override
		public int hashCode() {
			return val.hashCode();
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Node) {
				return ((Node) obj).val.equals(val);
			} else
				return false;
		}

		@Override
		public String toString() {
			return "Node [val=" + val +
					// ", pre=" + pre +
					", dep=" + dep + "]";
		}

	}
}
