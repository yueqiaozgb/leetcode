package top.yueqiao.leetcode;

import java.util.HashMap;

/**
 * @Author : yueqiao
 * @Create : 2025/3/4 22:58
 */
public class Solution1 {

    /**
     * 双重for循环，时间复杂度为O(n^2)
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int temp1 = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int temp2 = nums[j];
                if (temp1 + temp2 == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 0};
    }

    /**
     * 使用hashmap存储过往坐标点，时间复杂度为O(n)
     */
    public int[] twoSum1(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{0, 0};
    }

}
