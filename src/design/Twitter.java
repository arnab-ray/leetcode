package design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author arnab.ray
 * @created on 05/11/22
 */
public class Twitter {

    private final Map<Integer, Set<Integer>> userMap;
    private final Map<Integer, Integer> tweetUserMap;
    private final List<Integer> tweets;

    public Twitter() {
        userMap = new HashMap<>();
        tweetUserMap = new HashMap<>();
        tweets = new LinkedList<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweetUserMap.put(tweetId, userId);
        tweets.add(0, tweetId);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> timeLine = new LinkedList<>();
        Set<Integer> followees = userMap.getOrDefault(userId, new HashSet<>());
        for (int i = 0, count = 0; count < 10 && i < tweets.size(); i++) {
            Integer tweetByUser = tweetUserMap.get(tweets.get(i));
            if (followees.contains(tweetByUser) || userId == tweetByUser) {
                timeLine.add(tweets.get(i));
                count++;
            }
        }

        return timeLine;
    }

    public void follow(int followerId, int followeeId) {
        Set<Integer> mappedUsers = userMap.getOrDefault(followerId, new HashSet<>());
        mappedUsers.add(followeeId);
        userMap.put(followerId, mappedUsers);
    }

    public void unfollow(int followerId, int followeeId) {
        if (userMap.get(followerId) != null) {
            userMap.get(followerId).remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
