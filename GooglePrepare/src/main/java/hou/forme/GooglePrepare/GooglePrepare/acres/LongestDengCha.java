package hou.forme.GooglePrepare.GooglePrepare.acres;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author houweitao
 * @date 2016年12月6日下午6:10:02
 * @end 2016年12月06日18:24:50
 * @url http://www.1point3acres.com/bbs/thread-214818-1-1.html
 */

public class LongestDengCha {
	public static void main(String[] args) {
		LongestDengCha dc = new LongestDengCha();
		int[] nums = { 3, 2, 6, 45, 4, 9, 2, 12 };
		List<List<Integer>> ret = dc.getDengCha(nums);
		for (List<Integer> list : ret) {
			System.out.println(list);
		}
	}

	List<List<Integer>> getDengCha(int[] nums) {
		List<List<Integer>> ret = new ArrayList<>();
		int max = 0;
		Node[] dp = new Node[nums.length];

		for (int i = 0; i < nums.length; i++) {
			dp[i] = new Node(nums[i]);
			for (int j = 0; j < i; j++) {
				Node jj = dp[j];
				int cha = nums[i] - jj.val;
				if (jj.map.containsKey(cha)) {
					List<Integer> tmp = new ArrayList<>();
					tmp.addAll(jj.map.get(cha));
					tmp.add(nums[i]);
					dp[i].map.put(cha, tmp);
				} else {
					List<Integer> tmp = new ArrayList<>();
					tmp.add(jj.val);
					tmp.add(nums[i]);
					dp[i].map.put(cha, tmp);
				}
			}

			for (Map.Entry<Integer, List<Integer>> entry : dp[i].map.entrySet()) {
				if (entry.getValue().size() > max) {
					max = entry.getValue().size();
					ret.clear();
					ret.add(entry.getValue());
				} else if (entry.getValue().size() == max) {
					ret.add(entry.getValue());
				}
			}

			System.out.println(i + ": " + dp[i]);
		}

		return ret;
	}

	class Node {
		int val;
		Map<Integer, List<Integer>> map;

		public Node(int val) {
			this.val = val;
			map = new HashMap<>();
		}

		@Override
		public String toString() {
			return "Node [val=" + val + ", map=" + map + "]";
		}

	}
}
