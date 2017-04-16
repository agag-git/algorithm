package edu.zju.algorithm.leetcode;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int length = nums.length;
        if (length == 0)
            return 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return length;
    }
}
