package binarysearch.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArrays2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums1.length; i++)
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);

        for(int i = 0; i < nums2.length; i++){
            int temp = map.getOrDefault(nums2[i], 0);
            if(temp > 0){
                list.add(nums2[i]);
                temp--;
            }
            map.put(nums2[i], temp);
        }

        int[] result = new int[list.size()];
        int i = 0;
        for(Integer num : list)
            result[i++] = num;

        return result;
    }
}
