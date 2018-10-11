package com.wjf.leetcode;

import java.util.Arrays;

/**
 * description ：给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 *               你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * @author : wjf
 * Date ：2018/10/11 10:06
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {10, 2, 18, 11, 15, 7};
        int target = 13;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    private static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++){
                if(nums[j] == target - nums[i]){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
}
