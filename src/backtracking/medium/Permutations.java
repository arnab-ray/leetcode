package backtracking.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> list = new LinkedList<>();

        calculatePermutation(nums, list, result);

        return result;
    }

    public void calculatePermutation(int[] nums, List<Integer> list, List<List<Integer>> result) {
        if (list.size() == nums.length)
            result.add(new ArrayList<>(list));
        for (int num : nums) {
            if (list.contains(num)) continue;
            list.add(num);
            calculatePermutation(nums, list, result);
            list.remove(list.size() - 1);
        }
    }

}
