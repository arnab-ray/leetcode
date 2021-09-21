package dynamicprogramming.medium;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int maxJumpLength = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i > maxJumpLength)
                return false;

            maxJumpLength = Math.max(maxJumpLength, i + nums[i]);
            if(maxJumpLength >= nums.length - 1)
                return true;
        }

        return maxJumpLength >= nums.length - 1;
    }
}
