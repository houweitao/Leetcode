package hou.forwz.Leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Map;

import hou.forwz.Leetcode.structure.UndirectedGraphNode;

/**
 * @author houweitao
 * @date 2016年7月18日上午12:06:19
 */

public class CloneGraph {
	Map<Integer, UndirectedGraphNode> map = new HashMap<>();

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null)
			return node;

		if (map.containsKey(node.label))
			return map.get(node.label);
		else {
			UndirectedGraphNode ret = new UndirectedGraphNode(node.label);

			List<UndirectedGraphNode> neib = node.neighbors;

			for (UndirectedGraphNode n : neib) {
				if (n == node) {
					ret.neighbors.add(ret);
				} else
					ret.neighbors.add(cloneGraph(n));
			}

			map.put(ret.label, ret);
			return ret;
		}
	}

}
