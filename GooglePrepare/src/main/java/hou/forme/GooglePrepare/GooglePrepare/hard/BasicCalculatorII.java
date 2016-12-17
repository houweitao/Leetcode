// package hou.forme.GooglePrepare.GooglePrepare.hard;
//
// import java.util.Stack;
//
/// ***
//
// @author houweitao
// * @date 2016年12月16日下午9:15:19
// */
//
// public class BasicCalculatorII {
// public static void main(String[] args) {
// BasicCalculatorII bc = new BasicCalculatorII();
// String s = "(1+2)*3";
// System.out.println(bc.calculate(s));
// }
//
// public int calculate(String s) {
// s = s + "+0";
// Stack<Integer> stack = new Stack<>();
// char sign = '+';
// int num = 0;
//
// for (int i = 0; i < s.length(); i++) {
// char c = s.charAt(i);
//
// System.out.println(c + "," + stack);
// if (Character.isDigit(c)) {
// num = 10 * num + (c - '0');
// } else if (c != ' ') {
// if (c == '+' || c == '-' || c == '*'
// // || c == '/'
// ) {
// if (sign == '+') {
// stack.push(num);
// } else if (sign == '-') {
// stack.push(-num);
// } else {
// stack.push(stack.pop() * num);
// }
//
// num = 0;
// sign = c;
// } else if (c == '(') {
// if (sign == '+') {
// stack.push(num);
// } else if (sign == '-') {
// stack.push(-num);
// } else {
// stack.push(stack.pop() * num);
// }
//
// sign = '+';
// num = 0;
// } else if (c == ')') {
// if (sign == '+') {
// stack.push(num);
// } else if (sign == '-') {
// stack.push(-num);
// } else {
// stack.push(stack.pop() * num);
// }
//
// sign = '+';
// num = 0;
// }
// }
//
// }
//
// int sum = 0;
// while (!stack.isEmpty()) {
// sum += stack.pop();
// }
// return sum;
// }
// }
