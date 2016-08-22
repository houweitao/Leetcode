package hou.forwz.LeetcodeAgain.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @author houweitao
 * @date 2016年8月22日下午11:42:09
 */

public class MaxPointsOnALine {

	public int maxPoints(Point[] points) {
		int max = 0;

		for (int i = 0; i < points.length; i++) {
			int shuNum = 1;
			int xieNum = 1;
			Point cur = points[i];
			Map<Double, Integer> count = new HashMap<>();
			int stand = 0;
			for (int j = 0; j < points.length; j++) {
				Point p = points[j];
				if (j == i)
					continue;

				if (p.x == cur.x) {
					if (p.y == cur.y)
						stand++;
					else
						shuNum++;// 这个 2016年08月22日23:58:38
				} else {
					double xie = (p.y - cur.y) / (p.x - cur.x);
					if (xie == -0)
						xie = 0;
					if (!count.containsKey(xie))
						count.put(xie, 1);

					count.put(xie, count.get(xie) + 1);
					xieNum = Math.max(xieNum, count.get(xie));
				}

			}

			max = Math.max(max, Math.max(shuNum + stand, xieNum + stand));
		}
		return max;

	}

	class Point {
		int x;
		int y;

		Point() {
			x = 0;
			y = 0;
		}

		Point(int a, int b) {
			x = a;
			y = b;
		}
	}
}
