package hou.forwz.LeetcodeAgain.medium;

import java.util.HashMap;
import java.util.Map;

import hou.forwz.LeetcodeAgain.structure.UndirectedGraphNode;

/**
 * @author houweitao
 * @date 2016年9月16日下午12:54:35
 */

public class CloneGraph {
	Map<Integer, UndirectedGraphNode> map = new HashMap<>();

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null)
			return null;
		else if (map.containsKey(node.label))
			return map.get(node.label);
		else {
			UndirectedGraphNode graph = new UndirectedGraphNode(node.label);
			map.put(node.label, graph);

			for (UndirectedGraphNode u : node.neighbors) {
				graph.neighbors.add(cloneGraph(u));
			}

			return map.get(node.label);
		}

	}

}
