package hou.forme.GooglePrepare.GooglePrepare.lock;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年12月16日下午3:36:51
 */

public class GenerateAbbreviations {
	public static void main(String[] args) {
		GenerateAbbreviations ga = new GenerateAbbreviations();
		String word = "abc";
		System.out.println(ga.generateAbbreviationsMe(word));
	}

	public List<String> generateAbbreviationsMe(String word) {
		List<String> ret = new ArrayList<String>();
		help(word, ret, 0, "", 0);
		return ret;
	}

	private void help(String word, List<String> ret, int pos, String cur, int count) {
		if (word.length() == pos) {
			if (count != 0)
				ret.add(cur + count);
			else
				ret.add(cur);
		} else {
			help(word, ret, pos + 1, cur, count + 1);// go on

			String add = count == 0 ? "" : count + "";
			help(word, ret, pos + 1, cur + add + word.charAt(pos), 0);
		}
	}

	public List<String> generateAbbreviations(String word) {
		List<String> ret = new ArrayList<String>();
		backtrack(ret, word, 0, "", 0);

		return ret;
	}

	private void backtrack(List<String> ret, String word, int pos, String cur, int count) {
		if (pos == word.length()) {
			if (count > 0)
				cur += count;
			ret.add(cur);
		} else {
			backtrack(ret, word, pos + 1, cur, count + 1);
			backtrack(ret, word, pos + 1, cur + (count > 0 ? count : "") + word.charAt(pos), 0);
		}
	}
}
