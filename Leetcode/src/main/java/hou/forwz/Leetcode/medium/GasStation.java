// package hou.forwz.Leetcode.medium;
//
/// **
// * @author houweitao
// * @date 2016年7月17日上午1:08:52
// */
//
// public class GasStation {
// public static void main(String[] args) {
// GasStation gs = new GasStation();
//
// int[] gas = { 1, 2 };
// int[] cost = { 2, 1 };
// System.out.println(gs.canCompleteCircuit(gas, cost));
// }
//
// //bad
// public int canCompleteCircuit(int[] gas, int[] cost) {
// if (gas.length < 2) {
// if (gas[0] >= cost[0])
// return 0;
// else
// return -1;
// }
//
// for (int i = 0; i < gas.length; i++) {
// int pos = canReach(gas, cost, i, (i + 1) % gas.length, gas[i] - cost[i]);
// System.out.println(i + "," + pos);
// if (pos == i)
// return i;
// else {
// int next = (pos - 1) % gas.length;
// if (next >= i)
// i = next;
// }
// }
// return -1;
// }
//
// private int canReach(int[] gas, int[] cost, int begin, int cur, int have) {
// if (have < 0)
// return cur;
// else if (cur == begin)
// return begin;
// else {
// if (gas[cur] + have >= cost[cur]) {
// return canReach(gas, cost, begin, (cur + 1) % gas.length, gas[cur] + have -
// cost[cur]);
// } else
// return cur;
// }
// }
//
// }
