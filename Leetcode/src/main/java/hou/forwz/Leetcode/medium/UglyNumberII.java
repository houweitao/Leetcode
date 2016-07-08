package hou.forwz.Leetcode.medium;

/**
 * @author houweitao
 * @date 2016年7月8日下午9:01:38
 */

public class UglyNumberII {
	public int nthUglyNumber(int n) {
		int not=0;
		for(int i=6;i<Integer.MAX_VALUE;i++){
			if(!isUgly(i))
				not++;
			
			if(i-not==n)
				return i;
		}
		return -1;
	}
	public boolean isUgly(int n) {
		long num = n;
		if (num < 0)
			num = -num;

		boolean judge = true;
		while (judge && num > 1) {
			judge = false;

			if (num % 2 == 0) {
				judge = true;
				num = num / 2;
			}
			if (num % 3 == 0) {
				judge = true;
				num = num / 3;
			}
			if (num % 5 == 0) {
				judge = true;
				num = num / 5;
			}
			
			System.out.println(num);
		}

		if (num == 1)
			return true;
		else
			return false;
	}
}
