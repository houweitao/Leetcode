package hou.forwz.Leetcode.medium;

import java.util.List;

/**
 * @author houweitao
 * @date 2016年7月14日上午12:00:22
 */

public class Triangle {

	public int minimumTotal(List<List<Integer>> triangle) {
        
		for (int i = triangle.size() - 1; i > 0; i--) {
			List<Integer> cur = triangle.get(i - 1);
			for (int j = 0; j < cur.size(); j++) {
				cur.set(j, cur.get(j) + Math.min(triangle.get(i).get(j), triangle.get(i).get(j + 1)));
			}
		}
		return triangle.get(0).get(0);
	
    }

}
