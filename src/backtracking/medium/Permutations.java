package backtracking.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> list = new LinkedList<>();

        backtrack(nums, list, result);

        return result;
    }

    public void backtrack(int[] nums, List<Integer> list, List<List<Integer>> result) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
        } else {
            for (int num : nums) {
                if (list.contains(num)) continue;
                list.add(num);
                backtrack(nums, list, result);
                list.remove(list.size() - 1);
            }
        }
    }

}
