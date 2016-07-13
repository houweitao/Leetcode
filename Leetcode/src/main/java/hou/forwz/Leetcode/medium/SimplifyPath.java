//package hou.forwz.Leetcode.medium;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Set;
//import java.util.Stack;
//
///**
// * @author houweitao
// * @date 2016年7月13日下午9:41:39
// */
//
//public class SimplifyPath {
//	public static void main(String[] args) {
//		SimplifyPath sp = new SimplifyPath();
//		System.out.println(sp.simplifyPath("/a/.//home/"));
//	}
//
//	public String simplifyPath(String path) {
//		Stack<String> stack = new Stack<>();
//		String[] p = path.split("/");
//		for (int i = 0; i < p.length; i++) {
//			if (!stack.empty() && p[i].equals(".."))
//				stack.pop();
//			else if (!p[i].equals(".") && !p[i].equals("") && !p[i].equals(".."))
//				stack.push(p[i]);
//		}
//		List<String> list = new ArrayList(stack);
//		return "/" + String.join("/", list);
//	}
//
//	private String deal(String str) {
//		String ret = "";
//
//		boolean begin = false;
//		for (int i = 0; i < str.length() - 1; i++) {
//			if (str.charAt(i) == '/') {
//				begin = true;
//			}
//
//			if (begin) {
//				if (str.charAt(i) != str.charAt(i + 1))
//					ret = ret + str.charAt(i);
//			}
//		}
//
//		if (str.charAt(str.length() - 1) != '/')
//			ret = ret + str.charAt(str.length() - 1);
//
//		return ret;
//	}
//
//}
