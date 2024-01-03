package arrays.medium;

import java.util.Arrays;
import java.util.Scanner;

public class InversionCount {

    private static int mergeCount(int[] arr, int low, int high) {
        int invCount = 0;

        if (low < high) {
            int mid = low + (high - low) / 2;

            invCount += mergeCount(arr, low, mid);
            invCount += mergeCount(arr, mid + 1, high);
            invCount += mergeAggregateCount(arr, low, mid + 1, high);
        }

        return invCount;
    }

    private static int mergeAggregateCount(int[] arr, int low, int mid, int high) {
        int[] left = Arrays.copyOfRange(arr, low, mid + 1);
        int[] right = Arrays.copyOfRange(arr, mid + 1, high);

        int i = 0, j = 0, k = low, swaps = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[i]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                swaps += (mid + 1) - (low + i);
            }
        }

        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];

        return swaps;
    }

    private static int bruteCount(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j])
                    count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Size of Array:");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter Array:");
        for (int x = 0; x < n; x++)
            arr[x] = scanner.nextInt();
        System.out.println("\nBrute Inversion Count: " + bruteCount(arr));
        System.out.println("\nInversion Count: " + mergeCount(arr, 0, arr.length - 1));
    }
}
