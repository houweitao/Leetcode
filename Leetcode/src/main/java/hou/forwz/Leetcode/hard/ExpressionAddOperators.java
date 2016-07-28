// package hou.forwz.Leetcode.hard;
//
// import java.util.LinkedList;
// import java.util.List;
//
/// **
// * @author houweitao
// * @date 2016年7月28日下午9:52:57
// */
//
// public class ExpressionAddOperators {
// public static void main(String[] args) {
// ExpressionAddOperators ea = new ExpressionAddOperators();
// System.out.println(ea.addOperators("123", 6));
// }
//
// public List<String> addOperators2(String num, int target) {
// return divided(num, 0, num.length() - 1, target);
// }
//
// private List<String> divided(String num, int begin,int end, int target) {
// if(begin==end){
//
// }
//
//
// return null;
// }
//
// // notGood & notWork
// public List<String> addOperators(String num, int target) {
// return help(num, target, 0);
// }
//
// private List<String> help(String num, int target, int pos) {
//
// System.out.println(pos + "," + target);
// try {
// Thread.sleep(500);
// } catch (InterruptedException e) {
// // TODO Auto-generated catch block
// e.printStackTrace();
// }
// List<String> ret = new LinkedList<>();
//
// if (pos > num.length())
// return ret;
//
// if (num.equals(target + "") && pos == 0) {
// ret.add(num);
// // return ret;
// }
// if (pos == num.length() - 1) {
// int cur = Integer.valueOf(num.charAt(pos) + "");
// // System.out.println(cur+"=?"+target);
// if (cur == target)
// ret.add(cur + "");
// } else {
// int cur = Integer.valueOf(num.charAt(pos) + "");
//
// // +
// List<String> add = help(num, target - cur, pos + 1);
// for (int i = 0; i < add.size(); i++) {
// ret.add(cur + "+" + add.get(i));
// }
//
// // -
// List<String> reduce = help(num, cur - target, pos + 1);
// for (int i = 0; i < reduce.size(); i++) {
// ret.add(cur + "-" + reduce.get(i));
// }
//
// // *
// if (cur == 0) {
// List<String> multy = help(num, 0, pos + 1);
// for (int i = 0; i < multy.size(); i++) {
// ret.add(cur + "*" + multy.get(i));
// }
// } else if (target % cur == 0) {
// List<String> multy = addOperators(num, target / cur);
// for (int i = 0; i < multy.size(); i++) {
// ret.add(cur + "*" + multy.get(i));
// }
// }
//
// }
// return ret;
// }
//
// }
