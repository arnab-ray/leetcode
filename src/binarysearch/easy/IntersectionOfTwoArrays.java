package binarysearch.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] shorter = nums1.length < nums2.length ? nums1 : nums2;
        int[] longer =  nums1.length > nums2.length ? nums1 : nums2;
        Set<Integer> set = new HashSet<>();

        Arrays.sort(longer);
        for(int i = 0; i < shorter.length; i++){
            if(binSearch(longer, 0, longer.length - 1, shorter[i]) != -1){
                set.add(shorter[i]);
            }
        }

        int[] result = new int[set.size()];
        int i = 0;
        for(Integer a : set)
            result[i++] = a;

        return result;
    }

    private int binSearch(int[] A, int low, int high, int target){
        if(low > high)
            return -1;
        int mid = low + (high - low) / 2;
        if(A[mid] == target)
            return mid;
        else if(A[mid] < target)
            return binSearch(A, mid + 1, high, target);
        else
            return binSearch(A, low, mid - 1, target);
    }
}
