package edu.zju.algorithm.leetcode;

public class MaximumGap {
    public int maximumGap(int[] nums) {
        int length = nums.length;
        if (length <= 1)
            return 0;
        if (length == 2)
            return nums[1] - nums[0];
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            if (nums[i] > max)
                max = nums[i];
            if (nums[i] < min)
                min = nums[i];
        }
        double bucketLength = (double)(max - min) / (double)(length - 1);
        if (bucketLength == 0)
            return 0;
        int[][] list = new int[length][];
        for (int i = 0; i < length; i++) {
            int index = (int)((long)(nums[i] - min) / bucketLength);
            if (list[index] == null){
                list[index] = new int[2];
                list[index][0] = nums[i];
                list[index][1] = nums[i];
            }
            if (nums[i] > list[index][1])
                list[index][1] = nums[i];
            if (nums[i] < list[index][0])
                list[index][0] = nums[i];
        }
        int maxGap = 0;
        int[] a = list[0];
        int[] b = list[0];
        for (int i = 1; i < length; i++) {
            if (list[i] == null)
                continue;
            a = b;
            b = list[i];
            if ((b[0] - a[1]) > maxGap)
                maxGap = b[0] - a[1];
        }
        return maxGap;
    }

    public static void main(String[] args) {
        MaximumGap maximumGap = new MaximumGap();
        int[] nums = {100, 3, 2, 1};
        System.out.println(maximumGap.maximumGap(nums));
    }
}
