package hou.forwz.Leetcode.hard;

import java.util.*;

/**
 * @author houweitao
 * @date 2016年8月9日下午10:07:00
 */

public class PalindromePairs {
	public static void main(String[] args) {
		PalindromePairs pp = new PalindromePairs();
		String[] words = { "a", "" };
		System.out.println(pp.palindromePairsMe(words));
	}

	public List<List<Integer>> palindromePairsMe(String[] words) {
		List<List<Integer>> ret = new ArrayList<>();
		if (words.length < 2)
			return ret;

		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < words.length; i++) {
			map.put(words[i], i);
		}

		if (map.containsKey("")) {
			for (int i = 0; i < words.length; i++) {
				if (words[i].equals(""))
					continue;
				if (isPalindrome(words[i])) {
					List<Integer> tmp = new ArrayList<>();
					tmp.add(map.get(""));
					tmp.add(i);
					ret.add(tmp);
					List<Integer> tmp2 = new ArrayList<>();
					tmp2.add(i);
					tmp2.add(map.get(""));
					ret.add(tmp2);
				}
			}
		}

		map.remove("");

		for (int i = 0; i < words.length; i++) {
			String cur = words[i];

			for (int j = 0; j <= cur.length(); j++) {

				String left = cur.substring(0, j);
				String right = cur.substring(j);

				if (isPalindrome(left)) {
					String need = new StringBuffer(right).reverse().toString();
					if (map.containsKey(need)) {
						List<Integer> tmp = new ArrayList<>();
						int pos = map.get(need);
						if (pos == i)
							continue;
						tmp.add(pos);
						tmp.add(i);
						ret.add(tmp);
					}
				}

				if (isPalindrome(right)) {
					String need = new StringBuffer(left).reverse().toString();
					if (map.containsKey(need)) {
						List<Integer> tmp = new ArrayList<>();
						int pos = map.get(need);
						if (pos == i)
							continue;
						tmp.add(i);
						tmp.add(pos);
						ret.add(tmp);
					}

				}

			}
		}
		return ret;
	}

	public List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> pairs = new LinkedList<>();
		if (words == null)
			return pairs;
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < words.length; ++i)
			map.put(words[i], i);
		for (int i = 0; i < words.length; ++i) {
			int l = 0, r = 0;
			while (l <= r) {
				String s = words[i].substring(l, r);
				Integer j = map.get(new StringBuilder(s).reverse().toString());
				if (j != null && i != j
						&& isPalindrome(words[i].substring(l == 0 ? r : 0, l == 0 ? words[i].length() : l)))
					pairs.add(Arrays.asList(l == 0 ? new Integer[] { i, j } : new Integer[] { j, i }));
				if (r < words[i].length())
					++r;
				else
					++l;
			}
		}
		return pairs;
	}

	public List<List<Integer>> palindromePairs2(String[] words) {
		List<List<Integer>> ret = new ArrayList<>();
		if (words == null || words.length < 2)
			return ret;
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < words.length; i++)
			map.put(words[i], i);
		for (int i = 0; i < words.length; i++) {
			// System.out.println(words[i]);
			for (int j = 0; j <= words[i].length(); j++) { // notice it should
															// be "j <=
															// words[i].length()"
				String str1 = words[i].substring(0, j);
				String str2 = words[i].substring(j);
				if (isPalindrome(str1)) {
					String str2rvs = new StringBuilder(str2).reverse().toString();
					if (map.containsKey(str2rvs) && map.get(str2rvs) != i) {
						List<Integer> list = new ArrayList<Integer>();
						list.add(map.get(str2rvs));
						list.add(i);
						ret.add(list);
						// System.out.printf("isPal(str1): %s\n",
						// list.toString());
					}
				}
				if (isPalindrome(str2)) {
					String str1rvs = new StringBuilder(str1).reverse().toString();
					// check "str.length() != 0" to avoid duplicates
					if (map.containsKey(str1rvs) && map.get(str1rvs) != i && str2.length() != 0) {
						List<Integer> list = new ArrayList<Integer>();
						list.add(i);
						list.add(map.get(str1rvs));
						ret.add(list);
						// System.out.printf("isPal(str2): %s\n",
						// list.toString());
					}
				}
			}
		}
		return ret;
	}

	private boolean isPalindrome(String s) {
		for (int i = 0; i < s.length() / 2; ++i)
			if (s.charAt(i) != s.charAt(s.length() - 1 - i))
				return false;
		return true;
	}
}
