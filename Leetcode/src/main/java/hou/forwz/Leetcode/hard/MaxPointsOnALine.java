package hou.forwz.Leetcode.hard;

import java.util.HashMap;
import java.util.Map;

import hou.forwz.Leetcode.structure.Point;

/**
 * @author houweitao
 * @date 2016年7月31日上午12:49:20
 */

public class MaxPointsOnALine {
	public int maxPoints(Point[] points) {
		if (points.length < 3)
			return points.length;

		int max = 1;
		for (int i = 0; i < points.length; i++) {
			int shu = 0;
			int chongfu = 1;
			int maxK = 0;
			Map<Double, Integer> map = new HashMap<>();

			for (int j = i + 1; j < points.length; j++) {
				if (points[j].x == points[i].x) {
					if (points[j].y == points[i].y)
						chongfu++;
					else
						shu++;
				} else {
					double k = ((double) points[j].y - (double) points[i].y)
							/ ((double) points[j].x - (double) points[i].x);
					System.out.println(i + "," + j + ": " + k);
					if (map.containsKey(k)) {
						int now = map.get(k) + 1;
						maxK = Math.max(maxK, now);
						map.put(k, now);
					} else {
						maxK = Math.max(maxK, 1);
						map.put(k, 1);
					}
				}

				// for (Map.Entry<Double, Integer> entry : map.entrySet()) {
				// System.out.println(entry.getKey() + ":" + entry.getValue());
				// }
				max = Math.max(max, Math.max(shu + chongfu, maxK + chongfu));

			}

		}
		return max;

	}

}
