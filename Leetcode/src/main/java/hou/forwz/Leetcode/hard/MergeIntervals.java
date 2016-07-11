package hou.forwz.Leetcode.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import hou.forwz.Leetcode.structure.Interval;

/**
 * @author houweitao
 * @date 2016年7月11日下午10:55:49
 */

public class MergeIntervals {

	public static void main(String[] args) {
		MergeIntervals mi = new MergeIntervals();
		mi.init();
	}

	private void init() {
		Interval a = new Interval(2, 3);
		Interval b = new Interval(2, 2);
		Interval c = new Interval(3, 3);
		Interval d = new Interval(1, 3);
		Interval e = new Interval(5, 7);
		Interval f = new Interval(2, 2);
		Interval g = new Interval(4, 6);

		List<Interval> list = new ArrayList<>();
		list.add(a);
		list.add(b);
		list.add(c);
		list.add(d);
		list.add(e);
		list.add(f);
		list.add(g);

		System.out.println(list);
		Collections.sort(list, new IntervalComparator());
		System.out.println(list);

		System.out.println(merge(list));
	}

	public List<Interval> merge(List<Interval> intervals) {
		Collections.sort(intervals, new IntervalComparator());
		int len = intervals.size();

		if (len < 2)
			return intervals;
		else
			return mergeList(intervals, 0, len - 1);

	}

	public List<Interval> merge2(List<Interval> intervals) {
		if (intervals.size() <= 1)
			return intervals;

		// Sort by ascending starting point using an anonymous Comparator
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval i1, Interval i2) {
				return Integer.compare(i1.start, i2.start);
			}
		});

		List<Interval> result = new LinkedList<Interval>();
		int start = intervals.get(0).start;
		int end = intervals.get(0).end;

		for (Interval interval : intervals) {
			if (interval.start <= end) // Overlapping intervals, move the end if
										// needed
				end = Math.max(end, interval.end);
			else { // Disjoint intervals, add the previous one and reset bounds
				result.add(new Interval(start, end));
				start = interval.start;
				end = interval.end;
			}
		}

		// Add the last interval
		result.add(new Interval(start, end));
		return result;
	}

	private List<Interval> mergeList(List<Interval> list, int begin, int end) {
		List<Interval> ret = new ArrayList<>();

		if (begin == end) {
			ret.add(list.get(begin));
			return ret;
		} else if (begin + 1 == end) {
			System.out.println(list);
			Interval mer = merge(list.get(begin), list.get(end));
			if (mer != null) {
				ret.add(mer);
				return ret;
			} else {
				ret.add(list.get(begin));
				ret.add(list.get(end));
				return ret;
			}
		} else {
			int mid = (begin + end) / 2;
			List<Interval> left = mergeList(list, begin, mid);
			List<Interval> right = mergeList(list, mid + 1, end);

			if (left.size() + right.size() == end - begin + 1)
				return list;

			if (left.size() == 0) {
				return right;
			} else if (right.size() == 0)
				return left;
			else {
				ret.addAll(left);
				ret.addAll(right);
				if (canMerge(left.get(left.size() - 1), right.get(0))) {
					return mergeList(ret, 0, ret.size() - 1);
				} else
					return ret;

			}

		}
	}

	boolean canMerge(Interval o1, Interval o2) {
		if (o1.start > o2.end || o1.end < o2.start)
			return false;
		else
			return true;
	}

	Interval merge(Interval o1, Interval o2) {
		if (canMerge(o1, o2))
			return new Interval(Math.min(o1.start, o2.start), Math.max(o1.end, o2.end));
		else
			return null;
	}

	class IntervalComparator implements Comparator<Interval> {

		@Override
		public int compare(Interval o1, Interval o2) {
			if (o1.start < o2.start)
				return -1;
			else if (o1.start > o2.start)
				return 1;
			else {
				if (o1.end < o2.end)
					return -1;
				else if (o1.end > o2.end)
					return 1;
				else
					return 0;
			}

		}

	}
}
