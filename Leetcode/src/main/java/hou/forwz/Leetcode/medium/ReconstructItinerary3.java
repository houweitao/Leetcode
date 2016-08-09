package hou.forwz.Leetcode.medium;

import java.util.*;

/**
 * @author houweitao
 * @date 2016年8月10日上午12:15:17
 */

public class ReconstructItinerary3 {
	Map<String, PriorityQueue<String>> map = new HashMap<>();
	List<String> ret = new LinkedList<>();

	public List<String> findItineraryRec(String[][] tickets) {
		Map<String, PriorityQueue<String>> map = new HashMap<>();
		List<String> ret = new LinkedList<>();
		for (int i = 0; i < tickets.length; i++) {
			String from = tickets[i][0];
			String to = tickets[i][1];
			if (!map.containsKey(from))
				map.put(from, new PriorityQueue<String>());

			map.get(from).add(to);
		}

		Stack<String> stack = new Stack<>();
		stack.push("JFK");
		while (!stack.isEmpty()) {
			while (map.containsKey(stack.peek()) && map.get(stack.peek()).size() > 0)
				stack.push(stack.pop());
			ret.add(0, stack.pop());

		}

		return ret;
	}

	public List<String> findItinerary(String[][] tickets) {

		for (int i = 0; i < tickets.length; i++) {
			String from = tickets[i][0];
			String to = tickets[i][1];
			if (!map.containsKey(from))
				map.put(from, new PriorityQueue<String>());

			map.get(from).add(to);
		}

		dfs("JFK");
		return ret;
	}

	private void dfs(String str) {
		Queue<String> queue = map.get(str);
		while (!queue.isEmpty()) {
			dfs(queue.poll());
		}
		ret.add(0, str);
	}

}
