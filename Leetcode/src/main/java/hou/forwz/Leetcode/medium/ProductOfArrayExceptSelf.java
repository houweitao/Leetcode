package hou.forwz.Leetcode.medium;

/**
 * @author houweitao
 * @date 2016年7月6日下午11:11:24
 */

public class ProductOfArrayExceptSelf {

	public int[] productExceptSelf(int[] nums) {
		int count0 = 0;
		int pos = -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				count0++;
				pos = i;

				if (count0 > 1)
					return new int[nums.length];
			}
		}

		int sum = 1;

		for (int i = 0; i < nums.length; i++) {
			if (i != pos)
				sum = sum * nums[i];
		}

		int[] ret = new int[nums.length];

		for (int i = 0; i < nums.length; i++) {
			if(pos>=0){
				if (pos != i)
					ret[i] = 0;
				else
					ret[i]=sum;
			}else{
				ret[i]=sum/nums[i];
			}
			
		}

		return ret;

	}
}
