package hou.forwz.Leetcode.hard;

import java.util.*;

/**
 * @author houweitao
 * @date 2016年8月15日下午10:44:38
 */

public class ScrambleString {
	Map<String, Set<String>> map = new HashMap<>();
	static int num = 0;

	public static void main(String[] args) {
		ScrambleString ss = new ScrambleString();

		System.out.println(ss.isScramble("abcdefghijklmn", "efghijklmncadb"));
		System.out.println(ss.isScramble("a", "a"));
		System.out.println(num);

		System.out.println(ss.not("a", "a"));
	}

	public boolean isScramble(String s1, String s2) {
//		System.out.println(s1 + "," + s2+": "+s1.equals(s2));
		num++;
		if (!not(s1, s2))
			return false;
		
		if (s1.length() == 1) {
			return s1.charAt(0) == s2.charAt(0);
		} else if (s1.equals(s2)) {
			return true;
		} else if (map.containsKey(s1) && map.get(s1).contains(s2) || map.containsKey(s2) && map.get(s2).contains(s1))
			return true;
		else {
			for (int i = 1; i < s1.length(); i++) {
				String s1l = s1.substring(0, i);
				String s1r = s1.substring(i, s1.length());

				String s2l = s2.substring(0, i);
				String s2r = s2.substring(i, s2.length());

				String s2l2 = s2.substring(0, s2.length() - i);
				String s2r2 = s2.substring(s2.length() - i, s2.length());

				if (isScramble(s1l, s2l) && isScramble(s1r, s2r) || isScramble(s1l, s2r2) && isScramble(s1r, s2l2)) {
					// System.out.println("true " + s1 + "," + s2);

					boolean left = map.containsKey(s1);
					boolean right = map.containsKey(s2);

					if (!left && !right) {
						Set<String> tmp = new HashSet<>();
						tmp.add(s1);
						tmp.add(s2);
						map.put(s1, tmp);
						map.put(s2, tmp);
					} else if (left && !right) {
						Set<String> tmp = map.get(s1);
						tmp.add(s2);
						map.put(s2, tmp);
					} else if (!left && right) {
						Set<String> tmp = map.get(s2);
						tmp.add(s1);
						map.put(s1, tmp);
					} else {
						map.get(s1).add(s2);
					}

					return true;
				}
			}
			
			return false;
		}

	}

	public boolean isScramble2(String s1, String s2) {
//		System.out.println(s1 + "," + s2+": "+s1.equals(s2));
		num++;
		if (!not(s1, s2))
			return false;
		
		if (s1.length() == 1) {
			return s1.charAt(0) == s2.charAt(0);
		} else if (s1.equals(s2)) {
			return true;
		} else if (map.containsKey(s1) && map.get(s1).contains(s2) || map.containsKey(s2) && map.get(s2).contains(s1))
			return true;
		else {
			for (int i = 1; i < s1.length(); i++) {
				String s1l = s1.substring(0, i);
				String s1r = s1.substring(i, s1.length());

				String s2l = s2.substring(0, i);
				String s2r = s2.substring(i, s2.length());

				String s2l2 = s2.substring(0, s2.length() - i);
				String s2r2 = s2.substring(s2.length() - i, s2.length());

				if (isScramble(s1l, s2l) && isScramble(s1r, s2r) || isScramble(s1l, s2r2) && isScramble(s1r, s2l2)) {
					// System.out.println("true " + s1 + "," + s2);

					Set<String> left = map.get(s1);
					Set<String> right = map.get(s2);

					if (left==null && right==null) {
						Set<String> tmp = new HashSet<>();
						tmp.add(s1);
						tmp.add(s2);
						map.put(s1, tmp);
						map.put(s2, tmp);
					} else if (left!=null && right==null) {
						left.add(s2);
						left.add(s1);
						map.put(s2, left);
					} else if (left==null && right!=null) {
						right.add(s2);
						right.add(s1);
						map.put(s1, right);
					} else {
						left.add(s2);
						left.add(s1);
					}

					return true;
				}
			}
			
			return false;
		}

	}

	private boolean not(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		int[] rec = new int[128];
		for (int i = 0; i < s1.length(); i++) {
			rec[s1.charAt(i)]++;
			rec[s2.charAt(i)]--;
		}
		
		for (int i = 0; i < rec.length; i++) {
//			System.out.print(rec[i] + ",");
			if (rec[i] != 0) {
				return false;
			}
		}
		return true;
	}
}
