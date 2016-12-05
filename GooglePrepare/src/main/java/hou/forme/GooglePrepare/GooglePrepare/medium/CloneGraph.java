package hou.forme.GooglePrepare.GooglePrepare.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author houweitao
 * @date 2016年12月5日下午7:42:48
 * @end 2016年12月05日20:00:47
 * @tips 遇到了点麻烦。注意加入 map 的时间
 */

public class CloneGraph {
	Map<Integer, UndirectedGraphNode> map = new HashMap<>();

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		return clone(node);
	}

	private UndirectedGraphNode clone(UndirectedGraphNode node) {
		if (node == null)
			return null;

		if (map.containsKey(node.label))
			return map.get(node.label);

		UndirectedGraphNode ret = new UndirectedGraphNode(node.label);
		map.put(ret.label, ret);// 位置很关键

		for (UndirectedGraphNode n : node.neighbors) {
			ret.neighbors.add(clone(n));
		}
		map.put(ret.label, ret);// 这时候再加就会出 bug

		return ret;
	}

	class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;

		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	};
}
