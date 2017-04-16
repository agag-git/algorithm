/**
 * Created by admin on 2015/12/20.
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp += nums[i];
            if (temp > sum)
                sum = temp;
            if (temp < 0)
                temp = 0;
        }
        return sum;
    }
}
