package hou.forwz.Leetcode.medium;

import hou.forwz.Leetcode.structure.TreeNode;

/**
 * @author houweitao
 * @date 2016年7月14日上午2:33:37
 */

public class ConvertSortedArrayToBinarySearchTree {

	public TreeNode sortedArrayToBST(int[] nums) {
		return help(nums, 0, nums.length - 1);
	}

	private TreeNode help(int[] nums, int left, int right) {
		if (left > right)
			return null;
		else if (left == right)
			return new TreeNode(nums[left]);
		else if (left + 1 == right) {
			TreeNode ret = new TreeNode(nums[left]);
			ret.right = new TreeNode(nums[right]);
			return ret;
		} else {
			int mid = (left + right) / 2;
			TreeNode ret = new TreeNode(nums[mid]);
			ret.left = help(nums, left, mid - 1);
			ret.right = help(nums, mid + 1, right);
			return ret;
		}

	}

}
