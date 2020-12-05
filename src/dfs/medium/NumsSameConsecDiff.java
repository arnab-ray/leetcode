package dfs.medium;

import java.util.LinkedList;
import java.util.List;

public class NumsSameConsecDiff {
    private void dfs(int partialNum, int digit, int n, int k, List<Integer> list) {
        partialNum += digit * Math.pow(10, n - 1);
        if (n == 1) {
            list.add(partialNum);
        } else {
            if (digit - k >= 0 && digit + k <= 9 && digit - k == digit + k) {
                dfs(partialNum, digit - k, n - 1, k, list);
            } else {
                if (digit - k >= 0)
                    dfs(partialNum, digit - k, n - 1, k, list);
                if (digit + k <= 9)
                    dfs(partialNum, digit + k, n - 1, k, list);
            }
        }
    }

    private void dfsUtil(int n, int k, List<Integer> list) {
        int start, end = 9;
        if (n == 1)
            start = 0;
        else
            start = 1;

        for (int i = start; i <= end; i++) {
            dfs(0, i, n, k, list);
        }
    }

    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> list = new LinkedList<>();
        dfsUtil(n, k, list);

        int[] result = new int[list.size()];
        int i = 0;
        for (Integer integer : list)
            result[i++] = integer;

        return result;
    }
}
