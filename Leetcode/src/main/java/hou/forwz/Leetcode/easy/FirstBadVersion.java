package hou.forwz.Leetcode.easy;

/**
 * @author houweitao
 * @date 2016年7月17日下午10:34:25
 */

public class FirstBadVersion {

	public int firstBadVersion(int n) {
		if (isBadVersion(1))
			return 1;
		else
			return find(1, n);
	}

	private int find(int left, int right) {
		if (left == right)
			return left;
		else {
			while (left < right) {
				if (left + 1 == right) {
					if(isBadVersion(right))
						return right;
				}

				int mid = (left + right) / 2;
				if (isBadVersion(mid)) {
					return find(left, mid);
				} else
					return find(mid, right);
			}
		}

		return 0;
	}

	private boolean isBadVersion(int mid) {
		// TODO Auto-generated method stub
		return false;
	}

}
