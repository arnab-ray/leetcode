package slidingwindow.medium;

import java.util.HashMap;
import java.util.Map;

public class BinarySubArrayWithSum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int[] P = new int[n];

        for(int i = 0 ; i < n; i++){
            P[i+1] = P[i] + nums[i];
        }

        Map<Integer, Integer> count = new HashMap<>();
        int result = 0;
        for (int j : P) {
            result += count.getOrDefault(j, 0);
            count.put(j + goal, count.getOrDefault(j + goal, 0) + 1);
        }

        return result;
    }
}
