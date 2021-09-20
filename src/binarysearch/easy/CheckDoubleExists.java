package binarysearch.easy;

import java.util.Arrays;

public class CheckDoubleExists {
    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++){
            int j = binSearch(arr, 0, arr.length - 1, arr[i] * 2);
            if(i != j && j != -1){
                return true;
            }
        }
        return false;
    }

    private int binSearch(int[] A, int low, int high, int target){
        if (low <= high) {
            int mid = low + (high - low) / 2;
            if(A[mid] == target)
                return mid;
            else if(A[mid] < target)
                return binSearch(A, mid + 1, high, target);
            else
                return binSearch(A, low, mid - 1, target);
        }

        return -1;
    }
}
