package hou.forwz.Leetcode.hard;

import java.util.*;

/**
 * @author houweitao
 * @date 2016年8月16日上午12:06:29
 * @notNice 2016年08月16日00:52:23
 */

public class TheSkylineProblem {
	public static void main(String[] args) {
		TheSkylineProblem sp = new TheSkylineProblem();
		int[][] buildings = { { 0, 2, 3 }, { 2, 5, 3 } };
		List<int[]> list = sp.getSkyline(buildings);
		for (int[] i : list) {
			System.out.println(i[0] + "," + i[1] + ",,");
		}

	}

	public List<int[]> getSkyline(int[][] buildings) {
		List<int[]> ret = new LinkedList<>();
		if (buildings.length == 0)
			return ret;
		if (buildings.length == 1) {
			int[] begin = { buildings[0][0], buildings[0][2] };
			int[] end = { buildings[0][1], 0 };
			ret.add(begin);
			ret.add(end);
			return ret;
		}

		List<Building> list = new ArrayList<>();
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for (int i = 0; i < buildings.length; i++) {
			min = Math.min(min, buildings[i][0]);
			max = Math.max(max, buildings[i][1]);
			list.add(new Building(buildings[i][0], buildings[i][1], buildings[i][2]));
		}

		Collections.sort(list, new BuildComparator());

		int[] help = new int[max + 1];

		for (int i = 0; i < list.size(); i++) {

			int height = list.get(i).height;
			for (int k = list.get(i).left; k <= list.get(i).right; k++) {
				help[k] = height;
			}

			for (int j = i + 1; j < list.size(); j++) {
				int cha = list.get(j).left - list.get(i).right;
				if (cha > 0) {
					break;
				} else if (cha == 0) {
					help[list.get(i).right] = Math.max(list.get(i).height, list.get(j).height);
				} else {
					int to = list.get(i).right;
					int from = list.get(j).left;
					int num = list.get(j).height;
					if (list.get(i).height < list.get(j).height) {
						for (int k = from; k <= to; k++) {
							help[k] = num;
						}
					}
				}
			}

		}

		if (min == Integer.MAX_VALUE)
			return ret;

		int[] begin = { min, help[min] };
		ret.add(begin);

		for (int i = min; i < max; i++) {
			if (help[i + 1] != help[i]) {
				int[] cur = { i + 1, help[i + 1] };
				ret.add(cur);
			}
		}

		int[] end = { max, 0 };
		ret.add(end);

		return ret;
	}

	class BuildComparator implements Comparator<Building> {

		@Override
		public int compare(Building o1, Building o2) {
			if (o1.left > o2.left)
				return 1;
			else if (o1.left < o2.left)
				return -1;
			else
				return 0;
		}

	}

	class Building {
		int left;
		int right;
		int height;

		public Building(int left, int right, int height) {
			super();
			this.left = left;
			this.right = right;
			this.height = height;
		}
	}
}
