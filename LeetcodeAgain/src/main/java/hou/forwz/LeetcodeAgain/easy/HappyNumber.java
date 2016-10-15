package hou.forwz.LeetcodeAgain.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author houweitao
 * @date 2016年10月9日下午4:05:51
 */

public class HappyNumber {
	public static void main(String[] args) {
		HappyNumber hn = new HappyNumber();
		System.out.println(hn.isHappy(19));
	}

	public boolean isHappy(int n) {
		Set<Integer> record = new HashSet<>();
		while (n > 0) {
			System.out.println(n);
			if (n == 1)
				return true;

			if (!record.add(n)) {
				return false;
			}
			int next = 0;
			while (n > 0) {
				next += (n % 10) * (n % 10);
				n = n / 10;
			}

			n = next;
		}

		return true;
	}
}
