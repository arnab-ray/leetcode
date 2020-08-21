package backtracking.medium;

import java.util.LinkedList;
import java.util.List;

public class Combinations {
    private void generateCombination(int i, List<Integer> list, int count, List<List<Integer>> result, int n, int k) {
        list.add(i);
        if(count == k) {
            result.add(new LinkedList<>(list));
            list.remove(list.size() - 1);
            return;
        }

        for (int j = i + 1; j <= n; j++)
            generateCombination(j, list, count + 1, result, n, k);

        list.remove(list.size() - 1);
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();

        if(n > 0) {
            List<Integer> list = new LinkedList<>();
            for(int i = 1; i <= n; i++) {
                generateCombination(i, list, 1, result, n, k);
            }
        }

        return result;
    }
}
