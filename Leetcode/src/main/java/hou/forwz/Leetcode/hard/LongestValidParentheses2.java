// package hou.forwz.Leetcode.hard;
//
// import java.util.Stack;
//
/// **
// * @author houweitao
// * @date 2016年8月9日上午1:03:52
// * @ganwu 还真就是反过来看好使..2016年08月09日01:54:20
// */
//
// public class LongestValidParentheses2 {
// public static void main(String[] args) {
// LongestValidParentheses2 lv = new LongestValidParentheses2();
// System.out.println(lv.longestValidParentheses("()()"));
// }
//
// public int longestValidParentheses(String s) {
// Stack<Integer> stack = new Stack<>();
// int max = 0;
// for (int i = 0; i < s.length(); i++) {
// char c = s.charAt(i);
// // System.out.println(c);
// if (c == '(') {
// stack.push(i);
// } else {
// if (stack.isEmpty())
// continue;
//
// // System.out.println(stack.peek());
// if (s.charAt(stack.peek()) == '(') {
// int first = stack.peek();
// // System.out.println(first);
//
// max = Math.max(max, i - first + 1);
// }else{
//
// }
// }
// // System.out.println(stack);
// }
// return max;
// }
//
// }
