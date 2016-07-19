package hou.forwz.Leetcode.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/**
 * @author houweitao
 * @date 2016年7月19日下午10:29:27
 */

public class TopKFrequentElements {


	public List<Integer> topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> countMap = new HashMap<>();
		List<Integer> ret = new ArrayList<>();
		for (int n : nums) {
			if (countMap.containsKey(n)) {
				countMap.put(n, countMap.get(n) + 1);
			} else {
				countMap.put(n, 1);
			}
		}
		PriorityQueue<Help> queue = new PriorityQueue<>(countMap.size(), new HelpComp());
		for (Entry<Integer, Integer> entry : countMap.entrySet()) {
			queue.offer(new Help(entry.getKey(), entry.getValue()));
		}

		for (int i = 0; i < k; i++) {
			ret.add(queue.poll().cal);
		}
		return ret;
	}

	class HelpComp implements Comparator<Help> {

		@Override
		public int compare(Help o1, Help o2) {
			int comp = o1.freq - o2.freq;
			if (comp > 0)
				return 1;
			else if (comp < 0)
				return -1;
			else
				return 0;
		}

	}

	class Help {
		int cal;
		int freq;

		Help(int a, int b) {
			cal = a;
			freq = b;
		}

	}

}
