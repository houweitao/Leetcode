package hou.forwz.Leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * @author houweitao
 * @date 2016年7月19日下午11:31:11
 */

public class WaterAndJugProblem {
	static int one, two, need;

	public static void main(String[] args) {
		WaterAndJugProblem wa = new WaterAndJugProblem();
		one = 3;
		two = 4;
		need = 5;
		System.out.println(wa.canMeasureWater(one, two, need));

	}

	public boolean canMeasureWater(int x, int y, int z) {

		Stack<Status> stack = new Stack<>();
		Set<Status> set = new HashSet<>();

		Status status = new Status(0, 0);
		stack.push(status);
		set.add(status);

		while (!stack.isEmpty()) {
			System.out.println(stack);

			Status cur = stack.peek();
			List<Status> next = cur.make();
			// System.out.println(next);

			boolean find = false;
			if (cur.dir <= next.size() - 1 && !find)
				while (cur.dir < next.size() - 1) {
					cur.dir++;
					Status stat = next.get(cur.dir);
					if (stat.x == need || stat.y == need || (stat.x + stat.y == need)) {
						stack.push(stat);
						set.add(stat);
						System.out.println(stack);
						return true;
					} else {
						 if (!stack.contains(stat)) {
//						if (!set.contains(stat)) {
							// System.out.println("push " + stat);
							stack.push(stat);
							set.add(stat);
							find = true;
							break;
						}
					}

				}
			if (!find)
				set.remove(stack.pop());

		}
		return false;
	}

	class Status {
		int x;
		int fullX = one;
		int y;
		int fullY = two;
		int dir;

		Status(int x, int y) {
			this.x = x;
			this.y = y;
			dir = -1;
		}

		private List<Status> make() {
			List<Status> next = new ArrayList<>();

			if (x != fullX) {
				next.add(new Status(fullX, y));
			}
			if (x != 0)
				next.add(new Status(0, y));
			if (x != 0 && y != fullY)
				next.add(new Status((x + y - fullY) < 0 ? 0 : (x + y - fullY), (x + y - fullY) >= 0 ? fullY : (x + y)));

			if (y != fullY) {
				next.add(new Status(x, fullY));
			}
			if (y != 0)
				next.add(new Status(x, 0));
			if (y != 0 && x != fullY)
				next.add(new Status((x + y - fullX) < 0 ? (x + y) : fullY, (x + y - fullY) < 0 ? 0 : (x + y - fullY)));

			return next;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "[" + x + "," + y + "]";
		}

		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return x + y;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Status) {
				Status s = (Status) obj;
				if (s.x == x && s.y == y)
					return true;
			}

			return false;
		}
	}
}
