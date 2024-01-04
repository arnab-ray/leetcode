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

    public static List<List<Integer>> threeSum2(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    result.add(temp);
                    j++;
                } else if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        int[] arr = new int[] {-1,0,1,2,-1,-4};
        List<List<Integer>> res = threeSum2(arr);

        for (List<Integer> res_ : res) {
            for (Integer i : res_) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
