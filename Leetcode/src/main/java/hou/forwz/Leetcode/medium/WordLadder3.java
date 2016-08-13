package hou.forwz.Leetcode.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author houweitao
 * @date 2016年8月14日上午1:35:35
 */

public class WordLadder3 {
	String alp = "abcdefghijklmnopqrstuvwxyz";

	public static void main(String[] args) {
		WordLadder3 wl = new WordLadder3();
		Set<String> wordList = new HashSet<>();
		String[] strs = { "dose", "ends", "dine", "jars", "prow", "soap", "guns", "hops", "cray", "hove", "ella",
				"hour", "lens", "jive", "wiry", "earl", "mara", "part", "flue", "putt", "rory", "bull", "york", "ruts",
				"lily", "vamp", "bask", "peer", "boat", "dens", "lyre", "jets", "wide", "rile", "boos", "down", "path",
				"onyx", "mows", "toke", "soto", "dork", "nape", "mans", "loin", "jots", "male", "sits", "minn", "sale",
				"pets", "hugo", "woke", "suds", "rugs", "vole", "warp", "mite", "pews", "lips", "pals", "nigh", "sulk",
				"vice", "clod", "iowa", "gibe", "shad", "carl", "huns", "coot", "sera", "mils", "rose", "orly", "ford",
				"void", "time", "eloy", "risk", "veep", "reps", "dolt", "hens", "tray", "melt", "rung", "rich", "saga",
				"lust", "yews", "rode", "many", "cods", "rape", "last", "tile", "nosy", "take", "nope", "toni", "bank",
				"jock", "jody", "diss", "nips", "bake", "lima", "wore", "kins", "cult", "hart", "wuss", "tale", "sing",
				"lake", "bogy", "wigs", "kari", "magi", "bass", "pent", "tost", "fops", "bags", "duns", "will", "tart",
				"drug", "gale", "mold", "disk", "spay", "hows", "naps", "puss", "gina", "kara", "zorn", "boll", "cams",
				"boas", "rave", "sets", "lego", "hays", "judy", "chap", "live", "bahs", "ohio", "nibs", "cuts", "pups",
				"data", "kate", "rump", "hews", "mary", "stow", "fang", "bolt", "rues", "mesh", "mice", "rise", "rant",
				"dune", "jell", "laws", "jove", "bode", "sung", "nils", "vila", "mode", "hued", "cell", "fies", "swat",
				"wags", "nate", "wist", "honk", "goth", "told", "oise", "wail", "tels", "sore", "hunk", "mate", "luke",
				"tore", "bond", "bast", "vows", "ripe", "fond", "benz", "firs", "zeds", "wary", "baas", "wins", "pair",
				"tags", "cost", "woes", "buns", "lend", "bops", "code", "eddy", "siva", "oops", "toed", "bale", "hutu",
				"jolt", "rife", "darn", "tape", "bold", "cope", "cake", "wisp", "vats", "wave", "hems", "bill", "cord",
				"pert", "type", "kroc", "ucla", "albs", "yoko", "silt", "pock", "drub", "puny", "fads", "mull", "pray",
				"mole", "talc", "east", "slay", "jamb", "mill", "dung", "jack", "lynx", "nome", "leos", "lade", "sana",
				"tike", "cali", "toge", "pled", "mile", "mass", "leon", "sloe", "lube", "kans", "cory", "burs", "race",
				"toss", "mild", "tops", "maze", "city", "sadr", "bays", "poet", "volt", "laze", "gold", "zuni", "shea",
				"gags", "fist", "ping", "pope", "cora", "yaks", "cosy", "foci", "plan", "colo", "hume", "yowl", "craw",
				"pied", "toga", "lobs", "love", "lode", "duds", "bled", "juts", "gabs", "fink", "rock", "pant", "wipe",
				"pele", "suez", "nina", "ring", "okra", "warm", "lyle", "gape", "bead", "lead", "jane", "oink", "ware",
				"zibo", "inns", "mope", "hang", "made", "fobs", "gamy", "fort", "peak", "gill", "dino", "dina",
				"tier" };

		for (String str : strs) {
			wordList.add(str);
		}
		String beginWord = "nape", endWord = "mild";
		System.out.println(wl.ladderLength(beginWord, endWord, wordList));

	}

	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
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

				if (next.equals(beginWord))
					return 2;
				if (wordList.remove(next)) {
					endSet.add(next);
				}
			}
			ch[i] = bak;
		}

		Queue<String> queue = new LinkedList<>();
		queue.add(beginWord);
		int path = 1;

		while (!queue.isEmpty()) {
			Queue<String> tmp = new LinkedList<>();
			path++;
			System.out.println(queue);

			while (!queue.isEmpty()) {
				String cur = queue.poll();
				ch = cur.toCharArray();
				for (int i = 0; i < ch.length; i++) {
					char bak = ch[i];
					for (char c = 'a'; c <= 'z'; c++) {
						if (c == bak)
							continue;
						ch[i] = c;

						String next = new String(ch);
						if (endSet.contains(next))
							return path + 1;
						if (wordList.contains(next)) {
							tmp.offer(next);
							wordList.remove(next);
						}
					}
					ch[i] = bak;
				}
			}

			queue = tmp;
		}
		return 0;

	}
}
