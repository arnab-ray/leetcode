package greedy.medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int start = 0, end = people.length - 1;

        int numBoats = 0;
        while (start <= end) {
            if (people[start] == limit) {
                numBoats++;
                start++;
            } else if (people[start] > limit) {
                start++; numBoats++;
            } else if (people[start] + people[end] <= limit) {
                start++; end--; numBoats++;
            } else {
                end--; numBoats++;
            }
        }

        return numBoats;
    }
}
