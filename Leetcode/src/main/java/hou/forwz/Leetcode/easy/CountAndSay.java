package hou.forwz.Leetcode.easy;

/**
 * @author houweitao
 * @date 2016年7月10日上午12:02:14
 */

public class CountAndSay {
	public static void main(String[] args) {
		CountAndSay cs = new CountAndSay();
		System.out.println(cs.countAndSay(4));
	}

	public String countAndSay(int n) {
		String seed = "1";
		if(n==1)
			return seed;
		
		for (int i = 0; i < n-1; i++) {
			seed = generate(seed);
		}
		return seed;
	}

	String generate(String str) {
		String ret = "";
		for (int i = 0; i < str.length();) {
			int j = i + 1;
			for (j = i + 1; j < str.length(); j++) {
				if (str.charAt(j) != str.charAt(i))
					break;
			}
			ret = ret + (j - i) + str.charAt(i);
			i = j;

		}

		return ret;

	}

}
