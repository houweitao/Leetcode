package hou.forwz.Leetcode.hard;

/**
 * @author houweitao
 * @date 2016年8月17日上午12:15:56
 */

public class NumberOfDigitOne {
	public static void main(String[] args) {
		NumberOfDigitOne num = new NumberOfDigitOne();
		System.out.println(num.countDigitOne(204));
	}

	public int countDigitOne(int n) {
		int count = 0;

		for (long k = 1; k <= n; k *= 10) {
			long r = n / k, m = n % k;
			
			System.out.println(k+","+r+","+m);
			
			// sum up the count of ones on every place k
			count += (r + 8) / 10 * k + (r % 10 == 1 ? m + 1 : 0);
			System.out.println(count);
		}

		return count;
	}

}
