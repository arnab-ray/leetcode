package arrays.medium;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersection {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int i = 0; int j = 0;
        List<Integer[]> list = new ArrayList<>();

        while (i < A.length && j < B.length) {
            int min = Math.max(A[i][0], B[j][0]);
            int max = Math.min(A[i][1], B[j][1]);
            System.out.println("min: " + min + ", max: " + max);
            if(min <= max)
                list.add(new Integer[] {min, max});
            if (A[i][1] > B[j][1]) {
                j++;
            } else {
                i++;
            }
        }

        int[][] result = new int[list.size()][2];
        int resultCounter = 0;
        for (int k = 0; k < list.size(); k++) {
            Integer[] val = list.get(k);
            result[resultCounter++] = new int[]{val[0], val[1]};
        }
        return result;
    }
}
