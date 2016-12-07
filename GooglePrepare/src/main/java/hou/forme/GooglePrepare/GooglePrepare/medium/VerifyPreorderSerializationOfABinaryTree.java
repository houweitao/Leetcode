package hou.forme.GooglePrepare.GooglePrepare.medium;

/**
 * @author houweitao
 * @date 2016年12月7日下午1:49:38
 * @end 2016年12月07日14:07:20
 */

public class VerifyPreorderSerializationOfABinaryTree {
	int pos = 0;

	public boolean isValidSerialization(String preorder) {
		String[] strs = preorder.split(",");

		boolean yes = dfs(strs);
		return yes && pos == strs.length;
	}

	private boolean dfs(String[] strs) {
		if (pos >= strs.length) {
			return false;
		} else if (strs[pos].equals("#")) {
			pos++;
			return true;
		} else {
			pos++;
			return dfs(strs) && dfs(strs);
		}
	}
}
