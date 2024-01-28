package backtracking.medium;

import java.util.*;

public class Permutations2 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);

        calculatePermutation(nums, visited, list, result);

        return result;
    }

    public void calculatePermutation(int[] nums, boolean[] visited, List<Integer> list, List<List<Integer>> result) {
        if (list.size() == nums.length)
            result.add(new ArrayList<>(list));
        for (int i = 0; i < nums.length; i++) {
            if(visited[i] || (i > 0 && nums[i - 1] == nums[i] && !visited[i - 1])) continue;
            visited[i] = true;
            list.add(nums[i]);
            calculatePermutation(nums, visited, list, result);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}
