package hou.forme.GooglePrepare.GooglePrepare.lock;

/**
 * @author houweitao
 * @date 2016年12月11日下午4:28:43
 * @url http://www.programcreek.com/2014/05/leetcode-pain-fence-java/
 */

public class PainFence {
	public int numWays(int n, int k) {
		int dp[] = { 0, k, k * k, 0 };

		if (n <= 2)
			return dp[n];

		for (int i = 2; i < n; i++) {
			dp[3] = (k - 1) * (dp[1] + dp[2]);
			dp[1] = dp[2];
			dp[2] = dp[3];
		}

		return dp[3];
	}

	public int numWaysMe(int n, int k) {
		// n>=3
		int a = k;// last same
		int b = k * (k - 1);// last not same
		int pos = 3;
		while (pos <= n) {
			int nexta = b;
			int nextb = a * (k - 1) + b * (k - 1);

			a = nexta;
			b = nextb;
		}
		return a + b;
	}
}
