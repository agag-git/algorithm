/**
 * Created by admin on 2015/12/19.
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += i;
            total -= nums[i];
        }
        return total + nums.length;
    }
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 5, 6};
        MissingNumber missingNumber = new MissingNumber();
        System.out.println("missing number is : " + missingNumber.missingNumber(nums));
    }
}
