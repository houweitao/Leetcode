package hou.forwz.Leetcode.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * @author houweitao
 * @date 2016年8月9日下午11:01:21
 */

public class ReconstructItinerary {
	public static void main(String[] args) {
		ReconstructItinerary ri = new ReconstructItinerary();
		// String[][] tickets =
		// { { "JFK", "SFO" }, { "JFK", "ATL" }, { "SFO", "ATL" }, { "ATL",
		// "JFK" },
		// { "ATL", "SFO" } };
		String[][] tickets = { { "JFK", "KUL" }, { "JFK", "NRT" }, { "NRT", "JFK" } };
		System.out.println(ri.findItinerary(tickets));

		ri.init();

	}

	private void init() {
		City city = new City("JFK");
		City to1 = new City("KUL");
		City to2 = new City("NRT");
		city.add(to1);
		city.add(to2);
		System.out.println(city.queue);

	}

//	public List<String> findItinerary2(String[][] tickets) {
//		Map<String, City> map = new HashMap<>();
//		List<String> ret = new ArrayList<>();
//		for (int i = 0; i < tickets.length; i++) {
//			String from = tickets[i][0];
//			String to = tickets[i][1];
//
//			if (!map.containsKey(from)) {
//				map.put(from, new City(from));
//			}
//			if (!map.containsKey(to)) {
//				map.put(to, new City(to));
//			}
//
//			map.get(from).add(map.get(to));
//		}
//
//		// System.out.println(map.size());
//
//		City city = map.get("JFK");
//		ret.add("JFK");
//		dfs(city,ret,tickets.length+1);
//		
//
//
//		return ret;
//	}

//	private void dfs(City city, List<String> ret,int need) {
//		Queue<City> queue=city.queue;
//		if(queue.size()==0&&ret.size()==(need-1)){
//			ret.add(city.name);
//			return;
//		}
//		if(queue.size()>0){
//			List<City> list=new LinkedList<>(queue);
//			for(int i=list.size()-1;i>=0;i--){
//				City cur=list.get(i);
//				ret.add(city.name);
//				
//				dfs(cur,ret,need);
//				if(ret.size()==need)
//					return;
//				else
//					ret.remove(ret.size()-1);
//			}
//		}
//	}

	public List<String> findItinerary(String[][] tickets) {
		Map<String, City> map = new HashMap<>();
		List<String> ret = new ArrayList<>();
		for (int i = 0; i < tickets.length; i++) {
			String from = tickets[i][0];
			String to = tickets[i][1];

			if (!map.containsKey(from)) {
				map.put(from, new City(from));
			}
			if (!map.containsKey(to)) {
				map.put(to, new City(to));
			}

			map.get(from).add(map.get(to));
		}

		// System.out.println(map.size());

		City city = map.get("JFK");
		Stack<City> stack = new Stack<>();
		stack.push(city);
		ret.add(stack.peek().name);

		while (!stack.isEmpty()) {
			City cur = stack.peek();
			// ret.add(cur.name);
			Queue<City> queue = cur.queue;
			if (queue.size() > 0) {
				stack.push(queue.poll());
				ret.add(stack.peek().name);
			} else
				stack.pop();
		}

		return ret;
	}

	class City {
		String name;
		PriorityQueue<City> queue;

		City(String name) {
			this.name = name;
			queue = new PriorityQueue<>(10, new Comparator<City>() {

				@Override
				public int compare(City o11, City o22) {
					String o1 = o11.name;
					String o2 = o22.name;
					for (int i = 0; i < 3; i++) {
						char l = o1.charAt(i), r = o2.charAt(i);
						if (l - r > 0)
							return 1;
						else if (l - r < 0)
							return -1;
					}
					return 0;
				}
			});
		}

		public void add(City to) {
			queue.offer(to);
		}

		@Override
		public String toString() {
			return name;
		}
	}
}
