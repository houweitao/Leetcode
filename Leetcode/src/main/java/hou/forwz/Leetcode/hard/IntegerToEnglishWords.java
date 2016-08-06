package hou.forwz.Leetcode.hard;

/**
 * @author houweitao
 * @date 2016年8月6日下午11:19:04
 * @mafan 2016年08月07日00:01:25
 */

public class IntegerToEnglishWords {
	public static void main(String[] args) {
		IntegerToEnglishWords te = new IntegerToEnglishWords();
		System.out.println(te.generate(100)+"end");
		System.out.println(te.numberToWords(100406));
		System.out.println(te.numberToWords(101406));
	}

	public String numberToWords(int num) {
		String str = num + "";
		int len = (str).length();

		char[] record = new char[len];
		for (int i = 0; i < len; i++) {
			record[i] = str.charAt(i);
		}

		String ret = "";
		String[] danwei = { "", "Hundred", "Thousand", "Million", "Billion" };
		for (int i = 0; i < danwei.length; i++) {
			int cur = len - 1 - i * 3;
			int n = 0;
			String nStr = "";
			for (int j = 0; j < 3; j++) {
				int now = cur - j;
				if (now < 0) {
					break;
				} else {
					nStr = record[now] + nStr;
				}
			}
			if (nStr.length() > 0) {
				n = Integer.valueOf(nStr);
				if (n > 0) {
					System.out.println(n);
					String part = generate(n);
					ret = part + " " + danwei[i] + " " + ret;
				}
			}
		}

		// for(int )

		return ret;
	}

	private String generate(int n) {
		String ret = "";
		String[] danwei = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
				"Tweleve", "Thirteen", "Furtheen", "Fiftheen", "Sixteen", "Seventeen", "Eighteen", "Nighteen" };
		String[] shi = { "", "", "Twenty", "Thirety", "Fourty", "Fifty", "Sixty", "Seventy", "Eighty", "Nighty" };

		int cur = n / 100;
		// System.out.println(cur+" "+danwei[cur]);
		if (cur != 0)
			ret = ret + danwei[cur] + " Handred";

		n = n % 100;

		if (n > 0 && n < 20) {
			// System.out.println(n);
			if (ret.length() > 0)
				ret = ret + " " + danwei[n];
			else
				ret = danwei[n];
		} else {
			cur = n / 10;
			if (ret.length() > 0)
				ret = ret + " " + shi[cur];
			else
				ret = shi[cur];
			n = n % 10;
			if (n == 0) {

			} else {
				ret = ret + " " + danwei[n];
			}
		}

		return ret;
	}

}
