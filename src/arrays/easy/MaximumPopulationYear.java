package arrays.easy;

/**
 * @author arnab.ray
 * @created on 10/01/22
 */
// #1854
public class MaximumPopulationYear {
    public int maximumPopulation(int[][] logs) {
        int startYear = 1950;
        int[] count = new int[101];

        for (int[] log : logs) {
            count[log[0] - startYear]++;
            count[log[1] - startYear]--;
        }

        int maxVal = count[0], result = startYear;
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
            if (count[i] > maxVal) {
                maxVal = count[i];
                result = startYear + i;
            }
        }

        return result;
    }
}
