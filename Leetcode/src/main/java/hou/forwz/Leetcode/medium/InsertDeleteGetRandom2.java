package hou.forwz.Leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @author houweitao
 * @date 2016年8月9日下午8:41:24
 */

public class InsertDeleteGetRandom2 {
	public static void main(String[] args) {
		InsertDeleteGetRandom2 id = new InsertDeleteGetRandom2();
		id.init();
	}

	private void init() {
		RandomizedCollection rc = new RandomizedCollection();
		System.out.println(rc.insert(5));
		System.out.println(rc.remove(5));
		System.out.println(rc.remove(5));
	}

	public class RandomizedCollection {
		Map<Integer, Stack<Integer>> map;
		List<Integer> list;

		/** Initialize your data structure here. */
		public RandomizedCollection() {
			map = new HashMap<>();
			list = new ArrayList<>();
		}

		/**
		 * Inserts a value to the collection. Returns true if the collection did
		 * not already contain the specified element.
		 */
		public boolean insert(int val) {
			boolean contain = false;
			if (!map.containsKey(val)) {
				map.put(val, new Stack<Integer>());
				contain = true;
			}
			list.add(val);
			map.get(val).push(list.size() - 1);// 储存位置
			return contain;
		}

		/**
		 * Removes a value from the collection. Returns true if the collection
		 * contained the specified element.
		 */
		public boolean remove(int val) {
			if (!map.containsKey(val)) {
				return false;
			} else {
				Stack<Integer> tmp = map.get(val);

				int index = tmp.pop();// 要移除的位置
				if (tmp.size() == 0)
					map.remove(val);

				int last = list.get(list.size() - 1);// 最后一个数是什么
				if (last == val) {
					list.remove(list.size() - 1);
				} else {
					Stack<Integer> lastQ = map.get(last);
					lastQ.pop();// 弹出的一定是size

					list.set(index, last);
					list.remove(list.size() - 1);

					lastQ.push(index);
				}
				return true;
			}
		}

		/** Get a random element from the collection. */
		public int getRandom() {
			if (list.size() == 0)
				return -1;
			int pos = (int) (Math.random() * list.size());
			return list.get(pos);
		}
	}

	/**
	 * Your RandomizedCollection object will be instantiated and called as such:
	 * RandomizedCollection obj = new RandomizedCollection(); boolean param_1 =
	 * obj.insert(val); boolean param_2 = obj.remove(val); int param_3 =
	 * obj.getRandom();
	 */
}
