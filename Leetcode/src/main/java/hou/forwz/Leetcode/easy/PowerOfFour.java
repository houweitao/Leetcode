package hou.forwz.Leetcode.easy;

/**
 * @author houweitao
 * @date 2016年8月9日下午10:00:49
 */

public class PowerOfFour {

	public boolean isPowerOfFour(int num) {
		if (num == 0)
			return false;
		if ((num & (num - 1)) == 0) // 为2的幂
		{
			if ((num & 0x55555555) == num) // 为4的幂
			{
				return true;
			}
		}
		return false;
	}

}
