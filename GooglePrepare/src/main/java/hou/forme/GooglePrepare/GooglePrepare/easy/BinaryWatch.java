package hou.forme.GooglePrepare.GooglePrepare.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年12月9日下午2:44:32
 * @end 2016年12月09日15:02:26
 */

public class BinaryWatch {
	public static void main(String[] args) {
		BinaryWatch bw = new BinaryWatch();
		System.out.println(bw.readBinaryWatch(2));
	}

	public List<String> readBinaryWatch(int num) {
		List<String> ret = new ArrayList<>();
		for (int i = 0; i <= num; i++) {
			help(i, num - i, ret);
		}

		return ret;
	}

	private void help(int up, int down, List<String> ret) {
		if (up > 4 || up < 0 || down < 0 || down > 6)
			return;

		List<String> upList = get(up, 4);
		List<String> downList = get(down, 6);

		for (String shi : upList) {
			String u = getShi(shi);
			if (u == null)
				continue;
			for (String fen : downList) {
				String d = fetFen(fen);
				if (d == null)
					continue;
				ret.add(u + ":" + d);
			}
		}
	}

	private String fetFen(String str) {
		int[] shi = { 1, 2, 4, 8, 16, 32 };
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			int cur = str.charAt(i) - '0';
			sum += shi[cur];
		}
		if (sum > 59)
			return null;
		else if (sum < 10)
			return "0" + sum;
		else
			return sum + "";
	}

	private String getShi(String str) {
		int[] shi = { 1, 2, 4, 8 };
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			int cur = str.charAt(i) - '0';
			sum += shi[cur];
		}
		if (sum >= 12)
			return null;
		else
			return sum + "";
	}

	private List<String> get(int up, int top) {
		List<String> ret = new ArrayList<>();
		dfs(up, -1, "", ret, top);
		return ret;
	}

	private void dfs(int up, int pos, String pre, List<String> ret, int top) {
		if (up == 0)
			ret.add(pre);
		for (int i = pos + 1; i < top; i++) {
			dfs(up - 1, i, pre + i, ret, top);
		}
	}
}
