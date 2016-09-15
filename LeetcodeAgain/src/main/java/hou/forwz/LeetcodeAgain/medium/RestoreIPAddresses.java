package hou.forwz.LeetcodeAgain.medium;

import java.net.StandardSocketOptions;
import java.util.ArrayList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年9月15日下午6:56:55
 */

public class RestoreIPAddresses {
	public static void main(String[] args) {
		RestoreIPAddresses ri = new RestoreIPAddresses();
		System.out.println(ri.restoreIpAddresses("1111"));
	}

	public List<String> restoreIpAddresses(String s) {
		List<String> ret = new ArrayList<>();
		dfs(s, 4, 0, "", ret);
		return ret;
	}

	private void dfs(String s, int pos, int begin, String pre, List<String> ret) {
		// System.out.println(pre);
		if (begin >= s.length() || pos < 1)
			return;
		else if (s.charAt(begin) == '0') {
			if (pos == 1) {
				if (begin == s.length() - 1) {
					String tmp = pre + "." + 0;
					ret.add(tmp.substring(1));
				}
			}
			dfs(s, pos - 1, begin + 1, pre + "." + 0, ret);
		} else {
			if (pos == 1) {
				String last = s.substring(begin);
				if(last.length()>3)
					return;
				int num = Integer.valueOf(last);
				if (num >= 0 && num <= 255) {
					String tmp = pre + "." + num;
					ret.add(tmp.substring(1));
				}
			} else {
				int num = 0;
				for (int i = begin; i < begin + 3 && i < s.length(); i++) {
					num = 10 * num + (s.charAt(i) - '0');
					if (num > 0 && num <= 255) {
						dfs(s, pos - 1, i + 1, pre + "." + num, ret);
					}
				}
			}
		}
	}

}
