package hou.forwz.LeetcodeAgain.structure;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年9月16日下午12:55:07
 */

public class UndirectedGraphNode {

	public int label;
	public List<UndirectedGraphNode> neighbors;

	public UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}

}
