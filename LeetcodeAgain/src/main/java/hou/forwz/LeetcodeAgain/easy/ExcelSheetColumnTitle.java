package hou.forwz.LeetcodeAgain.easy;

/**
 * @author houweitao
 * @date 2016年9月18日上午1:54:04
 */

public class ExcelSheetColumnTitle {
	public static void main(String[] args) {
		ExcelSheetColumnTitle es = new ExcelSheetColumnTitle();
		System.out.println(es.convertToTitle(28));
	}

	public String convertToTitle(int n) {
		String sb = new String();
		while (n > 0) {
			int pos = (n - 1) % 26;
			n = (n-1) / 26;
			char c = (char) ('A' + pos);
			sb = c + sb;
		}

		return sb.toString();
	}

}
