package hou.forme.GooglePrepare.GooglePrepare.medium;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年12月6日下午3:25:23
 */

public class PeekingIterator {

	List<Integer> list;

	public PeekingIterator(Iterator<Integer> iterator) {
		// initialize any member here.
		list = new LinkedList<>();
		while (iterator.hasNext()) {
			list.add(iterator.next());
		}
	}

	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		if (hasNext())
			return list.get(0);
		else
			return -1;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	public Integer next() {
		if (hasNext()) {
			return list.remove(0);
		} else
			return -1;
	}

	public boolean hasNext() {
		if (list.size() > 0)
			return true;
		else
			return false;
	}
}
