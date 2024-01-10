package arrays.medium;

public class TrapRainWater {
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int leftHigh = Integer.MIN_VALUE, rightHigh = Integer.MIN_VALUE;

        for(int i = 0; i < height.length; i++) {
            leftHigh = Math.max(leftHigh, height[i]);
            leftMax[i] = leftHigh;
        }

        int water = 0;
        for(int i = height.length - 1; i >= 0; i--) {
            rightHigh = Math.max(rightHigh, height[i]);
            water += (Math.min(leftMax[i], rightHigh) - height[i]);
        }

        return water;
    }
}
