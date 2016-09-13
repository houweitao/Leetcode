package hou.forwz.Leetcode.medium;

import java.util.Stack;

/**
 * @author houweitao
 * @date 2016年9月9日上午1:39:49
 */

public class DecodeString {
//	public static void main(String[] args) {
//		DecodeString ds = new DecodeString();
//		System.out.println(ds.decodeString("3[a2[c]]"));
//	}

//	public String decodeString(String s) {
//		if (s.length() < 2)
//			return s;
//		Stack<String> ch = new Stack<>();
//		Stack<Integer> num = new Stack<>();
//
//		int number = 0;
//		String str = "";
//		for (int i = 0; i < s.length(); i++) {
//			char cur = s.charAt(i);
//
//			if (isNumber(cur)) {
//				number = 10 * number + (cur - '0');
//				if (str.length() > 0)
//					ch.push(str);
//			} else if (isChar(cur)) {
//				str = str + cur;
//			} else if (cur == '[') {
//				num.push(number);
//			}else{
//				
//			}
//
//		}
//
//	}

	private boolean isChar(char cur) {
		if (cur - 'a' >= 0 && cur - 'z' <= 0)
			return true;
		else
			return false;
	}

	private boolean isNumber(char cur) {
		if (cur - '0' >= 0 && cur - '9' <= 0)
			return true;
		else
			return false;
	}

	String deal(String str, int time) {
		String ret = "";
		for (int i = 0; i < time; i++) {
			ret += str;
		}
		return ret;
	}

}
