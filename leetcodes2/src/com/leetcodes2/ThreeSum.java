/*
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

 

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
 */
package com.leetcodes2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		for (int i = 0; i < nums.length - 2; i++) {
			if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
				helper(nums, -nums[i], result, i + 1, nums.length - 1);
			}
		}
		return result;
	}

	public void helper(int[] nums, int target, List<List<Integer>> result, int left, int right) {
		while (left < right) {
			if (nums[left] + nums[right] == target) {
				List<Integer> list = new ArrayList<>();
				list.add(-target);
				list.add(nums[left]);
				list.add(nums[right]);
				result.add(list);

				while (left < right && nums[left] == nums[left + 1]) {
					left++;
				}
				while (left < right && nums[right] == nums[right - 1]) {
					right--;
				}
				left++;
				right--;
			} else if (nums[left] + nums[right] < target) {
				left++;
			} else {
				right--;
			}
		}
	}
	public static void main(String[] args) {


	}

}
