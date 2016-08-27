package hou.forwz.LeetcodeAgain.hard;

/**
 * @author houweitao
 * @date 2016年8月27日下午11:47:50
 */

public class SelfCrossing {

	public boolean isSelfCrossing(int[] x) {
		for (int i = 0; i < x.length; i++) {
			if (i + 3 < x.length) {
				int a = x[i], b = x[i + 1], c = x[i + 2], d = x[i + 3];

				if (c <= a && b <= d)
					return true;

				if (i + 4 < x.length) {
					int e = x[i + 4];

					if (d < b && e >= c || d == b && a + e >= c)
						return true;

					if (i + 5 < x.length) {
						int f = x[i + 5];

						if (b < d && (e < c - a && f >= d || e >= c - 1 && e <= c && f >= d - b))
							return true;
						if (d == b && f >= d)
							return true;
						if (b > d && (e >= c || (f >= d && e < c)))
							return true;
					}

				}

			}

		}
		return false;
	}

	// public boolean isSelfCrossingBetter(int[] x) {
	// for (int i = 0; i < 1; i++) {
	// if (i + 3 < x.length) {
	// int a = x[i], b = x[i + 1], c = x[i + 2], d = x[i + 3];
	//
	// if (c <= a && b <= d)
	// return true;
	//
	// if (i + 4 < x.length) {
	// int e = x[i + 4];
	//
	// if (d < b && e >= c || d == b && a + e >= c)
	// return true;
	//
	// if (i + 5 < x.length) {
	// int f = x[i + 5];
	//
	// if (b < d && (e < c - a && f >= d || e >= c - 1 && e <= c && f >= d - b))
	// return true;
	// if (d == b && f >= d)
	// return true;
	// if (b > d && (e >= c || (f >= d && e < c)))
	// return true;
	// }
	//
	// }
	//
	// }
	//
	// }
	//
	//
	// for(int i=2;i+5<x.length;i++){
	// int a = x[i], b = x[i + 1], c = x[i + 2], d = x[i + 3];
	// int e = x[i + 4];
	// int f = x[i + 5];
	//
	// if (b < d && (e < c - a && f >= d || e >= c - 1 && e <= c && f >= d - b))
	// return true;
	// if (d == b && f >= d)
	// return true;
	// if (b > d && (e >= c || (f >= d && e < c)))
	// return true;
	// }
	//
	// for(int i=)
	//
	//
	// return false;
	// }

}
