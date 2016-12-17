package hou.forme.GooglePrepare.GooglePrepare.hard;

import java.util.LinkedList;
import java.util.List;

import hou.forme.GooglePrepare.GooglePrepare.structure.Interval;

/**
 * @author houweitao
 * @date 2016年12月5日下午4:57:07
 */

public class InsertInterval {

	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> result = new LinkedList<>();
		int i = 0;
		// add all the intervals ending before newInterval starts
		while (i < intervals.size() && intervals.get(i).end < newInterval.start)
			result.add(intervals.get(i++));
		// merge all overlapping intervals to one considering newInterval
		while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
			newInterval = new Interval( // we could mutate newInterval here also
					Math.min(newInterval.start, intervals.get(i).start),
					Math.max(newInterval.end, intervals.get(i).end));
			i++;
		}
		result.add(newInterval); // add the union of intervals we got
		// add all the rest
		while (i < intervals.size())
			result.add(intervals.get(i++));
		return result;
	}

}
