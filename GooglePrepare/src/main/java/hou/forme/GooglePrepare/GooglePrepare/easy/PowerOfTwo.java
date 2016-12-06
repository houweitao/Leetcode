package hou.forme.GooglePrepare.GooglePrepare.easy;

/**
 * @author houweitao
 * @date 2016年12月6日下午1:52:52
 */

public class PowerOfTwo {

	public boolean isPowerOfTwo(int n) {
		if (n <= 0)
			return false;
		return (n & (n - 1)) == 1;
	}

}
