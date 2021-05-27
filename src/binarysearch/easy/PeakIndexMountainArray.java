package binarysearch.easy;

public class PeakIndexMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        return findPeak(arr, 0, arr.length - 1);
    }

    private int findPeak(int[] arr, int low, int high) {
        if (low <= high) {
            int mid = low + (high - low)/2;

            if ((mid == 0 || arr[mid - 1] < arr[mid]) && (mid == arr.length - 1 || arr[mid] > arr[mid + 1]))
                return mid;
            else if (mid - 1 >= 0 && arr[mid] < arr[mid - 1])
                return findPeak(arr, low, mid - 1);
            else
                return findPeak(arr, mid + 1, high);
        }

        return -1;
    }
}
