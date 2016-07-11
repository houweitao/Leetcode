package hou.forwz.Leetcode.structure;

/**
 * @author houweitao
 * @date 2016年7月11日下午10:56:45
 */

public class Interval {
	public int start;
	public int end;

	public Interval() {
		start = 0;
		end = 0;
	}

	public Interval(int s, int e) {
		start = s;
		end = e;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[" + start + "," + end + "]";
	}
}
