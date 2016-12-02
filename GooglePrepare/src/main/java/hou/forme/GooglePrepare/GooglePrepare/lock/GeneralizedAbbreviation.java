package hou.forme.GooglePrepare.GooglePrepare.lock;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年12月2日上午11:44:41
 * @url http://buttercola.blogspot.hk/2016/01/leetcode-generalized-abbreviation.html
 */

public class GeneralizedAbbreviation {
	public static void main(String[] args) {
		GeneralizedAbbreviation ga = new GeneralizedAbbreviation();
		String word = "word";
		System.out.println(ga.generateAbbreviations(word));
	}

	public List<String> generateAbbreviations(String word) {
		List<String> result = new ArrayList<>();

		result.add(word);

		for (int i = 1; i <= word.length(); i++) {
			generate(i, word, result);
		}

		// generateHelper(0, word, result);

		return result;
	}

	// me
	private void generate(int num, String word, List<String> result) {
		for (int i = 0; i <= word.length() - num; i++) {
			String cur = word.substring(0, i) + num + word.substring(i + num);
			result.add(cur);
		}
	}

	// other
	private void generateHelper(int start, String s, List<String> result) {
		if (start >= s.length()) {
			return;
		}

		for (int i = start; i < s.length(); i++) {
			for (int j = 1; i + j <= s.length(); j++) {
				String num = Integer.toString(j);
				String abbr = s.substring(0, i) + num + s.substring(i + j);
				result.add(abbr);
				generateHelper(i + 1 + num.length(), abbr, result); // skip 1b
			}
		}
	}
}
