/**
 * Created by admin on 2015/12/23.
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        if (height.length < 3)
            return 0;
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        int leftMax = height[leftIndex];
        int rightMax = height[rightIndex];
        int max = rightMax;
        int trap = 0;
        while (true) {
            while (leftMax <= max) {
                leftIndex++;
                if (height[leftIndex] > leftMax) {
                    leftMax = height[leftIndex];
                } else {
                    trap += leftMax - height[leftIndex];
                }
                if (leftIndex == rightIndex)
                    return trap;
            }
            max = leftMax;
            while (rightMax <= max) {
                rightIndex--;
                if (height[rightIndex] > rightMax) {
                    rightMax = height[rightIndex];
                } else {
                    trap += rightMax - height[rightIndex];
                }
                if (leftIndex == rightIndex)
                    return trap;
            }
        }
    }

    public static void main(String[] args) {
        TrappingRainWater trapping = new TrappingRainWater();
        int[] elevation = {0, 2, 0};
        int trap = trapping.trap(elevation);
        System.out.println(trap);
    }
}
