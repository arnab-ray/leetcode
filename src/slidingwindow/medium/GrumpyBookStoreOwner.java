package slidingwindow.medium;

public class GrumpyBookStoreOwner {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int happy = 0, maybe = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0)
                happy += customers[i];
            else
                maybe += customers[i];


            if (i >= X)
                maybe -= customers[i - X] * grumpy[i - X];

            max = Math.max(max, maybe);
        }

        return happy + max;
    }
}
