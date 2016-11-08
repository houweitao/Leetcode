package hou.enjoy.HackerRank.contest.ncrCodesprint;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author houweitao
 * @date 2016年11月7日上午11:12:37
 */

public class MegaTicTacToe {
	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		init();
	}

	private static void init() {
		Scanner in = new Scanner(System.in);
		int number = in.nextInt();

		for (int index = 0; index < number; index++) {
			int shu = in.nextInt();
			int heng = in.nextInt();
			int k = in.nextInt();

			char[][] map = new char[shu][heng];

			for (int i = 0; i < shu; i++) {
				char[] chs = in.next().toCharArray();
				for (int j = 0; j < shu; j++) {
					map[i][j] = chs[j];
				}
			}

			System.out.println(judge(map, shu, heng, k));
		}
	}

	private static String judge(char[][] map, int shu, int heng, int k) {
		boolean O = false;
		boolean X = false;

		for (int i = 0; i < shu; i++) {
			for (int j = 0; j < heng; j++) {
				if (map[i][j] == '-')
					continue;
				if (O && map[i][j] == 'O')
					continue;
				if (X && map[i][j] == 'X')
					continue;

				// judge right
				if (judge(map[i][j], 0, 1, 0, k, i, j, map)) {
					if (map[i][j] == 'O')
						O = true;
					else
						X = true;
				}

				// judge down
				if (judge(map[i][j], 1, 0, 0, k, i, j, map)) {
					if (map[i][j] == 'O')
						O = true;
					else
						X = true;
				}

				// judeg other
				Set<Double> set = new HashSet<>();
				for (int xia = 1; xia < shu; xia++) {
					for (int you = 1; you < heng; you++) {
						double now = (double) (xia) / (double) (you);
						if (set.add(now)) {
							if (judge(map[i][j], xia, you, 0, k, i, j, map)) {
								if (map[i][j] == 'O')
									O = true;
								else
									X = true;
							}
						} else {
							// System.out.println("jump " + xia + "," + you);
						}
					}
				}

			}

			if (O && X)
				break;
		}

		if (O && X || !O && !X)
			return "NONE";
		else if (O)
			return "WIN";
		else
			return "LOSE";
	}

	private static boolean judge(char c, int xia, int you, int now, int need, int x, int y, char[][] map) {
		if (now == need)
			return true;
		else if (in(map, x, y) && map[x][y] == c) {
			return judge(c, xia, you, now + 1, need, x + xia, y + you, map);
		} else
			return false;
	}

	private static boolean in(char[][] map, int x, int y) {
		if (x >= 0 && x < map.length && y >= 0 && y < map[0].length)
			return true;
		else
			return false;
	}

}
