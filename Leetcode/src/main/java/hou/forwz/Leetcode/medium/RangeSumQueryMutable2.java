package hou.forwz.Leetcode.medium;

/**
 * @author houweitao
 * @date 2016年7月26日下午11:13:00
 */

public class RangeSumQueryMutable2 {
	class Node {
		int begin, end, sum = 0;
		Node left, right;

		Node(int begin, int end) {
			this.begin = begin;
			this.end = end;
			left = null;
			right = null;
		}
	}

	public class NumArray {
		Node node;

		public NumArray(int[] nums) {
			node = build(nums, 0, nums.length - 1);
		}

		private Node build(int[] nums, int left, int right) {
			if (left > right)
				return null;
			else if (left == right) {
				Node ret = new Node(left, right);
				ret.sum = nums[left];
				return ret;
			} else {
				Node ret = new Node(left, right);
				int mid = left + (right - left) / 2;
				Node ll = build(nums, left, mid);
				Node rr = build(nums, mid + 1, right);

				ret.left = ll;
				ret.right = rr;
				ret.sum = ll.sum + rr.sum;
				return ret;
			}
		}

		void update(int pos, int val) {
			update(node, pos, val);
		}

		private void update(Node node, int pos, int val) {
			if (node.begin == node.end && node.begin == pos) {
				node.sum = val;
				return;
			}

			int mid = node.begin + (node.end - node.begin) / 2;
			if (pos <= mid)
				update(node.left, pos, val);
			else
				update(node.right, pos, val);

			node.sum = node.left.sum + node.right.sum;
		}

		public int sumRange(int i, int j) {
			return sumRange(node, i, j);

		}

		private int sumRange(Node node, int i, int j) {
			if (node.end == j && node.begin == i) {
				return node.sum;
			}

			int mid = node.begin + (node.end - node.begin) / 2;
			if (i > mid)
				return sumRange(node.right, i, j);
			else if (j <= mid)
				return sumRange(node.left, i, j);
			else {
				return sumRange(node.left, i, mid) + sumRange(node.right, mid + 1, j);
			}
		}

	}

	// Your NumArray object will be instantiated and called as such:
	// NumArray numArray = new NumArray(nums);
	// numArray.sumRange(0, 1);
	// numArray.update(1, 10);
	// numArray.sumRange(1, 2);
}
