package hou.forwz.Leetcode.medium;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年7月27日下午10:11:02
 */

public class FlattenNestedListIterator {
	/**
	 * // This is the interface that allows for creating nested lists. // You
	 * should not implement it, or speculate about its implementation public
	 * interface NestedInteger {
	 *
	 * // @return true if this NestedInteger holds a single integer, rather than
	 * a nested list. public boolean isInteger();
	 *
	 * // @return the single integer that this NestedInteger holds, if it holds
	 * a single integer // Return null if this NestedInteger holds a nested list
	 * public Integer getInteger();
	 *
	 * // @return the nested list that this NestedInteger holds, if it holds a
	 * nested list // Return null if this NestedInteger holds a single integer
	 * public List<NestedInteger> getList(); }
	 */

	interface NestedInteger {

		// @return true if this NestedInteger holds a single integer, rather
		// than
		// a nested list.

		public boolean isInteger();

		// @return the single integer that this NestedInteger holds, if it holds
		// a single integer // Return null if this NestedInteger holds a nested
		// list

		public Integer getInteger();

		// @return the nested list that this NestedInteger holds, if it holds a
		// nested list // Return null if this NestedInteger holds a single
		// integer

		public List<NestedInteger> getList();
	}

	public class NestedIterator implements Iterator<Integer> {
		List<NestedInteger> queue;
		NestedIterator head;

		public NestedIterator(List<NestedInteger> nestedList) {
			queue = new LinkedList<>(nestedList);
			head = null;
		}

		@Override
		public Integer next() {
			if (head != null && head.hasNext())
				return head.next();
			else if (queue.size() == 0)
				return null;

			NestedInteger cur = queue.remove(0);
			if (cur.isInteger())
				return cur.getInteger();
			else {
				head = new NestedIterator(cur.getList());
				if (head.hasNext())
					return head.next();
				else {
					head = null;
					return next();
				}
				// Integer in = head.next();
				// if (in == null) {
				// head = null;
				// return next();
				// } else
				// return in;
			}
		}

		@Override
		public boolean hasNext() {

			if (head != null) {
				if (head.hasNext())
					return true;
			}

			if (queue.size() > 0)
				if (queue.get(0).isInteger())
					return true;
				else {
					boolean yes = new NestedIterator(queue.get(0).getList()).hasNext();
					if (yes)
						return yes;
					NestedInteger tmp = queue.remove(0);
					List<NestedInteger> remain = new LinkedList<>(queue);
					yes = new NestedIterator(remain).hasNext();
					queue.add(0, tmp);

					return yes;
				}
			else
				return false;
			// return head != null && head.hasNext() || queue.size() > 0;
		}

		@Override
		public void remove() {

		}
	}

	/**
	 * Your NestedIterator object will be instantiated and called as such:
	 * NestedIterator i = new NestedIterator(nestedList); while (i.hasNext())
	 * v[f()] = i.next();
	 */
}
