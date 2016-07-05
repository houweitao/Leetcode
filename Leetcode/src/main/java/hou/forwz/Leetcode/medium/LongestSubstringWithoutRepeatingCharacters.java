package hou.forwz.Leetcode.medium;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author houweitao
 * @date 2016年7月5日下午11:10:26
 * @url https://leetcode.com/problems/longest-substring-without-repeating-
 *      characters/
 */

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(1);
		queue.offer(3);
		System.out.println(queue.toString());
	}

	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() < 1)
			return 0;

		Queue<Character> queue = new LinkedList<>();
		Set<Character> set = new HashSet<>();
		int max = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			while (true) {
				if (!set.contains(c)) {
					set.add(c);
					queue.offer(c);
					break;
				} else {
					
					if (queue.size() > max) {
						max = queue.size();
					}
					if (queue.size() > 0) {
						char cur = queue.poll();
						set.remove(cur);
					}
					
				}
			}
		}

		if (set.size() > max)
			max = set.size();

		return max;
	}

}
