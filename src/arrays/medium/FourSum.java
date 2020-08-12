package arrays.medium;

import java.util.*;

public class FourSum {
    class Pair {
        int x, y;
        Pair(int i, int j) {
            this.x = i;
            this.y = j;
        }
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
        for(int i = 0; i <= nums.length - 4; i++) {
            for(int j = i + 1; j <= nums.length - 3; j++) {
                int k = target - (nums[i] + nums[j]);
                int low = j + 1, high = nums.length - 1;

                while (low < high) {
                    if(nums[low] + nums[high] < k)
                        low++;
                    else if(nums[low] + nums[high] > k)
                        high--;
                    else {
                        List<Integer> list = new LinkedList<>();
                        list.add(nums[i]); list.add(nums[j]); list.add(nums[low]); list.add(nums[high]);
                        result.add(list);
                        low++; high--;
                    }
                }
            }
        }

        return new LinkedList<>(result);
    }
}
