package hou.forme.GooglePrepare.GooglePrepare.hard;

import java.util.HashSet;
import java.util.Set;

/**
 * @author houweitao
 * @date 2016年12月16日下午3:09:02
 */

public class PerfectRectangle {
	public boolean isRectangleCover(int[][] rectangles) {
		if (rectangles == null || rectangles.length < 1)
			return false;
		Set<Point> set = new HashSet<>();
		int totalArea = 0;
		for (int i = 0; i < rectangles.length; i++) {
			totalArea += (rectangles[i][3] - rectangles[i][1]) * (rectangles[i][2] - rectangles[i][0]);

			Point leftUp = new Point(rectangles[i][0], rectangles[i][1]);
			Point leftDown = new Point(rectangles[i][0], rectangles[i][3]);
			Point rightUp = new Point(rectangles[i][2], rectangles[i][3]);
			Point rightDown = new Point(rectangles[i][2], rectangles[i][1]);

			deal(leftUp, set);
			deal(leftDown, set);
			deal(rightUp, set);
			deal(rightDown, set);
		}

		int heng_left = Integer.MAX_VALUE, heng_right = Integer.MIN_VALUE, shu_down = Integer.MAX_VALUE,
				shu_up = Integer.MIN_VALUE;
		for (Point p : set) {
			heng_left = Math.min(p.x, heng_left);
			heng_right = Math.max(p.x, heng_right);
			shu_down = Math.min(p.y, shu_down);
			shu_up = Math.max(p.y, shu_up);
		}
		int area = (heng_right - heng_left) * (shu_up - shu_down);
		return set.size() == 4 && area == totalArea;
	}

	private void deal(Point leftDown, Set<Point> set) {
		if (set.contains(leftDown))
			set.remove(leftDown);
		else
			set.add(leftDown);
	}

	class Point {
		int x;
		int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			Point other = (Point) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
	}
}
