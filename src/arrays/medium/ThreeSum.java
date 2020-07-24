package arrays.medium;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        for(int i = 0; i < nums.length - 1; i++) {
            Set<Integer> set = new HashSet<>();
            for(int j = i + 1; j < nums.length; j++) {
                int sum = - (nums[i] + nums[j]);
                if(set.contains(sum)) {
                    int[] a = {sum, nums[i], nums[j]};
                    Arrays.sort(a);
                    List<Integer> list = new LinkedList<>();
                    for(int u : a)
                        list.add(u);

                    result.add(list);
                } else {
                    set.add(nums[j]);
                }
            }
        }

        return new LinkedList<>(result);
    }
}
