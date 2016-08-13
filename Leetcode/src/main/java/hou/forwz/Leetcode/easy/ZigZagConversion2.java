package hou.forwz.Leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年8月13日下午11:59:31
 */

public class ZigZagConversion2 {

	public static void main(String[] args) {
		ZigZagConversion2 zig = new ZigZagConversion2();
		System.out.println(zig.convert("PAYPALISHIRING", 4));
	}

	public String convert(String s, int numRows) {
		if (numRows == 1)
			return s;
		if (numRows == 2) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < s.length(); i++) {
				if (i % 2 == 0)
					sb.append(s.charAt(i));
			}
			for (int i = 0; i < s.length(); i++) {
				if (i % 2 == 1)
					sb.append(s.charAt(i));
			}

			return sb.toString();
		}

		List<StringBuffer> list = new ArrayList<>();
		for (int i = 0; i < numRows; i++) {
			list.add(new StringBuffer());
		}

		for (int i = 0; i < s.length(); i++) {
			int pos = i % (2 * numRows - 2);
			// System.out.println(i+","+pos);

			if (pos < numRows) {
				list.get(pos).append(s.charAt(i));
			} else {
				int curPos = numRows - pos % numRows;
				list.get(curPos - 2).append(s.charAt(i));
			}
		}
		
//		System.out.println(list);

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i).toString());
		}

		// System.out.println(list);

		return sb.toString();
	}

}
