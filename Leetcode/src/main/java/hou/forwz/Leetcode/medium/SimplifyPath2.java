package hou.forwz.Leetcode.medium;

import java.util.Stack;

/**
 * @author houweitao
 * @date 2016年8月6日上午12:12:00
 */

public class SimplifyPath2 {
	public static void main(String[] args) {
		SimplifyPath2 sp = new SimplifyPath2();
		String path = "/../a/./b//c/../..";
		System.out.println(sp.simplifyPath(path));
	}

	public String simplifyPath(String path) {
		String[] paths = path.split("/");
//		for (String str : paths)
//			System.out.println(str);

		String ret = "";
		Stack<String> stack = new Stack<>();
		for (String str : paths) {
			if (str.equals("."))
				continue;
			else if (str.equals("..")) {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			} else if (str.length() == 0) {
				continue;
			} else {
				stack.push(str);
			}
		}

		if(stack.isEmpty())
			return "/";
		while(!stack.isEmpty()){
			ret="/"+stack.pop()+ret;
		}
		return ret;
	}

}
