package hou.forwz.Leetcode.easy;

/**
 * @author houweitao
 * @date 2016年7月12日上午12:18:07
 */

public class CompareVersionNumbers {
	public int compareVersion2(String version1, String version2) {
		String[] levels1 = version1.split("\\.");
		String[] levels2 = version2.split("\\.");

		int length = Math.max(levels1.length, levels2.length);
		for (int i = 0; i < length; i++) {
			Integer v1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;
			Integer v2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;
			int compare = v1.compareTo(v2);
			if (compare != 0) {
				return compare;
			}
		}

		return 0;
	}

	public int compareVersion(String one, String two) {
		if (one.equals(two))
			return 0;
		else {
			String[] o = one.split("./");
			String[] t = two.split("./");

			String onel = o[0];
			String oner = "";
			String twol = t[0];
			String twor = "";

			if (o.length == 2)
				oner = o[1];
			if (t.length == 2)
				twor = t[1];

			int left = compareLeft(onel, twol);

			if (left != 0)
				return left;
			else {
				int right = compareRight(oner, twor);
				return right;
			}
		}

	}

	private int compareRight(String one, String two) {
		int m = one.length(), n = two.length();

		for (int i = 0; i < m && i < n; i++) {
			char o = one.charAt(i), t = two.charAt(i);
			if (o - t > 0)
				return 1;
			else if (o - t < 0)
				return -1;
		}

		if (m == n)
			return 0;
		else if (m > n)
			return 1;
		else
			return -1;
	}

	private int compareLeft(String one, String two) {
		one = deal(one);
		two = deal(two);

		int m = one.length(), n = two.length();

		if (m == n) {
			for (int i = 0; i < m; i++) {
				char o = one.charAt(i), t = two.charAt(i);
				if (o - t > 0)
					return 1;
				else if (o - t < 0)
					return -1;
			}
			return 0;
		} else if (m > n)
			return 1;
		else
			return -1;
	}

	private String deal(String str) {
		int i = 0;
		for (; i < str.length(); i++) {
			if (str.charAt(i) != '0')
				break;
		}

		String ret = str.substring(i);
		if (ret.length() > 0)
			return ret;
		else
			return "0";
	}

}
