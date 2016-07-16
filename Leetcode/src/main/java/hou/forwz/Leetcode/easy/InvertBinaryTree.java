package hou.forwz.Leetcode.easy;

import hou.forwz.Leetcode.structure.TreeNode;

/**
 *@author houweitao
 *@date 2016年7月16日下午9:44:12
 */

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if(root==null||root.left==null&&root.right==null)
            return root;
        else{
            TreeNode tmp=root.left;
            root.left=invertTree(root.right);
            root.right=invertTree(tmp);
            return root;
        }
    }

}
