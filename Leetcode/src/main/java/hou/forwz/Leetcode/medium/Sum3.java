package hou.forwz.Leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年7月7日下午9:20:14
 */

public class Sum3 {
	public static void main(String[] args) {
		Sum3 s3 = new Sum3();
		int[] nums = { -4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6 };
		System.out.println(s3.threeSum(nums));
	}

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> ret = new ArrayList<>();

		if (nums.length == 0)
			return ret;
		else {
			Arrays.sort(nums);
			int len = nums.length;
			for (int i = 0; i < len - 2; i++) {
				int left = i + 1;
				int right = len - 1;
				int cur = nums[i];

				if (i == 0 || (nums[i - 1] != nums[i]))

					while (left < right) {
						// System.out.println(i+", [" + left + "," + right +
						// "]");

						if (nums[left] + nums[right] + cur > 0) {
							int now = nums[right];

							while (true) {
								if (right > left && nums[right] == now)
									right--;
								else
									break;
							}
						} else if (nums[left] + nums[right] + cur < 0) {
							int now = nums[left];

							while (true) {
								if (left < right && nums[left] == now)
									left++;
								else
									break;
							}
						} else {
							List<Integer> tmp = new ArrayList<>();
							tmp.add(cur);
							tmp.add(nums[left]);
							tmp.add(nums[right]);
							ret.add(tmp);

//							System.out.println(tmp);

							int now = nums[left];
							while (true) {
								if (left < right && nums[left] == now)
									left++;
								else
									break;
							}
						}
					}

			}
			return ret;
		}
	}

}
