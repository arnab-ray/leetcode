package arrays.easy;

public class TwoSum2 {
    public int[] twoSumUtil(int[] numbers, int low, int high, int target) {
        if (numbers[low] + numbers[high] == target)
            return new int[]{low + 1, high + 1};
        else if (numbers[low] + numbers[high] < target)
            return twoSumUtil(numbers, low + 1, high, target);
        else
            return twoSumUtil(numbers, low, high - 1, target);
    }

    public int[] twoSum(int[] numbers, int target) {
        int low = 0, high = numbers.length-1;
        return twoSumUtil(numbers, low, high, target);
    }
}
