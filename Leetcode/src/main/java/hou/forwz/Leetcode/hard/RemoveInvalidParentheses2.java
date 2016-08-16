package hou.forwz.Leetcode.hard;

import java.util.*;

/**
 * @author houweitao
 * @date 2016年8月16日下午10:44:01
 */

public class RemoveInvalidParentheses2 {

	public List<String> removeInvalidParentheses(String s) {
		List<String> ret = new ArrayList<>();

		if (s.length() == 0)
			return ret;

		Queue<String> queue = new LinkedList<>();
		Set<String> visited = new HashSet<>();

		queue.offer(s);
		visited.add(s);

		boolean doNotAdd = false;
		int len = -1;
		while (!queue.isEmpty()) {
			String str = queue.poll();

			if (str.length() < len)
				break;

			if (nice(str)) {
				ret.add(str);
				doNotAdd = true;
				len = str.length();
			}

			if (doNotAdd)
				continue;

			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (c != '(' && c != ')')
					continue;

				String maybe = str.substring(0, i) + str.substring(i + 1);
				if (!visited.contains(maybe)) {
					queue.offer(maybe);
					visited.add(maybe);
				}
			}

		}

		return ret;

	}

	private boolean nice(String str) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == '(')
				count++;
			else if (c == ')') {
				if (count == 0)
					return false;
				count--;
			}
		}

		return count == 0;

	}

}
