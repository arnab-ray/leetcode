package binarysearch.medium;

import java.util.LinkedList;
import java.util.List;

public class KClosestElement {
    private int findPos(int[] arr, int low, int high, int x) {
        if(low <= high) {
            int mid = low + (high - low)/2;
            if(arr[mid] == x)
                return mid;
            else if(arr[mid] > x)
                return findPos(arr, low, mid - 1, x);
            else
                return findPos(arr, mid + 1, high, x);
        }
        return high;
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new LinkedList<>();
        int pos = findPos(arr, 0, arr.length - 1, x);
        System.out.println(pos);
        int right = pos + 1;
        while (right - pos - 1 < k) {
            if(right == arr.length || (pos != -1 && Math.abs(x - arr[pos]) <= Math.abs(arr[right] - x)))
                pos--;
            else
                right++;
        }

        for(int i = pos + 1; i < right; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}
