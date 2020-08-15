package backtracking.medium;

import java.util.*;

public class Permutations2 {
    private void calculatePermutation(int[] nums, int i, boolean[] visited, List<Integer> list, List<List<Integer>> result) {
        if(visited[i])
            return;

        if(i > 0 && nums[i - 1] == nums[i] && !visited[i - 1])
            return;

        visited[i] = true;
        list.add(nums[i]);
        if(list.size() == nums.length) {
            result.add(new LinkedList<>(list));
        } else {
            for(int j = 0; j < nums.length; j++)
                calculatePermutation(nums, j, visited, list, result);
        }
        list.remove(list.size() - 1);
        visited[i] = false;
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];

        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++)
            calculatePermutation(nums, i, visited, list, result);

        return result;
    }
}
