package arrays.medium;

import java.util.Scanner;

public class InversionCount {

    private static int mergeCount(int[] arr, int low, int high) {
        int[] temp = new int[arr.length];
        int invCount = 0;

        if (low < high) {
            int mid = low + (high - low) / 2;

            invCount += mergeCount(arr, low, mid);
            invCount += mergeCount(arr, mid + 1, high);
            invCount += mergeAggregateCount(arr, temp, low, mid + 1, high);
        }

        return invCount;
    }

    private static int mergeAggregateCount(int[] arr, int[] temp, int low, int mid, int high) {
        int i = low, j = mid, k = low, swaps = 0;

        while (i < mid && j < high + 1) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                swaps += (mid - i);
            }
        }

        while (i < mid) temp[k++] = arr[i++];
        while (j < high + 1) temp[k++] = arr[j++];

        for (int u = low; u < high + 1; u++)
            arr[u] = temp[u];

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
