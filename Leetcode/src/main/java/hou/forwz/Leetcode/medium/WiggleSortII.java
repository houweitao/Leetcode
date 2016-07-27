// package hou.forwz.Leetcode.medium;
//
/// **
// * @author houweitao
// * @date 2016年7月28日上午12:20:24
// */
//
// public class WiggleSortII {
// public static void main(String[] args) {
// WiggleSortII ws = new WiggleSortII();
// int[] nums = { 3, 2, 1, 5, 6 };
// ws.wiggleSort(nums);
// }
//
// public void wiggleSort(int[] nums) {
// print(nums);
// int mid = findKth(nums, 0, nums.length - 1, nums.length / 2);
// print(nums);
// System.out.println(mid);
//
// int[] ret = new int[nums.length];
// boolean fir = true;
// int left = 0, right = ret.length - 1;
// for (int i = 0; i < ret.length; i++) {
// if (fir)
// ret[i] = nums[left++];
// else
// ret[i] = nums[right--];
//
// fir = !fir;
//
// }
// print(ret);
//
// // 3-way-partition-to-wiggly in O(n) time with O(1) space.
// int i = 0, j = 0, k = nums.length - 1;
// while (j <= k) {
// if (nums[j] > mid)
// swap(nums, i++, j++);
// else if (nums[j] < mid)
// swap(nums, j, k--);
// else
// j++;
// }
// }
//
// private void print(int[] nums) {
// for (int i : nums)
// System.out.print(i + ",");
// System.out.println();
// }
//
// private int findKth(int[] nums, int left, int right, int k) {
//
// System.out.println(left + "," + right + ": " + k);
//
// if (left == right) {
// if (k == 1)
// return left;
// else
// return -1;
// }
//
// int stand = nums[left];
// int begin = left, end = right;
//
// while (begin < end) {
// while (nums[end] >= stand && begin < end) {
// end--;
// }
// nums[begin] = nums[end];
// while (nums[begin] < stand && begin < end) {
// begin++;
// }
// nums[end] = nums[begin];
//
// }
// nums[begin] = stand;
//
// if (begin - left == k - 1)
// return begin;
// else if (begin - left > k - 1) {
// return findKth(nums, left, begin, k);
// } else
// return findKth(nums, begin + 1, right, k - begin - 1);
// }
//
// }
