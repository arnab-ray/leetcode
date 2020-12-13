package greedy.medium;

import java.util.LinkedList;
import java.util.List;

public class FindMinFibNumbers {
    public int findMinFibonacciNumbers(int k) {
        List<Integer> nums = new LinkedList<>();
        nums.add(1); nums.add(1);

        int start = 1, end = 1;
        while (start + end <= k) {
            int num = start + end;
            nums.add(num);
            start = end; end = num;
        }

        int numsRequired = 0, sum = 0;
        int n = nums.size();
        while (sum != k) {
            sum += nums.get(n - 1);
            if (sum > k) {
                sum -= nums.get(n - 1);
                n--;
            } else {
                numsRequired++;
            }
        }

        return numsRequired;
    }
}
