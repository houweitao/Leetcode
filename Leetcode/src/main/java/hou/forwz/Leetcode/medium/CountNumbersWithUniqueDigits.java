package hou.forwz.Leetcode.medium;

/**
 * @author houweitao
 * @date 2016年7月19日下午11:20:08
 */

public class CountNumbersWithUniqueDigits {
	public static void main(String[] args) {
		CountNumbersWithUniqueDigits cn = new CountNumbersWithUniqueDigits();
		System.out.println(cn.countNumbersWithUniqueDigits(3));
	}

	public int countNumbersWithUniqueDigits(int n) {
        if(n==0)
            return 1;
		else if (n == 1)
			return 10;
		else if (n == 2)
			return 91;
		else {
			int sum = 91;
			int last = 81;
			int cheng = 8;
			for (int i = 3; i <= n; i++) {
				int cur = last * cheng--;
				last=cur;
				sum = sum + cur;
			}

			return sum;
		}

	
    }

}
