package dynamicprogramming.medium;

import java.util.Arrays;

public class JumpGame2 {
    public int jump(int[] nums) {
        int maxJumpLength = 0;
        int[] minJump = new int[nums.length];
        Arrays.fill(minJump, Integer.MAX_VALUE);

        minJump[0] = 0;
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++) {
                if(j + nums[j] >= i) {
                    minJump[i] = Math.min(minJump[i], minJump[j] + 1);
                }
            }
        }

        return minJump[nums.length - 1] == Integer.MAX_VALUE ? -1 : minJump[nums.length - 1];
    }
}
