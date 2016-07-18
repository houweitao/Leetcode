package hou.forwz.Leetcode.hard;

/**
 * @author houweitao
 * @date 2016年7月19日上午2:09:01
 */

public class GasStation {

	public int canCompleteCircuit(int[] gas, int[] cost) {
		int size = gas.length;
		int sum = 0;
		int res = 0;
		int total = 0;
		for (int i = 0; i < size; ++i) {
			sum += gas[i] - cost[i];
			if (sum < 0) {
				total += sum;
				sum = 0;
				res = i + 1;
			}
		}
		total += sum;
		return total < 0 ? -1 : res;
	}

}
