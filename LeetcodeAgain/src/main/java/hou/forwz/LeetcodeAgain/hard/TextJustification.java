package hou.forwz.LeetcodeAgain.hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年8月23日上午12:46:33
 */

public class TextJustification {
	public static void main(String[] args) {
		TextJustification tj = new TextJustification();
		String[] words = { "What", "must", "be", "shall", "be." };
		// { "This", "is", "an", "example", "of", "text", "justification." };
		System.out.println(tj.fullJustify(words, 16));
	}

	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> ret = new LinkedList<>();
		help(ret, words, 0, maxWidth);
		return ret;
	}

	private void help(List<String> ret, String[] words, int pos, int maxWidth) {
		int length = 0;
		int endPos = words.length - 1;
		for (int i = pos; i < words.length; i++) {
			length += words[i].length();
			if (length + i - pos == maxWidth) {
				endPos = i;
				break;
			} else if (length + i - pos > maxWidth) {
				endPos = i - 1;
				break;
			}
		}
		ret.add(generate(words, pos, endPos, maxWidth));
		if (endPos != words.length - 1)
			help(ret, words, endPos + 1, maxWidth);
	}

	private String generate(String[] words, int pos, int endPos, int maxWidth) {
		if (endPos == words.length - 1) {
			return getLast(words, pos, endPos, maxWidth);
		}

		StringBuffer sb = new StringBuffer();
		if (pos == endPos) {
			int kong = maxWidth - words[pos].length();
			sb.append(words[pos]);
			sb.append(get(kong));
			return sb.toString();
		} else {

			int len = 0;
			for (int i = pos; i <= endPos; i++) {
				len += words[i].length();
			}

			int avage = (maxWidth - len) / (endPos - pos);
			int more = (maxWidth - len) % (endPos - pos);

			List<String> blank = new ArrayList<>(endPos - pos);
			for (int i = 0; i < endPos - pos; i++) {
				if (i < more)
					blank.add(get(avage + 1));
				else
					blank.add(get(avage));
			}

			sb.append(words[pos]);

			for (int i = pos + 1; i <= endPos; i++) {
				sb.append(blank.get(i - pos - 1));
				sb.append(words[i]);
			}

			return sb.toString();
		}
	}

	private String getLast(String[] words, int pos, int endPos, int maxWidth) {
		StringBuffer sb = new StringBuffer();
		sb.append(words[pos]);
		for (int i = pos + 1; i <= endPos; i++) {
			sb.append(" ").append(words[i]);
		}

		int need = maxWidth - sb.length();
		sb.append(get(need));

		return sb.toString();
	}

	private String get(int num) {
		String ret = "";
		for (int i = 0; i < num; i++) {
			ret = ret + " ";
		}
		return ret;
	}
}
