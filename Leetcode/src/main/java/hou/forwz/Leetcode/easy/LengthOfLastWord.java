package hou.forwz.Leetcode.easy;

/**
 * @author houweitao
 * @date 2016年7月12日上午12:14:28
 */

public class LengthOfLastWord {
	public static void main(String[] args) {
		LengthOfLastWord ll = new LengthOfLastWord();
		System.out.println(ll.lengthOfLastWord(" "));
	}

	public int lengthOfLastWord(String s) {
		String[] strs = s.split(" ");
		if (strs.length > 0)
			return strs[strs.length - 1].length();
		return 0;
	}

}
