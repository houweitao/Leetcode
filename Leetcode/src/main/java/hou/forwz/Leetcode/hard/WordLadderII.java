package hou.forwz.Leetcode.hard;

import java.util.*;

/**
 * @author houweitao
 * @date 2016年8月14日上午2:15:46
 */

public class WordLadderII {

	int min = Integer.MAX_VALUE;
	static int jump = 0;
	static int tryNum = 0;

	public static void main(String[] args) {

		WordLadderII wl = new WordLadderII();
		Set<String> wordList = new HashSet<>();
		String[] strs = { "kid", "tag", "pup", "ail", "tun", "woo", "erg", "luz", "brr", "gay", "sip", "kay", "per",
				"val", "mes", "ohs", "now", "boa", "cet", "pal", "bar", "die", "war", "hay", "eco", "pub", "lob", "rue",
				"fry", "lit", "rex", "jan", "cot", "bid", "ali", "pay", "col", "gum", "ger", "row", "won", "dan", "rum",
				"fad", "tut", "sag", "yip", "sui", "ark", "has", "zip", "fez", "own", "ump", "dis", "ads", "max", "jaw",
				"out", "btu", "ana", "gap", "cry", "led", "abe", "box", "ore", "pig", "fie", "toy", "fat", "cal", "lie",
				"noh", "sew", "ono", "tam", "flu", "mgm", "ply", "awe", "pry", "tit", "tie", "yet", "too", "tax", "jim",
				"san", "pan", "map", "ski", "ova", "wed", "non", "wac", "nut", "why", "bye", "lye", "oct", "old", "fin",
				"feb", "chi", "sap", "owl", "log", "tod", "dot", "bow", "fob", "for", "joe", "ivy", "fan", "age", "fax",
				"hip", "jib", "mel", "hus", "sob", "ifs", "tab", "ara", "dab", "jag", "jar", "arm", "lot", "tom", "sax",
				"tex", "yum", "pei", "wen", "wry", "ire", "irk", "far", "mew", "wit", "doe", "gas", "rte", "ian", "pot",
				"ask", "wag", "hag", "amy", "nag", "ron", "soy", "gin", "don", "tug", "fay", "vic", "boo", "nam", "ave",
				"buy", "sop", "but", "orb", "fen", "paw", "his", "sub", "bob", "yea", "oft", "inn", "rod", "yam", "pew",
				"web", "hod", "hun", "gyp", "wei", "wis", "rob", "gad", "pie", "mon", "dog", "bib", "rub", "ere", "dig",
				"era", "cat", "fox", "bee", "mod", "day", "apr", "vie", "nev", "jam", "pam", "new", "aye", "ani", "and",
				"ibm", "yap", "can", "pyx", "tar", "kin", "fog", "hum", "pip", "cup", "dye", "lyx", "jog", "nun", "par",
				"wan", "fey", "bus", "oak", "bad", "ats", "set", "qom", "vat", "eat", "pus", "rev", "axe", "ion", "six",
				"ila", "lao", "mom", "mas", "pro", "few", "opt", "poe", "art", "ash", "oar", "cap", "lop", "may", "shy",
				"rid", "bat", "sum", "rim", "fee", "bmw", "sky", "maj", "hue", "thy", "ava", "rap", "den", "fla", "auk",
				"cox", "ibo", "hey", "saw", "vim", "sec", "ltd", "you", "its", "tat", "dew", "eva", "tog", "ram", "let",
				"see", "zit", "maw", "nix", "ate", "gig", "rep", "owe", "ind", "hog", "eve", "sam", "zoo", "any", "dow",
				"cod", "bed", "vet", "ham", "sis", "hex", "via", "fir", "nod", "mao", "aug", "mum", "hoe", "bah", "hal",
				"keg", "hew", "zed", "tow", "gog", "ass", "dem", "who", "bet", "gos", "son", "ear", "spy", "kit", "boy",
				"due", "sen", "oaf", "mix", "hep", "fur", "ada", "bin", "nil", "mia", "ewe", "hit", "fix", "sad", "rib",
				"eye", "hop", "haw", "wax", "mid", "tad", "ken", "wad", "rye", "pap", "bog", "gut", "ito", "woe", "our",
				"ado", "sin", "mad", "ray", "hon", "roy", "dip", "hen", "iva", "lug", "asp", "hui", "yak", "bay", "poi",
				"yep", "bun", "try", "lad", "elm", "nat", "wyo", "gym", "dug", "toe", "dee", "wig", "sly", "rip", "geo",
				"cog", "pas", "zen", "odd", "nan", "lay", "pod", "fit", "hem", "joy", "bum", "rio", "yon", "dec", "leg",
				"put", "sue", "dim", "pet", "yaw", "nub", "bit", "bur", "sid", "sun", "oil", "red", "doc", "moe", "caw",
				"eel", "dix", "cub", "end", "gem", "off", "yew", "hug", "pop", "tub", "sgt", "lid", "pun", "ton", "sol",
				"din", "yup", "jab", "pea", "bug", "gag", "mil", "jig", "hub", "low", "did", "tin", "get", "gte", "sox",
				"lei", "mig", "fig", "lon", "use", "ban", "flo", "nov", "jut", "bag", "mir", "sty", "lap", "two", "ins",
				"con", "ant", "net", "tux", "ode", "stu", "mug", "cad", "nap", "gun", "fop", "tot", "sow", "sal", "sic",
				"ted", "wot", "del", "imp", "cob", "way", "ann", "tan", "mci", "job", "wet", "ism", "err", "him", "all",
				"pad", "hah", "hie", "aim", "ike", "jed", "ego", "mac", "baa", "min", "com", "ill", "was", "cab", "ago",
				"ina", "big", "ilk", "gal", "tap", "duh", "ola", "ran", "lab", "top", "gob", "hot", "ora", "tia", "kip",
				"han", "met", "hut", "she", "sac", "fed", "goo", "tee", "ell", "not", "act", "gil", "rut", "ala", "ape",
				"rig", "cid", "god", "duo", "lin", "aid", "gel", "awl", "lag", "elf", "liz", "ref", "aha", "fib", "oho",
				"tho", "her", "nor", "ace", "adz", "fun", "ned", "coo", "win", "tao", "coy", "van", "man", "pit", "guy",
				"foe", "hid", "mai", "sup", "jay", "hob", "mow", "jot", "are", "pol", "arc", "lax", "aft", "alb", "len",
				"air", "pug", "pox", "vow", "got", "meg", "zoe", "amp", "ale", "bud", "gee", "pin", "dun", "pat", "ten",
				"mob" };

		for (String str : strs) {
			wordList.add(str);
		}

		String beginWord = "cet", endWord = "ism";

		// wordList.clear();
		// String[] test = { "hot", "cog", "dog", "tot", "hog", "hop", "pot",
		// "dot" };
		// for (String str : test) {
		// wordList.add(str);
		// }
		// beginWord = "hot";
		// endWord = "dog";
		System.out.println(wl.findLadders(beginWord, endWord, wordList));
		System.out.println(jump);
		System.out.println(tryNum);
	}

	public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
		List<List<String>> ret = new ArrayList<>();
		Set<String> endSet = new HashSet<>();
		wordList.remove(endWord);
		wordList.remove(beginWord);
		char[] ch = endWord.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			char bak = ch[i];
			for (char c = 'a'; c <= 'z'; c++) {
				if (c == bak)
					continue;
				ch[i] = c;

				String next = new String(ch);

				if (next.equals(beginWord)) {
					List<String> tmp = new ArrayList<>();
					tmp.add(beginWord);
					tmp.add(endWord);
					ret.add(tmp);
					return ret;
				}
				if (wordList.contains(next)) {
					endSet.add(next);
				}
			}
			ch[i] = bak;
		}

		// System.out.println(wordList);
		System.out.println(endSet);

		List<String> tmp = new LinkedList<>();
		tmp.add(beginWord);
		Set<String> quchong = new HashSet<>();
		quchong.add(beginWord);

		min = wordList.size() + 2;
		int lastChange = -1;
		dfs(beginWord, quchong, tmp, ret, wordList, endSet, endWord, lastChange);
		return ret;
	}

	private void dfs(String word, Set<String> quchong, List<String> pre, List<List<String>> ret, Set<String> wordList,
			Set<String> endSet, String endWord, int lastChange) {
		System.out.println(lastChange + "  " + wordList.size() + " " + word + "," + pre);
		tryNum++;
		if (pre.size() + dis(word, endWord) > min) {
			jump++;
			return;
		}
		if (endSet.contains(word)) {
			// System.out.println("end");
			pre.add(endWord);
			List<String> add = new ArrayList<>(pre);

			pre.remove(pre.size() - 1);// 这里坑爹！！

			if (add.size() < min) {
				ret.clear();
				min = add.size();
				// System.out.println(add.size());
			}
			ret.add(add);
			return;
		}

		char[] ch = word.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if (i == lastChange) {
				// System.out.println("jump");
				continue;
			}
			char bak = ch[i];

			for (char c = 'a'; c <= 'z'; c++) {
				if (c != bak) {
					ch[i] = c;
					String cur = new String(ch);
					if (!quchong.contains(cur) && wordList.contains(cur)) {
						wordList.remove(cur);
						quchong.add(cur);
						pre.add(cur);

						dfs(cur, quchong, pre, ret, wordList, endSet, endWord, i);

						pre.remove(pre.size() - 1);
						quchong.remove(cur);
						wordList.add(cur);
					}
				}
			}

			ch[i] = bak;
		}
	}

	private int dis(String word, String endWord) {
		int dis = 0;
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == endWord.charAt(i))
				dis++;
		}
		return word.length() - dis;
	}

}
