package hou.forme.GooglePrepare.GooglePrepare.hard;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author houweitao
 * @date 2016年12月6日下午3:46:57
 */

public class FindMedianFromDataStream {

	public static void main(String[] args) {
		PriorityQueue<Integer> big = new PriorityQueue<>();
		big.add(1);
		big.add(3);
		big.add(2);
		System.out.println(big.poll());
	}

	public class MedianFinder {

		private Queue<Long> small = new PriorityQueue<Long>(), large = new PriorityQueue<Long>();

		public void addNum(int num) {
			long cur = (long) num;
			large.add(cur);
			small.offer(-large.poll());

			if (small.size() > large.size()) {
				large.offer(-small.poll());
			}
		}

		public double findMedian() {
			if (large.size() - 1 == small.size())
				return large.peek();
			else {
				return ((double) large.peek() - (double) small.peek()) / 2;
			}
		}
	};

	// Your MedianFinder object will be instantiated and called as such:
	// MedianFinder mf = new MedianFinder();
	// mf.addNum(1);
	// mf.findMedian();
}
