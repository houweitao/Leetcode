package hou.forme.GooglePrepare.GooglePrepare.easy;

/**
 * @author houweitao
 * @date 2016年12月7日下午1:01:45
 */

public class PowerOfThree {
	public boolean isPowerOfThree(int n) {
		// 1162261467 is 3^19, 3^20 is bigger than int
		return (n > 0 && 1162261467 % n == 0);
	}
}
