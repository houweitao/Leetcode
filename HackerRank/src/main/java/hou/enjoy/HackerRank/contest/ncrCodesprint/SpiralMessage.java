package hou.enjoy.HackerRank.contest.ncrCodesprint;

import java.util.Scanner;

/**
 * @author houweitao
 * @date 2016年11月7日上午10:48:11
 * @url https://www.hackerrank.com/contests/ncr-codesprint/challenges/spiral-message
 */

public class SpiralMessage {
	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		init();
	}

	private static void init() {
		Scanner in = new Scanner(System.in);
		int shu = in.nextInt();
		int heng = in.nextInt();
		char[][] map = new char[shu][heng];
		for (int i = 0; i < shu; i++) {
			String cur = in.next();
			char[] chs = cur.toCharArray();
			for (int j = 0; j < heng; j++) {
				map[i][j] = chs[j];
			}
		}
		String str = getMessage(map);
		// System.out.println(str);
		System.out.println(count(str));
	}

	private static int count(String str) {
		char last = '#';
		int ret = 0;
		for (int i = 0; i < str.length(); i++) {
			char cur = str.charAt(i);
			if (last == '#' && Character.isAlphabetic(cur)) {
				ret++;
			}
			last = cur;
		}
		return ret;
	}

	private static String getMessage(char[][] map) {
		int shu = map.length, heng = map[0].length;

		int left = 0, right = heng - 1, up = 0, down = shu - 1;

		StringBuilder sb = new StringBuilder();
		boolean last = false;
		while (left <= right && up <= down) {
			if (left == right)
				last = true;
			for (int i = down; i >= up; i--) {
				sb.append(map[i][left]);
			}
			if (last)
				break;
			left++;

			if (up == down)
				last = true;
			for (int i = left; i <= right; i++) {
				sb.append(map[up][i]);
			}
			up++;
			if (last)
				break;

			if (left == right)
				last = true;
			for (int i = up; i <= down; i++) {
				sb.append(map[i][right]);
			}
			right--;
			if (last)
				break;

			if (up == down)
				last = true;
			for (int i = right; i >= left; i--) {
				sb.append(map[down][i]);
			}
			down--;
			if (last)
				break;

		}
		return sb.toString();
	}
}
