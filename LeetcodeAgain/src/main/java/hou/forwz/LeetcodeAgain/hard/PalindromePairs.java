package hou.forwz.LeetcodeAgain.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author houweitao
 * @date 2016年8月27日下午5:22:31
 */

public class PalindromePairs {

	public List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> ret = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < words.length; i++) {
			map.put(words[i], i);
		}

		if (map.containsKey("")) {
			int pos = map.get("");
			for (int i = 0; i < words.length; i++) {
				if (words[i].equals(""))
					continue;
				if (isPalindrome(words[i])) {
					List<Integer> tmp2 = new ArrayList<>();
					tmp2.add(i);
					tmp2.add(pos);
					ret.add(tmp2);

					List<Integer> tmp = new ArrayList<>();
					tmp.add(pos);
					tmp.add(i);
					ret.add(tmp);
				}
			}
			map.remove("");
		}

		for (int i = 0; i < words.length; i++) {
			String cur = words[i];
			if (cur.equals(""))
				continue;

			for (int j = 0; j < cur.length(); j++) {
				String left = cur.substring(0, j).trim();
				String right = cur.substring(j);

				String leftNeed = new StringBuffer(right).reverse().toString();
				String rightNeed = new StringBuffer(left).reverse().toString();

				if (isPalindrome(left)) {
					if (map.containsKey(leftNeed)) {
						int pos = map.get(leftNeed);
						if (pos == i)
							continue;
						List<Integer> tmp = new ArrayList<>();
						tmp.add(pos);
						tmp.add(i);
						ret.add(tmp);
					}
				}
				if (isPalindrome(right)) {
					if (map.containsKey(rightNeed)) {
						int pos = map.get(rightNeed);
						if (pos == i)
							continue;
						List<Integer> tmp = new ArrayList<>();
						tmp.add(i);
						tmp.add(pos);
						ret.add(tmp);
					}
				}

			}
		}

		return ret;

	}

	private boolean isPalindrome(String str) {
		int left = 0, right = str.length() - 1;
		while (left < right) {
			if (str.charAt(right) != str.charAt(left))
				return false;
			left++;
			right--;
		}

		return true;
	}

}
