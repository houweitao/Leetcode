package hou.forwz.LeetcodeAgain.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author houweitao
 * @date 2016年9月6日下午3:37:28
 */

public class FindMedianFromDataStream {
	public static void main(String[] args) {
		FindMedianFromDataStream fm = new FindMedianFromDataStream();
		fm.init();
	}

	private void init() {
		MedianFinder mf = new MedianFinder();
		mf.addNum(2);
		System.out.println(mf.findMedian());
		mf.addNum(3);
		System.out.println(mf.findMedian());
	}

	public class MedianFinder {
		PriorityQueue<Integer> big = new PriorityQueue<>();
		PriorityQueue<Integer> small = new PriorityQueue<>(1, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return -o1.compareTo(o2);
			}
		});

		// Adds a number into the data structure.
		public void addNum(int num) {
			big.offer(num);

			if (small.size() > 0 && big.peek() < small.peek()) {
				big.offer(small.poll());
				small.offer(big.poll());
			}
			if (big.size() - small.size() > 1) {
				small.offer(big.poll());
			}

		}

		// Returns the median of current data stream
		public double findMedian() {
			double ret = 0;
			if (big.size() == small.size()) {
				ret = ((double)big.peek() + (double)small.peek()) / 2;
			} else {
				ret = big.peek();
			}

			System.out.println("big " + big);
			System.out.println("small " + small);

			return ret;
		}
	};

	// Your MedianFinder object will be instantiated and called as such:
	// MedianFinder mf = new MedianFinder();
	// mf.addNum(1);
	// mf.findMedian();
}
