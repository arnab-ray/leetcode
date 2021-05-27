package binarysearch.easy;

public class KWeakestRows {

    public int[] kWeakestRows(int[][] mat, int k) {
        int[] count = new int[mat.length];
        for (int i = 0; i < mat.length; i++) {
            int lastOne = findLastOccurrence(mat[i], 0, mat[i].length - 1);
            count[i] = lastOne + 1;
        }

        int[] result = new int[k];
        int resultPos = 0;
        for (int i = 0; i < k; i++) {
            int minIndex = 0;
            for (int j = 0; j < count.length; j++) {
                if (count[j] < count[minIndex]) {
                    minIndex = j;
                }
            }
            result[resultPos++] = minIndex;
            count[minIndex] = Integer.MAX_VALUE;
        }

        return result;
    }

    private int findLastOccurrence(int[] row, int low, int high) {
        if (low <= high) {
            int mid = low + (high - low)/2;
            if (mid == row.length - 1 || row[mid] > row[mid + 1])
                return mid;
            else if (row[mid] == 1 && row[mid] == row[mid + 1])
                return findLastOccurrence(row, mid + 1, high);
            else
                return findLastOccurrence(row, low, mid - 1);
        }
        return -1;
    }
}
