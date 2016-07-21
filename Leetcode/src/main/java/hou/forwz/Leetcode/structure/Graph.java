package hou.forwz.Leetcode.structure;

import java.util.LinkedList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年7月22日上午1:50:51
 */

public class Graph {
	public int val;

	public List<Graph> next;

	public Graph(int val) {
		this.val = val;
		next = new LinkedList<>();
	}

	@Override
	public int hashCode() {
		return val;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Graph) {
			Graph g = (Graph) obj;
			return g.val == val;
		}
		return false;
	}
}
