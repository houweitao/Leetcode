package hou.forwz.Leetcode.medium;

import java.util.*;

/**
 * @author houweitao
 * @date 2016年8月9日下午11:49:06
 * @nice https://discuss.leetcode.com/topic/36370/short-ruby-python-java-c
 */

public class ReconstructItinerary2 {
	Map<String, PriorityQueue<String>> flights;
	LinkedList<String> path;

	public static void main(String[] args) {
		ReconstructItinerary2 ri = new ReconstructItinerary2();
		// String[][] tickets =
		// { { "JFK", "SFO" }, { "JFK", "ATL" }, { "SFO", "ATL" }, { "ATL",
		// "JFK" },
		// { "ATL", "SFO" } };
		String[][] tickets = { { "JFK", "KUL" }, { "JFK", "NRT" }, { "NRT", "JFK" } };
		System.out.println(ri.findItinerary(tickets));
	}

	public List<String> findItinerary(String[][] tickets) {
		flights = new HashMap<>();
		path = new LinkedList<>();
		for (String[] ticket : tickets) {
			if (!flights.containsKey(ticket[0]))
				flights.put(ticket[0], new PriorityQueue<String>());
			flights.get(ticket[0]).add(ticket[1]);
		}

		System.out.println(flights);
		dfs("JFK");
		return path;
	}

	public void dfs(String departure) {
		System.out.println(departure);
		PriorityQueue<String> arrivals = flights.get(departure);
		while (arrivals != null && !arrivals.isEmpty())
			dfs(arrivals.poll());
		System.out.println("add " + departure);
		path.addFirst(departure);
	}
}
