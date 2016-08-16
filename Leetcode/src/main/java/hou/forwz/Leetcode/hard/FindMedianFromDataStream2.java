package hou.forwz.Leetcode.hard;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author houweitao
 * @date 2016年8月16日下午10:21:12
 */

public class FindMedianFromDataStream2 {
	public static void main(String[] args) {
		Queue<Integer> small = new PriorityQueue<Integer>();
		Queue<Integer> large = new PriorityQueue<Integer>();

		large.offer(2);
		large.offer(1);
		large.offer(3);

		System.out.println(large.poll());

	}

	public class MedianFinder {

		private Queue<Long> small = new PriorityQueue<Long>(), large = new PriorityQueue<Long>();

		public void addNum(int num) {
			long cur = (long) num;
			large.add(cur);
			small.offer(-large.poll());
			
			if(small.size()>large.size()){
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
