package backtracking.medium;

import java.util.LinkedList;
import java.util.List;

public class Subsets {
    private void subsetUtil(int[] nums, int pos, List<Integer> tempList, List<List<Integer>> list) {
        if(pos == nums.length) {
            list.add(new LinkedList<>(tempList));
            return;
        }

        tempList.add(nums[pos]);
        subsetUtil(nums, pos + 1, tempList, list);
        tempList.remove(tempList.size() - 1);
        subsetUtil(nums, pos + 1, tempList, list);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        List<Integer> tempList = new LinkedList<>();
        subsetUtil(nums, 0, tempList, list);

        return list;
    }
}
