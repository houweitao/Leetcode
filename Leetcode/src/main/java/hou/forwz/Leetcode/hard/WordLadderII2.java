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
 * @date 2016年8月14日上午3:37:23
 */

public class WordLadderII2 {

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
		List<List<String>> ret = new ArrayList<>();
		Set<String> endSet = new HashSet<>();

		Map<String, Node> nodeMap = new HashMap<>();
		for (String str : wordList)
			nodeMap.put(str, new Node(str));

		wordList.remove(endWord);
		// wordList.remove(beginWord);

		char[] ch = endWord.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			char bak = ch[i];
			for (char c = 'a'; c <= 'z'; c++) {
				if (c == bak)
					continue;
				ch[i] = c;

				String next = new String(ch);

				if (next.equals(beginWord)) {
					List<String> tmp = new ArrayList<>();
					tmp.add(beginWord);
					tmp.add(endWord);
					ret.add(tmp);
					return ret;
				}
				if (wordList.contains(next)) {
					endSet.add(next);
				}
			}
			ch[i] = bak;
		}

		// System.out.println(wordList);
		// System.out.println(endSet);

		Queue<String> queue = new LinkedList<>();
		queue.add(beginWord);
		nodeMap.get(beginWord).dep = 0;
		boolean notEnd = true;
		Set<Node> niceNode = new HashSet<>();
		while (!queue.isEmpty() && notEnd) {
			// System.out.println(queue);

			Queue<String> tmp = new LinkedList<>();
			while (!queue.isEmpty()) {
				String cur = queue.poll();
				Node curNode = nodeMap.get(cur);

				if (endSet.contains(cur)) {
					notEnd = false;
					// List<String> tmpList = new LinkedList<String>();
					// tmpList.add(cur);
					// tmpList.add(endWord);
					niceNode.add(curNode);
					// generate(tmpList, curNode, ret);
				}

				ch = cur.toCharArray();
				for (int i = 0; i < cur.length(); i++) {
					char bak = ch[i];
					for (char c = 'a'; c < 'z'; c++) {
						ch[i] = c;
						String next = new String(ch);
						// if (wordList.remove(next)) {
						if (wordList.contains(next)) {
							Node nextNode = nodeMap.get(next);
							if (nextNode.dep > curNode.dep) {
								nextNode.pre.add(curNode);
								nextNode.dep = curNode.dep + 1;
								tmp.add(next);
							}
						}

					}
					ch[i] = bak;
				}
			}

			queue = tmp;
		}

		for (Node node : niceNode) {
			List<String> list = new LinkedList<String>();
			list.add(node.val);
			list.add(endWord);
			generate(list, node, ret);
		}

		// for (Map.Entry<String, Node> entry : nodeMap.entrySet()) {
		// System.out.println(entry.getValue());
		// }
		return ret;
	}

	private void generate(List<String> list, Node node, List<List<String>> ret) {
		if (node.pre.size() > 0) {
			for (Node n : node.pre) {
				list.add(0, n.val);
				generate(list, n, ret);
				list.remove(0);
			}
		} else {
			// System.out.println("add");
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
