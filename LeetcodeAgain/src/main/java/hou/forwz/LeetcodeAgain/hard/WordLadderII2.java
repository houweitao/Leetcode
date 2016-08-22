package hou.forwz.LeetcodeAgain.hard;

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
 * @date 2016年8月22日下午10:42:17
 * @made 2016年08月22日23:39:03
 */

public class WordLadderII2 {

	public static void main(String[] args) {

		WordLadderII2 wl = new WordLadderII2();
		Set<String> wordList = new HashSet<>();

		String[] strs = { "hot", "cog", "dog", "tot", "hog", "hop", "pot", "dot" };

		for (String str : strs) {
			wordList.add(str);
		}

		String beginWord = "hot", endWord = "dog";

		System.out.println(wl.findLadders(beginWord, endWord, wordList));
	}

	public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
		List<List<String>> ret = new ArrayList<>();
		Map<String, Node> map = new HashMap<>();
		Set<String> endSet = new HashSet<>();

		wordList.add(beginWord);
		wordList.add(endWord);

		for (String str : wordList) {
			map.put(str, new Node(str));
		}

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
				// System.out.println(next);
				if (next.equals(beginWord)) {
					System.out.println(next + "," + beginWord);
					List<String> tmp = new ArrayList<>();
					tmp.add(beginWord);
					tmp.add(endWord);
					ret.add(tmp);
					// return ret;
				}
				if (wordList.contains(next)) {
					endSet.add(next);
				}
			}
			ch[i] = bak;
		}

		if (ret.size() != 0)
			return ret;

		// System.out.println(endSet);

		Queue<Node> queue = new LinkedList<>();
		queue.offer(map.get(beginWord));
		map.get(beginWord).dep = 0;

		boolean end = false;
		Set<Node> niceNode = new HashSet<>();

		while (!queue.isEmpty() && !end) {
			Queue<Node> tmp = new LinkedList<>();

			while (!queue.isEmpty()) {
				Node node = queue.poll();
				ch = node.val.toCharArray();

				if (endSet.contains(node.val)) {
					end = true;
					niceNode.add(node);
				}

				// if (!end)
				for (int i = 0; i < ch.length; i++) {
					char cur = ch[i];
					for (char c = 'a'; c < 'z'; c++) {
						ch[i] = c;
						String str = new String(ch);
						// if (endSet.contains(str)) {
						// end = true;
						// niceNode.add(map.get(str));
						// }
						if (wordList.contains(str) && map.get(str).dep > node.dep) {
							Node curNode = map.get(str);
							curNode.dep = node.dep + 1;
							curNode.pre.add(node);
							tmp.offer(curNode);
						}
					}
					ch[i] = cur;
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
					", pre=" + pre.size() + ", dep=" + dep + "]";
		}

	}

}
