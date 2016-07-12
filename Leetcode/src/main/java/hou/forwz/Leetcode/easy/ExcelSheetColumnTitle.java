package hou.forwz.Leetcode.easy;

/**
 * @author houweitao
 * @date 2016年7月12日下午10:45:42
 */

public class ExcelSheetColumnTitle {
	public static void main(String[] args) {
		ExcelSheetColumnTitle es = new ExcelSheetColumnTitle();
		System.out.println(es.convertToTitle(26));
	}

	public String convertToTitle(int n) {
		char[] map = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
				'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
		String ret = "";
//		if (n <= 26)
//			return map[n - 1] + "";

		while (n > 0) {
			int cur = (n-1) % 26;
			int judge=n%26;
			n = n / 26;
			if(judge==0)
				n--;
			ret = map[cur] + ret;
		}

		return ret;
	}

}
