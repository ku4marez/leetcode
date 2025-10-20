package collection;

import java.util.*;

public class MyTwitter {
    HashMap<Integer, Set<Integer>> followers;
    HashMap<Integer, List<int[]>> tweets;
    PriorityQueue<int[]> pq;
    int time;
    public MyTwitter() {
        followers = new HashMap<>();
        tweets = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        time++;
        int[] tweet = new int[2];
        tweet[0] = time;
        tweet[1] = tweetId;
        tweets.computeIfAbsent(userId, k -> new ArrayList<>()).add(tweet);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

        Set<Integer> userIds = new HashSet<>(followers.getOrDefault(userId, new HashSet<>()));
        userIds.add(userId);

        for (Integer uid : userIds) {
            pq.addAll(tweets.getOrDefault(uid, new ArrayList<>()));
        }

        while (!pq.isEmpty() && result.size() < 10) {
            result.add(pq.poll()[1]);
        }
        return result;
    }

    public void follow(int followerId, int followeeId) {
        followers.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followees = followers.get(followerId);
        if (followees != null) {
            followees.remove(followeeId);
        }
    }
}
