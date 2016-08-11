package hou.forwz.Leetcode.easy;

/**
 * @author houweitao
 * @date 2016年8月11日下午10:21:48
 */

public class RansomNote {
	public static void main(String[] args) {
		RansomNote rn = new RansomNote();
		System.out.println(rn.canConstruct("b", "a"));
	}

	public boolean canConstruct(String ransomNote, String magazine) {
		int[] record = new int[26];
		for (int i = 0; i < magazine.length(); i++) {
			record[magazine.charAt(i) - 'a']++;
		}

		for (int i = 0; i < ransomNote.length(); i++) {
			char c = ransomNote.charAt(i);
			record[c - 'a']--;
			if (record[c - 'a'] < 0)
				return false;
		}
		return true;
	}

}
