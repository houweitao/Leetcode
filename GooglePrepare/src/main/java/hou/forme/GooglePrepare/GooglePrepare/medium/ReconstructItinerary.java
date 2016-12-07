package hou.forme.GooglePrepare.GooglePrepare.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author houweitao
 * @date 2016年12月7日下午2:25:02
 */

public class ReconstructItinerary {
	Map<String, PriorityQueue<String>> flights;
	LinkedList<String> path;

	public static void main(String[] args) {
		ReconstructItinerary ri = new ReconstructItinerary();
		 String[][] tickets =
		 { { "JFK", "SFO" }, { "JFK", "ATL" }, { "SFO", "ATL" }, { "ATL",
		 "JFK" },
		 { "ATL", "SFO" } };
//		String[][] tickets = { { "JFK", "KUL" }, { "JFK", "NRT" }, { "NRT", "JFK" } };
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
		System.out.println("出发： "+departure);
		PriorityQueue<String> arrivals = flights.get(departure);
		while (arrivals != null && !arrivals.isEmpty())
			dfs(arrivals.poll());
		System.out.println("add " + departure);
		path.addFirst(departure);
		
		System.out.println("path: "+path);
		System.out.println("---");
	}
}

