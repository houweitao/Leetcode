package hou.forwz.Leetcode.structure;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年7月18日上午12:06:42
 */

public class UndirectedGraphNode {
	public int label;
	public List<UndirectedGraphNode> neighbors;

	public UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}

}
