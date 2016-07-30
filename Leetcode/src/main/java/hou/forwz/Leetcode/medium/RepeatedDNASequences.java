package hou.forwz.Leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author houweitao
 * @date 2016年7月30日下午11:34:14
 */

public class RepeatedDNASequences {

	public List<String> findRepeatedDnaSequences(String s) {
		Set<String> seen = new HashSet<String>(), repeated = new HashSet<String>();
		for (int i = 0; i + 9 < s.length(); i++) {
			String ten = s.substring(i, i + 10);
			if (!seen.add(ten))
				repeated.add(ten);
		}
		return new ArrayList<String>(repeated);
	}

}
