package hou.forwz.Leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author houweitao
 * @date 2016年8月17日下午9:37:51
 * @ps 很复杂...还是看答案去吧 2016年08月17日22:19:46
 * @nb https://discuss.leetcode.com/topic/35494/solution-explanation
 */

public class PatchingArray {
	public static void main(String[] args) {
		PatchingArray pa = new PatchingArray();
		int[] nums = {  };
		int n = 2000;
		System.out.println(pa.minPatches2(nums, n));
	}

	int minPatches2(int[] nums, int n) {
		long miss = 1;
		int added = 0, i = 0;
		while (miss <= n) {
			// System.out.println("out: " + miss);
			if (i < nums.length && nums[i] <= miss) {
				miss += nums[i++];
			} else {
				System.out.println("miss " + miss);
				miss += miss;
				added++;
			}
		}
		return added;
	}

	public int minPatches(int[] nums, int n) {
		int[] addPos = new int[nums.length];
		boolean[] have = new boolean[n + 1];
		Set<Integer> remain = new TreeSet<>();
		List<Integer> sum = new ArrayList<>();

		Arrays.sort(nums);

		for (int i = 1; i <= n; i++) {
			remain.add(i);
		}

		for (int i = 0; i < nums.length; i++) {
			addPos[i] = -1;
		}

		sum.add(nums[0]);
		remain.remove(nums[0]);
		addPos[0]++;
		boolean finish = false;
		while (!finish) {
			int cur = Integer.MAX_VALUE;
			int pos = -1;
			for (int i = 0; i < nums.length; i++) {
				int other = addPos[i] == -1 ? 0 : sum.get(addPos[i]);
				int maybe = nums[i] + other;
				if (cur > maybe) {
					System.out.println(i + ": " + nums[i] + " + " + other);
					cur = maybe;
					pos = i;
				}
			}

			if (cur > n) {
				// System.out.println(cur);
				System.out.println("??");
				finish = true;
				break;
			}
			if (!have[cur]) {
				// System.out.println("add "+cur);
				sum.add(cur);
				have[cur] = true;
				remain.remove(cur);
			}
			addPos[pos]++;
		}

		System.out.println(remain);
		System.out.println(sum);

		if (remain.size() == 0) {
			return 0;
		} else {
			int count = 0;
			while (remain.size() > 0) {
				int out = -1;
				for (int i : remain) {
					out = i;
					break;
				}
				remain.remove(out);
				count++;
				if (remain.isEmpty()) {
					return count;
				}

				for (int i = 0; i < have.length; i++) {
					if (i == out || have[i] == false)
						continue;

					int p = i + out;
					if (p > out)
						break;
					have[p] = true;
					remain.remove(p);
				}
			}
			return count;
		}

	}

}
