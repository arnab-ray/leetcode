package backtracking.medium;

import java.util.*;

public class CombinationSum {
    private void generateCombinations(int[] candidates, int target, List<List<Integer>> result,
                                      int currentSum, List<Integer> partialSet, int pos) {
        if(currentSum > target)
            return;

        if(currentSum == target) {
            result.add(new LinkedList<>(partialSet));
            return;
        }

        for (int i = pos; i < candidates.length; i++) {
            partialSet.add(candidates[i]);
            generateCombinations(candidates, target, result, currentSum + candidates[i], partialSet, i);
            partialSet.remove(partialSet.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> partialSet = new LinkedList<>();
        generateCombinations(candidates, target, result, 0, partialSet, 0);

        return result;
    }
}
