package map.easy;

public class CountPrimes {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }

        boolean[] numbers = new boolean[n];
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (!numbers[i]) {
                for (int j = i * i; j < n; j += i) {
                    numbers[j] = true;
                }
            }
        }

        int numOfPrimes = 0;
        for (int i = 2; i < n; i++) {
            if (!numbers[i]) {
                numOfPrimes++;
            }
        }

        return numOfPrimes;
    }
}
