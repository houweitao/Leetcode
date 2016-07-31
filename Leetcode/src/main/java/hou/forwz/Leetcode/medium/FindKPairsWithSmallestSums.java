package hou.forwz.Leetcode.medium;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author houweitao
 * @date 2016年7月31日下午10:36:59
 */

public class FindKPairsWithSmallestSums {
	public static void main(String[] args) {
		FindKPairsWithSmallestSums fp = new FindKPairsWithSmallestSums();
		System.out.println(fp.kSmallestPairs(new int[] { 1, 2, 4, 5, 6 }, new int[] { 3, 5, 7, 9 }, 3));
	}

	public List<int[]> kSmallestPairs(int[] one, int[] two, int k) {
		List<Pair> list = new ArrayList<>();
		for (int i = 0; i < one.length; i++) {
			for (int j = 0; j < two.length; j++) {
				list.add(new Pair(one[i], two[j]));
			}
		}

		Collections.sort(list, new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				int cha = o1.u + o1.v - o2.u - o2.v;
				if (cha == 0)
					return 0;
				else if (cha > 0)
					return 1;
				else
					return -1;

			}

		});
//		System.out.println("list: " + list);
		List<int[]> ret = new LinkedList<>();

		int i = 0;
		for (Pair pair : list) {
			if (i >= k)
				break;
			ret.add(new int[] { pair.u, pair.v });
			i++;
		}
		return ret;
	}

	class Pair {
		int u;
		int v;

		Pair(int u, int v) {
			this.u = u;
			this.v = v;
		}

		@Override
		public String toString() {
			return "Pair [u=" + u + ", v=" + v + "]";
		}

	}

}
