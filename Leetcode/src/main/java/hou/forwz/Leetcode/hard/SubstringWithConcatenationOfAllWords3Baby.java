// package hou.forwz.Leetcode.hard;
//
// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;
//
/// **
// * @author houweitao
// * @date 2016年8月11日上午1:14:53
// */
//
// public class SubstringWithConcatenationOfAllWords3Baby {
// public List<Integer> findSubstring(String s, String[] words) {
// List<Integer> ret = new ArrayList<>();
//
// int len = words[0].length();
// int concat = 0;
// Map<String, Integer> map = new HashMap<>();
//
// for (int i = 0; i < words.length; i++) {
// if (!map.containsKey(words[i]))
// map.put(words[i], 0);
// map.put(words[i], map.get(words[i]) + 1);
// concat += len;
// }
//
// if (s.length() < concat)
// return ret;
//
// int start, end;
//
// for (int i = 0; i < len; i++) {
// start = end = i;
//
// while (start + concat <= s.length()) {
// if (end - start == concat) {
// ret.add(start);
//
// String str = s.substring(start, len);
// map.put(str, map.get(str) + 1);
// start = start + len;
// }
//
// if(map.containsKey(s.substring(end, len))){
//
// }
// }
// }
//
// }
// }
