package hou.forwz.Leetcode.hard;

import java.util.ArrayList;
import java.util.List;

import hou.forwz.Leetcode.structure.Interval;

/**
 * @author houweitao
 * @date 2016年7月11日下午11:31:58
 */

public class InsertInterval {
	public static void main(String[] args) {
		InsertInterval ii = new InsertInterval();
		Interval a = new Interval(1, 5);
		Interval b = new Interval(1, 7);
		Interval c = new Interval(3, 3);

		List<Interval> list = new ArrayList<>();
		list.add(a);

		System.out.println(ii.insert(list, b));
	}

	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> ret = new ArrayList<>();

		if (intervals.size() == 0) {
			ret.add(newInterval);
			return ret;
		} else {

			if (intervals.get(intervals.size() - 1).start < newInterval.start) {
				intervals.add(newInterval);
			} else {
				int begin = newInterval.start;
				for (int i = 0; i < intervals.size(); i++) {
					if (intervals.get(i).start >= begin) {
						intervals.add(i, newInterval);
						break;
					}
				}
			}

			int start = intervals.get(0).start;
			int end = intervals.get(0).end;

			for (Interval cur : intervals) {
				if (cur.start <= end) {
					end = Math.max(end, cur.end);
				} else {
					ret.add(new Interval(start, end));
					start = cur.start;
					end = cur.end;
				}
			}
			ret.add(new Interval(start, end));

			return ret;
		}
	}

}
