package hou.forwz.Leetcode.medium;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年8月4日下午11:41:55
 */

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
public class PeekingIterator implements Iterator<Integer> {

	List<Integer> list;

	public PeekingIterator(Iterator<Integer> iterator) {
		// initialize any member here.
		list = new LinkedList<>();
		while (iterator.hasNext()) {
			list.add(iterator.next());
		}

	}

	// Returns the next element in the iteration without advancing the iterator.
	// @Override
	public Integer peek() {
		if (list.size() > 0)
			return list.get(0);
		else
			return null;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		if (hasNext()) {
			return list.remove(0);
		} else
			return -1;
	}

	@Override
	public boolean hasNext() {
		if(list.size()>0)
			return true;
		else
			return false;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub

	}
}
