package backtracking.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Subsets {
    private void backtrack(int[] nums, int pos, List<Integer> tempList, List<List<Integer>> list) {
        list.add(new ArrayList<>(tempList));

        for (int i = pos; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(nums, i + 1, tempList, list);
            tempList.remove(tempList.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        backtrack(nums, 0, new LinkedList<>(), list);

        return list;
    }
}
