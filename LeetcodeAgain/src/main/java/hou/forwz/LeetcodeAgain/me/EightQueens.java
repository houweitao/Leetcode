package hou.forwz.LeetcodeAgain.me;

/**
 * @author houweitao
 * @date 2016年9月22日上午1:13:45
 */

public class EightQueens {
	public static void main(String[] args) {
		EightQueens eq = new EightQueens();
		eq.out();

	}

	void out() {
		int[] queen = new int[8];

		int count = 0;
		int pos = 0;
		while (pos >= 0) {
			System.out.println(pos);
			queen[pos]++;

			if (queen[pos] == 9) {
				queen[pos] = 0;
				pos--;
			} else {
				if (nice(queen, pos)) {
					// System.out.println("nice " + "," + pos);
					if (pos == 7) {
						System.out.println("add");
						count++;
					} else {
						pos++;
					}
				}
			}
		}
		System.out.println(count);
	}

	private boolean nice(int[] queen, int pos) {
		for (int i = 0; i < pos; i++) {
			if (queen[i] == queen[pos] || Math.abs(i - pos) == Math.abs(queen[i] - queen[pos]))
				return false;
		}

		return true;
	}
}
