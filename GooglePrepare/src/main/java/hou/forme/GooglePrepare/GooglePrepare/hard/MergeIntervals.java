package hou.forme.GooglePrepare.GooglePrepare.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import hou.forme.GooglePrepare.GooglePrepare.structure.Interval;

/**
 * @author houweitao
 * @date 2016年12月5日下午4:47:42
 * @end 2016年12月05日16:55:05
 */

public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> ret = new ArrayList<>();
		if (intervals == null || intervals.size() == 1)
			return intervals;

		Collections.sort(intervals, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				if (o1.start < o2.start)
					return -1;
				else if (o1.start > o2.start)
					return 1;
				else
					return 0;
			}
		});

		Interval interval = intervals.get(0);
		for (int i = 0; i < intervals.size(); i++) {
			Interval cur = intervals.get(i);
			if (interval.end >= cur.start)
				interval.end = Math.max(interval.end, cur.end);
			else {
				ret.add(interval);
				interval = cur;
			}
		}
		ret.add(interval);

		return ret;
	}
}
