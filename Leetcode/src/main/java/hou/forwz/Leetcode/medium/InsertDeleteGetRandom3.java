package hou.forwz.Leetcode.medium;

import java.util.*;

/**
 * @author houweitao
 * @date 2016年8月9日下午9:18:15
 */

public class InsertDeleteGetRandom3 {
	public class RandomizedCollection {
		private final Random rand;
		private final Map<Integer, Queue<Integer>> map;
		private final List<Integer> list;

		/** Initialize your data structure here. */
		public RandomizedCollection() {
			rand = new Random();
			map = new HashMap<>();
			list = new ArrayList<>();
		}

		/**
		 * Inserts a value to the collection. Returns true if the collection did
		 * not already contain the specified element.
		 */
		public boolean insert(int val) {
			list.add(val);
			boolean contains = false;
			if (!map.containsKey(val)) {
				map.put(val, new LinkedList<Integer>());
				contains = true;
			}
			map.get(val).offer(list.size() - 1); // this new element maps to
													// this index
			return contains;
		}

		/**
		 * Removes a value from the collection. Returns true if the collection
		 * contained the specified element.
		 */
		public boolean remove(int val) {
			if (!map.containsKey(val))
				return false; // this element does not exist
			Queue<Integer> q = map.get(val);
			int index = q.poll();
			if (q.isEmpty())
				map.remove(val); // we're removing the only element

			if (index != list.size() - 1) { // we're removing an element that is
											// not last
				int lastElement = list.get(list.size() - 1);
				Queue<Integer> lastQueue = map.get(lastElement); // get's the
																	// last
																	// queue
				lastQueue.poll();

				lastQueue.offer(index); // that element now maps to our current
										// element's location
				list.set(index, lastElement); // set that element in our current
												// position
			}
			list.remove(list.size() - 1);
			return true;
		}

		/** Get a random element from the collection. */
		public int getRandom() {
			return list.get(rand.nextInt(list.size()));
		}
	}
}
