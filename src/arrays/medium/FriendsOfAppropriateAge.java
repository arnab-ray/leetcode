package arrays.medium;

import java.util.HashMap;
import java.util.Map;

public class FriendsOfAppropriateAge {
    private boolean isNotFriend(int a, int b) {
        return ((b <= (0.5 * a + 7)) || (b > a));
    }

    public int numFriendRequests(int[] ages) {
        int[] count = new int[121];
        for(int age : ages)
            count[age]++;

        int result = 0;
        for(int i = 0; i <= 120; i++) {
            for(int j = 0; j <= 120; j++) {
                if(isNotFriend(i, j))
                    continue;
                result += (count[i] * count[j]);
                if(i == j)
                    result -= count[i];
            }
        }

        return result;
    }
}
