package hou.forwz.LeetcodeAgain.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import hou.forwz.LeetcodeAgain.structure.Interval;

/**
 * @author houweitao
 * @date 2016年9月18日上午12:30:28
 */

public class MergeIntervals {

	public List<Interval> merge(List<Interval> intervals) {
		if (intervals.size() < 2)
			return intervals;

		List<Interval> ret = new ArrayList<>();
		Collections.sort(intervals, new IntervalComp());
		Interval inter = new Interval(intervals.get(0).start, intervals.get(0).end);
		for (int i = 1; i < intervals.size(); i++) {
			Interval cur = intervals.get(i);
			if (cur.start <= inter.end) {
				inter.end = Math.max(inter.end, cur.end);
			} else {
				ret.add(inter);
				inter = cur;
			}
		}
		ret.add(inter);
		return ret;
	}

	class IntervalComp implements Comparator<Interval> {

		@Override
		public int compare(Interval o1, Interval o2) {
			if (o1.start == o2.start)
				return 0;
			else if (o1.start < o2.start)
				return -1;
			else
				return 1;
		}

	}

}
