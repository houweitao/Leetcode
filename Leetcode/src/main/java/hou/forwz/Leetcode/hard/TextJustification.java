package hou.forwz.Leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年7月12日下午11:21:54
 */


public class TextJustification {
	public static void main(String[] args) {
		TextJustification tj = new TextJustification();
		String[] words = { "What", "must", "be", "shall", "be." };
		// { "This", "is", "an", "example", "of", "text", "justification." };
		System.out.println(tj.fullJustify(words, 16));
	}

	public List<String> fullJustify(String[] words, int maxWidth) {
		return help(words, 0, maxWidth);
	}

	private List<String> help(String[] words, int pos, int maxWidth) {
		List<String> ret = new ArrayList<>();

		if (words.length == pos)
			return ret;
		else {
			int all = 0;
			for (int i = pos; i < words.length; i++) {
				all = all + words[i].length();
				if (all + i - pos == maxWidth) {
					ret.add(deal(words, pos, i, maxWidth));
					ret.addAll(help(words, i + 1, maxWidth));
					return ret;
				} else if (all - pos + i > maxWidth) {
					ret.add(deal(words, pos, i - 1, maxWidth));
					ret.addAll(help(words, i, maxWidth));
					return ret;
				}
			}

			// ret.add(deal(words, pos, words.length-1, maxWidth));

			String str = "";
			for (int i = pos; i < words.length; i++) {
				str = str + " " + words[i];
			}
			ret.add(str.substring(1) + generate(maxWidth - str.length() + 1));

			return ret;
		}
	}

	private String deal(String[] words, int begin, int end, int maxWidth) {
		if (begin == end)
			return words[begin] + generate(maxWidth - words[begin].length());

		int need = (end - begin);
		int lenSum = 0;
		for (int i = begin; i <= end; i++) {
			lenSum = lenSum + words[i].length();
		}

		int base = (maxWidth - lenSum) / need;
		int add = (maxWidth - lenSum) % need;

		List<String> blank = new ArrayList<>();
		for (int i = 0; i < need; i++) {
			if (i < add)
				blank.add(generate(base + 1));
			else
				blank.add(generate(base));
		}

		String ret = words[begin];
		for (int i = 0; i < blank.size(); i++) {
			ret = ret + blank.get(i) + words[begin + 1 + i];
		}
		return ret;
	}

	private String generate(int num) {
		String ret = "";
		for (int i = 0; i < num; i++) {
			ret = ret + " ";
		}
		return ret;
	}

}
