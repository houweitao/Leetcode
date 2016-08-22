package hou.forwz.LeetcodeAgain.hard;

import java.util.*;

/**
 * @author houweitao
 * @date 2016年8月22日下午10:15:05
 */

public class WordLadderII {
	// Set<String> visited = new HashSet<>();
	int min = Integer.MAX_VALUE;
	char[] alp = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
			'u', 'v', 'w', 'x', 'y', 'z' };

	public static void main(String[] args) {
		WordLadderII wl = new WordLadderII();
		Set<String> wordList = new HashSet<>();
		String[] strs = { "ted", "tex", "red", "tax", "tad", "den", "rex", "pee" };

		for (String str : strs) {
			wordList.add(str);
		}

		String beginWord = "red", endWord = "tax";

		System.out.println(wl.findLadders(beginWord, endWord, wordList));
	}

	public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {

		wordList.remove(beginWord);
		wordList.add(endWord);

		List<List<String>> ret = new ArrayList<>();
		List<String> tmp = new ArrayList<>();
		tmp.add(beginWord);
		dfs(beginWord, endWord, wordList, tmp, ret);
		return ret;
	}

	private void dfs(String beginWord, String endWord, Set<String> wordList, List<String> tmp, List<List<String>> ret) {
//		System.out.println(tmp + "," + beginWord);

		if (beginWord.equals(endWord)) {
			if (tmp.size() == min) {
				ret.add(new ArrayList<>(tmp));
			} else if (tmp.size() < min) {
				min = tmp.size();
				ret.clear();
				ret.add(new ArrayList<>(tmp));
			}
			return;
		}

		if (wordList.size() == 0)
			return;

		char[] ch=beginWord.toCharArray();
		
		for (int i = 0; i < beginWord.length(); i++) {
			char c = ch[i];
			for (int j = 0; j < 26; j++) {
				if (c != alp[j]) {
					ch[i]=alp[j];
					String cur=new String(ch);
					if (wordList.contains(cur)) {
						wordList.remove(cur);
						tmp.add(cur);
						dfs(cur, endWord, wordList, tmp, ret);
						tmp.remove(tmp.size() - 1);
						wordList.add(cur);
					}
					ch[i]=c;
				}
			}
		}

	}

	class Word {
		String str;
		Word before;

		Word(String str) {
			this.str = str;
		}
	}

}
