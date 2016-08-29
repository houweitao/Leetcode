package hou.forwz.LeetcodeAgain.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年8月29日上午1:04:41 @laji... 2016年08月29日01:27:53
 */

public class TheSkylineProblem {

	public List<int[]> getSkyline(int[][] buildings) {

		return help(buildings, 0, buildings.length - 1);
	}

	private List<int[]> help(int[][] buildings, int left, int right) {
		if (left < right) {
			int mid = left + (right - left) / 2;
			return mergeMe(help(buildings, left, mid), help(buildings, mid + 1, right));
		} else {
			List<int[]> ret = new ArrayList<>();
			if (left > right)
				return ret;

			int[] begin = { buildings[left][0], buildings[left][2] };
			int[] end = { buildings[left][1], 0 };

			ret.add(begin);
			ret.add(end);

			return ret;
		}
	}

	private List<int[]> merge(List<int[]> one, List<int[]> two) {
		int h1 = 0, h2 = 0;
		List<int[]> ret = new ArrayList<>();
		while (one.size() > 0 && two.size() > 0) {
			int o = one.get(0)[0];
			int t = two.get(0)[0];
			int h = 0;
			int heng = 0;

			if (o < t) {
				h1 = one.get(0)[1];
				h = Math.max(h1, h2);
				heng = o;
				one.remove(0);
			} else if (o > t) {
				h2 = two.get(0)[1];
				h = Math.max(h1, h2);
				two.remove(0);
				heng = t;
			} else {
				h1 = one.get(0)[1];
				h2 = two.get(0)[1];
				h = Math.max(h1, h2);
				heng = o;
				one.remove(0);
				two.remove(0);
			}

			if (ret.size() == 0 || h != ret.get(ret.size() - 1)[1]) {
				int[] tmp = { heng, h };
				ret.add(tmp);
			}

		}
		ret.addAll(one);
		ret.addAll(two);

		return ret;
	}

	private List<int[]> mergeMe(List<int[]> one, List<int[]> two) {
		int h1 = 0, h2 = 0;
		List<int[]> ret = new ArrayList<>();

		while (one.size() > 0 && two.size() > 0) {
			int o = one.get(0)[0];
			int t = two.get(0)[0];
			int heng;
			int h;
			if (o < t) {
				heng = o;
				h1 = one.get(0)[1];
				h = Math.max(h2, h1);
				one.remove(0);
			} else if (o > t) {
				heng = t;
				h2 = two.get(0)[1];
				h = Math.max(h1, h2);
				two.remove(0);
			} else {
				heng = o;
				h1 = one.get(0)[1];
				h2 = two.get(0)[1];
				h = Math.max(h1, h2);
				// h = Math.max(h1, h);
				one.remove(0);
				two.remove(0);
			}

			if (ret.size() == 0 || ret.get(ret.size() - 1)[1] != h) {
				int[] tmp = { heng, h };
				ret.add(tmp);
			}

		}
		ret.addAll(one);
		ret.addAll(two);

		return ret;
	}

}
