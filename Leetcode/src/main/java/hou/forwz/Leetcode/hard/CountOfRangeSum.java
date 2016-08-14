package hou.forwz.Leetcode.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年8月14日下午1:43:28
 * @timeout
 */

public class CountOfRangeSum {
	int num = 0;

	public static void main(String[] args) {
		CountOfRangeSum cr = new CountOfRangeSum();
		int[] nums = { 0, -3, -3, 1, 1, 2 };
		System.out.println(cr.countRangeSum(nums, 3, 5));
	}

	public int countRangeSum(int[] nums, int lower, int upper) {
		Node root = buildNodeTree(nums, 0, nums.length - 1);
		bSearch(root, lower, upper);

		return num;
	}

	private void bSearch(Node root, long lower, long upper) {
		if (root == null)
			return;

		// System.out.println(root.index + "," + root.val + ": " + root.begin +
		// "," + root.end);

		bSearch(root.left, lower, upper);
		bSearch(root.right, lower, upper);

		// if (root.left == null && root.right == null) {
		// if (root.val >= lower && root.val <= upper) {
		// num++;
		// }
		// } else {
		List<Long> left = new ArrayList<>();
		List<Long> right = new ArrayList<>();
		for (int i = root.begin; i <= root.index; i++) {
			long cur = getSum(root.left, i, root.index);
			left.add(cur);
		}

		for (int i = root.index; i <= root.end; i++) {
			long cur = getSum(root.right, root.index + 1, i);
			right.add(cur);
		}

		Collections.sort(left);
		Collections.sort(right);

//		if (root.val >= lower && root.val <= upper) {
//			num++;
//		}

		if (right.size() == 0) {
			int rightPos = getPos(left, upper);
			int leftPos = getPos(left, lower);

			int curNum = rightPos - leftPos + 1;
			num = num + curNum;

		} else {
			for (int i = 0; i < left.size(); i++) {
				int rightPos = getPos(left, upper - left.get(i));
				int leftPos = getPos(left, lower - left.get(i));

				if (rightPos == -1 || leftPos == right.size() - 1)
					break;
				else {
					int add = rightPos - leftPos + 1;
					num = num + add;
				}
			}

			// }

		}

		// else
		// if (root.left == null && root.right != null) {
		// for (int i = root.right.begin - 1; i <= root.right.end; i++) {
		// long cur = getSum(root.right, root.begin, i);
		// if (cur >= lower - root.val && cur <= upper - root.val) {
		// num++;
		// }
		// }
		// } else if (root.left != null && root.right == null) {
		// List<Long> list = new ArrayList<>();
		// for (int i = root.left.begin; i <= root.left.end + 1; i++) {
		// long cur = getSum(root.left, i, root.index);
		// list.add(cur);
		// }
		//
		// Collections.sort(list);
		//
		// if (lower > list.get(list.size() - 1) || upper < list.get(0))
		// return;
		//
		// int to = getPos(list, upper + 0.5);
		// int from = getPos(list, lower - 0.5);
		//
		// int size = to - from + 1;
		// num = num + size;
		//
		// } else {
		// for (int j = root.left.begin; j <= root.index; j++) {
		// long left = getSum(root.left, j, root.end) + root.val;
		// for (int i = root.right.begin - 1; i <= root.right.end; i++) {
		// long cur = getSum(root.right, root.begin, i);
		// if (cur >= lower - left && cur <= upper - left) {
		// num++;
		// }
		// }
		// }
		// }
	}

	private int getPos(List<Long> list, double d) {
		int left = 0, right = list.size() - 1;
		if (d > list.get(right))
			return list.size() - 1;
		else if (d < list.get(0))
			return -1;

		while (left < right) {
			if (left + 1 == right) {
				if (left > d)
					return left - 1;
				else if (d < right)
					return left;
				else
					return right;
			}

			int mid = left + (right - left) / 2;
			if (list.get(mid) > d) {
				right = mid;
			} else if (list.get(mid) <= d) {
				left = mid;
			}

		}

		return 0;
	}

	private long getSum(Node root, int begin, int end) {
		if (root == null)
			return 0;
		else if (begin == end && begin == root.index)
			return root.val;
		else if (root.index > end) {
			return getSum(root.left, begin, end);
		} else if (root.index < begin) {
			return getSum(root.right, begin, end);
		} else {
			return getSum(root.left, begin, root.index - 1) + root.val + getSum(root.right, root.index + 1, end);
		}
	}

	private Node buildNodeTree(int[] nums, int from, int to) {
		if (from > to || from < 0 || to > nums.length - 1)
			return null;
		else if (from == to) {
			Node tmp = new Node(from, nums[from], from, to);
			tmp.sum = nums[from];
			return tmp;
		} else {
			int mid = from + (to - from) / 2;
			Node cur = new Node(mid, nums[mid], from, to);
			Node left = buildNodeTree(nums, from, mid - 1);
			Node right = buildNodeTree(nums, mid + 1, to);
			cur.left = left;
			cur.right = right;
			cur.sum = nums[mid];
			if (left != null)
				cur.sum += left.sum;
			if (right != null)
				cur.sum += right.sum;
			return cur;
		}

	}

	class Node {
		int index;
		long val;
		long sum;
		int begin;
		int end;
		Node left;
		Node right;

		Node(int index, int val, int begin, int end) {
			this.index = index;
			this.val = val;
			this.begin = begin;
			this.end = end;
		}
	}
}
