package hou.forwz.Leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author houweitao
 * @date 2016年7月8日下午8:53:41
 */

public class HappyNumber {
	public static void main(String[] args) {
		HappyNumber hn = new HappyNumber();
		System.out.println(hn.isHappy(2));
	}

	Set<Integer> set=new HashSet<>();
	public boolean isHappy(int n) {
		if(set.contains(n))
			return false;
		else
			set.add(n);
		
		System.out.println(n);
		if (n == 1)
			return true;
		else {
			int sum = 0;
			while (n > 0) {
				int cur = n % 10;
				sum = sum + cur * cur;
				n = n / 10;
			}

			return isHappy(sum);
		}
	}

}
