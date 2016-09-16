package hou.forwz.LeetcodeAgain.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author houweitao
 * @date 2016年9月16日下午2:26:24
 */

public class RemoveInvalidParentheses {
	public static void main(String[] args) {
		RemoveInvalidParentheses rp = new RemoveInvalidParentheses();
		String s = "((n)()";
		System.out.println(rp.removeInvalidParentheses(s));
	}

	public List<String> removeInvalidParentheses(String s) {
		List<String> ret = new ArrayList<>();
		Queue<String> queue = new LinkedList<>();
		Set<String> visited = new HashSet<>();

		queue.offer(s);

		int len = -1;
		while (!queue.isEmpty()) {
			String cur = queue.poll();
			if (nice(cur)) {
				ret.add(cur);
				len = cur.length();
			}

			for (int i = 0; i < cur.length(); i++) {
				char c = cur.charAt(i);
				if (c != '(' && c != ')')
					continue;
				
				String maybe = cur.substring(0, i) + cur.substring(i + 1);

				if (!visited.contains(maybe) && cur.length() >= len) {
					visited.add(maybe);
					queue.offer(maybe);
				}
			}

		}
		return ret;
	}

	boolean nice(String s) {
		int count = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == '(')
				count++;
			else if (c == ')') {
				count--;
				if (count < 0)
					return false;
			}
		}

		return count == 0;
	}

}
