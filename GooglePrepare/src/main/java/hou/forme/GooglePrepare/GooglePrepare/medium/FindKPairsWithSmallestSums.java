package hou.forme.GooglePrepare.GooglePrepare.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author houweitao
 * @date 2016年12月7日下午3:15:29
 * @end 2016年12月07日15:36:40
 */

public class FindKPairsWithSmallestSums {
	public static void main(String[] args) {
		FindKPairsWithSmallestSums fp = new FindKPairsWithSmallestSums();
		int[] nums1 = { 1, 7, 11 };
		int[] nums2 = { 2, 4, 6 };

		fp.kSmallestPairs(nums1, nums2, 3);
	}

	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<int[]> ret = new ArrayList<>();
		if (k < 1 || nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
			return ret;
		else if (k == 1) {
			int[] tmp = { nums1[0], nums2[0] };
			ret.add(tmp);
			return ret;
		} else {
			PriorityQueue<Pair> queue = new PriorityQueue<>(k, new Comparator<Pair>() {

				@Override
				public int compare(Pair o1, Pair o2) {
					return Integer.compare(o1.sum, o2.sum);
				}
			});

			boolean[][] visited = new boolean[nums1.length][nums2.length];
			Pair first = new Pair(0, 0, nums1, nums2);
			queue.offer(first);

			int count = 0;
			while (!queue.isEmpty() && count < k) {
				Pair out = queue.poll();
				ret.add(out.toNeed());
				System.out.println(out);

				count++;
				int outX = out.left;
				int outY = out.right;

				if (outX + 1 < nums1.length && !visited[outX + 1][outY]) {
					queue.offer(new Pair(outX + 1, outY, nums1, nums2));
					visited[outX + 1][outY] = true;
				}
				if (outY + 1 < nums2.length && !visited[outX][outY + 1]) {
					queue.offer(new Pair(outX, outY + 1, nums1, nums2));
					visited[outX][outY + 1] = true;
				}
			}

			return ret;
		}
	}

	class Pair {
		int sum;
		int left;
		int right;

		int[] nums1;
		int[] nums2;

		public Pair(int left, int right, int[] nums1, int[] nums2) {
			super();
			this.left = left;
			this.right = right;
			this.nums1 = nums1;
			this.nums2 = nums2;
			sum = nums1[left] + nums2[right];
		}

		public int[] toNeed() {
			return new int[] { nums1[left], nums2[right] };
		}

		@Override
		public String toString() {
			return "Pair [sum=" + sum + ", left=" + left + ", right=" + right + "]";
		}

	}

}
