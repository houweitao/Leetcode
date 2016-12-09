package hou.forme.GooglePrepare.GooglePrepare.midium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author houweitao
 * @date 2016年12月9日下午3:35:15
 */

public class QueueReconstructionByHeight {
	public static void main(String[] args) {
		QueueReconstructionByHeight qr = new QueueReconstructionByHeight();
		int[][] people = { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } };
		qr.reconstructQueue(people);
	}

	public int[][] reconstructQueue(int[][] people) {
		if (people == null || people.length == 0 || people[0].length == 0)
			return new int[0][0];

		Arrays.sort(people, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				if (b[0] == a[0])
					return a[1] - b[1];
				return b[0] - a[0];
			}
		});

		int n = people.length;
		ArrayList<int[]> tmp = new ArrayList<>();
		for (int i = 0; i < n; i++)
			tmp.add(people[i][1], new int[] { people[i][0], people[i][1] });

		print(tmp);
		int[][] res = new int[people.length][2];
		int i = 0;
		for (int[] k : tmp) {
			res[i][0] = k[0];
			res[i++][1] = k[1];
		}

		return res;
	}

	private void print(ArrayList<int[]> tmp) {
		for (int i = 0; i < tmp.size(); i++) {
			System.out.println(tmp.get(i)[0] + "," + tmp.get(i)[1]);
		}
	}

}
