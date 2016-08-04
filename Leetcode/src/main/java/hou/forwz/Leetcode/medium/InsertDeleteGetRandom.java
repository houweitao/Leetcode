package hou.forwz.Leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @author houweitao
 * @date 2016年8月4日下午10:52:54
 */

public class InsertDeleteGetRandom {
	public class RandomizedSet {
		Set<Integer> set;

		/** Initialize your data structure here. */
		public RandomizedSet() {
			set = new HashSet<>();
		}

		/**
		 * Inserts a value to the set. Returns true if the set did not already
		 * contain the specified element.
		 */
		public boolean insert(int val) {
			return set.add(val);
		}

		/**
		 * Removes a value from the set. Returns true if the set contained the
		 * specified element.
		 */
		public boolean remove(int val) {
			if (set.add(val)) {
				set.remove(val);
				return false;
			} else {
				set.remove(val);
				return true;
			}
		}

		/** Get a random element from the set. */
		public int getRandom() {
			if(set.size()==0)
				return -1;
			Integer[] nums = set.toArray(new Integer[] {});
			int pos = (int) (Math.random() * nums.length);
			return nums[pos];
		}
	}

	/**
	 * Your RandomizedSet object will be instantiated and called as such:
	 * RandomizedSet obj = new RandomizedSet(); boolean param_1 =
	 * obj.insert(val); boolean param_2 = obj.remove(val); int param_3 =
	 * obj.getRandom();
	 */
}
