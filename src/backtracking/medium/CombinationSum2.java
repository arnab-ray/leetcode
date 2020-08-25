package backtracking.medium;

import java.util.*;

public class CombinationSum2 {
    private void generateCombinations(int[] candidates, int target, List<List<Integer>> result,
                                      int currentSum, List<Integer> partialSet, int pos) {
        if(currentSum == target) {
            result.add(new LinkedList<>(partialSet));
            return;
        }

        for (int i = pos; i < candidates.length; i++) {
            if(i != pos && candidates[i] == candidates[i - 1])
                continue;
            if(currentSum + candidates[i] <= target) {
                partialSet.add(candidates[i]);
                generateCombinations(candidates, target, result, currentSum + candidates[i], partialSet, i + 1);
                partialSet.remove(partialSet.size() - 1);
            } else {
                break;
            }
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> partialSet = new ArrayList<>();
        generateCombinations(candidates, target, result, 0, partialSet, 0);

        return result;
    }
}
