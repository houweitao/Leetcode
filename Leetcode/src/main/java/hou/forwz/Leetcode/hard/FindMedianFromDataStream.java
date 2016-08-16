package hou.forwz.Leetcode.hard;

import java.util.*;

/**
 * @author houweitao
 * @date 2016年8月16日下午10:10:19
 * @url https://discuss.leetcode.com/topic/27521/short-simple-java-c-python-o-
 *      log-n-o-1
 */

public class FindMedianFromDataStream {
	public class MedianFinder {

		private Queue<Long> small = new PriorityQueue<Long>(), large = new PriorityQueue<Long>();

		public void addNum(int num) {
			large.add((long) num);
			small.add(-large.poll());
			if (large.size() < small.size())
				large.add(-small.poll());
		}

		public double findMedian() {
			return large.size() > small.size() ? large.peek() : (large.peek() - small.peek()) / 2.0;
		}
	};

	// Your MedianFinder object will be instantiated and called as such:
	// MedianFinder mf = new MedianFinder();
	// mf.addNum(1);
	// mf.findMedian();
}
