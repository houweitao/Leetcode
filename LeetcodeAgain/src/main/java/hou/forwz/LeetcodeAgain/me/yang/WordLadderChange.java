package hou.forwz.LeetcodeAgain.me.yang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author houweitao
 * @date 2016年11月28日下午12:25:47
 * @end 2016年11月28日12:55:48
 * @写了一半 体会体会吧就。阉割版的全部最长
 */

public class WordLadderChange {
	public List<String> findLadders(Set<String> wordList) {
		Map<String, Node> nodeMap = new HashMap<>();
		for (String str : wordList) {
			nodeMap.put(str, new Node(str));
		}

		for (String str : wordList) {
			StringBuilder sb = new StringBuilder(str);
			Node cur = nodeMap.get(str);
			for (int i = 0; i <= str.length(); i++) {
				for (char insert = 'a'; insert < 'z'; insert++) {
					sb.insert(i, insert);
					if (wordList.contains(sb.toString())) {
						Node next = nodeMap.get(sb.toString());
						next.pre.add(cur);
						cur.next.add(next);
					}
					sb = new StringBuilder(str);
				}
			}
		}

		List<Node> ret = findLongest(wordList, nodeMap).get(0);

		return null;
	}

	private List<List<Node>> findLongest(Set<String> wordList, Map<String, Node> nodeMap) {
		List<List<Node>> ret = new ArrayList<>();
		int size = 1;

		Map<String, List<Node>> curLongestNext = new HashMap<>();
		Map<String, List<Node>> curLongestPre = new HashMap<>();
		for (String str : wordList) {
			Node node = nodeMap.get(str);

			List<Node> next = getNext(wordList, node, nodeMap, curLongestNext);
			List<Node> pre = getPre(wordList, node, nodeMap, curLongestPre);

			List<Node> maybe = new ArrayList<>(pre);
			maybe.add(node);
			maybe.addAll(next);

			if (maybe.size() > size) {
				size = maybe.size();
				ret.clear();
				ret.add(maybe);
			} else if (maybe.size() == size) {
				ret.add(maybe);
			}
		}
		return ret;
	}

	private List<Node> getPre(Set<String> wordList, Node node, Map<String, Node> nodeMap,
			Map<String, List<Node>> curLongestPre) {

		if (curLongestPre.containsKey(node.val)) {
			return curLongestPre.get(node.val);
		}

		List<Node> ret = new ArrayList<>();
		Set<Node> nexts = node.next;

		for (Node next : nexts) {
			List<Node> may = getPre(wordList, next, nodeMap, curLongestPre);
			may.add(next);
			if (may.size() > ret.size()) {
				ret = may;
			}
		}
		curLongestPre.put(node.val, ret);
		return ret;
	}

	private List<Node> getNext(Set<String> wordList, Node node, Map<String, Node> nodeMap,
			Map<String, List<Node>> curLongestNext) {

		if (curLongestNext.containsKey(node.val)) {
			return curLongestNext.get(node.val);
		}

		List<Node> ret = new ArrayList<>();
		Set<Node> nexts = node.next;

		for (Node next : nexts) {
			List<Node> may = getNext(wordList, next, nodeMap, curLongestNext);
			may.add(next);
			if (may.size() > ret.size()) {
				ret = may;
			}
		}
		curLongestNext.put(node.val, ret);
		return ret;
	}

	class Node {
		Set<Node> next;
		Set<Node> pre;
		String val;

		public Node(String val) {
			this.val = val;
			next = new HashSet<>();
			pre = new HashSet<>();
		}
	}
}
