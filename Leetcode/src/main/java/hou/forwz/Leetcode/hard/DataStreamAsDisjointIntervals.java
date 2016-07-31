package hou.forwz.Leetcode.hard;

import java.util.ArrayList;
import java.util.List;

import hou.forwz.Leetcode.structure.Interval;

/**
 * @author houweitao
 * @date 2016年7月31日下午11:19:55
 */

public class DataStreamAsDisjointIntervals {
	/**
	 * Definition for an interval. public class Interval { int start; int end;
	 * Interval() { start = 0; end = 0; } Interval(int s, int e) { start = s;
	 * end = e; } }
	 */
	public class SummaryRanges {

		List<Interval> list;

		/** Initialize your data structure here. */
		public SummaryRanges() {
			list = new ArrayList<>();
		}

		public void addNum(int val) {
			Interval cur = new Interval(val, val);

			if (list.size() == 0)
				list.add(cur);
			else if (list.get(0).start > val + 1)
				list.add(0, cur);
			else if (list.get(list.size() - 1).end < val - 1)
				list.add(cur);
			else {
				int pos = -1;
				for (int i = 0; i < list.size() - 1; i++) {
					if (list.get(i).start == val + 1) {
						list.get(i).start = val;
						return;
					}
					if (list.get(i).end == val - 1) {
						list.get(i).end = val;

						if (i != list.size() - 1) {
							if (list.get(i + 1).start == val + 1) {
								list.get(i).end = list.get(pos + 1).end;
								list.remove(pos + 1);
							}
						}
						return;
					}
					if (list.get(i).end < val - 1 && list.get(i + 1).start > val + 1) {
						list.add(i + 1, cur);
						return;
					}
				}
			}
		}

		public List<Interval> getIntervals() {
			return list;
		}
	}

	/**
	 * Your SummaryRanges object will be instantiated and called as such:
	 * SummaryRanges obj = new SummaryRanges(); obj.addNum(val); List
	 * <Interval> param_2 = obj.getIntervals();
	 */
}
