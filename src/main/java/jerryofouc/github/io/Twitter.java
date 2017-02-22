package jerryofouc.github.io;

import java.util.*;

/**
 * Created by xiaojiez on 2/21/17.
 */
public class Twitter {
    Integer atomicInteger = 0;
    static class Tweet implements Comparable<Tweet>{

        public Tweet(int id, long order) {
            this.id = id;
            this.order = order;
        }

        @Override
        public boolean equals(Object o) {

            if (this == o) return true;
            if (!(o instanceof Tweet)) return false;

            Tweet tweet = (Tweet) o;

            if (id != tweet.id) return false;
            return order == tweet.order;
        }

        @Override
        public int hashCode() {
            int result = id;
            result = 31 * result + (int) (order ^ (order >>> 32));
            return result;
        }

        private int id;
        private long order;

        @Override
        public int compareTo(Tweet o) {
            if(this.order<o.order){
                return 1;
            }else if(this.order == o.order){
                return 0;
            }else {
                return -1;
            }
        }
    }
    private Map<Integer,TreeSet<Tweet>> tweetMap = new HashMap<>();
    private Map<Integer,List<Integer>> followingMap = new HashMap<>();

    /** Initialize your data structure here. */
    public Twitter() {

    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        TreeSet<Tweet> set = tweetMap.get(userId);
        if(set == null){
            set = new TreeSet<>();
        }
        set.add(new Tweet(tweetId,atomicInteger++));
        tweetMap.put(userId,set);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> list = followingMap.get(userId);
        List<Integer> result = new ArrayList<>();;
        if(list == null){
            list = new ArrayList<>();
        }
        list.add(userId);
        TreeSet<Tweet> tweets = new TreeSet<>();
        for(Integer uid : list){
            TreeSet set = tweetMap.get(uid);
            if(set != null){
                tweets.addAll(set);
            }
        }
        int count = 0;
        for(Tweet t : tweets){
            result.add(t.id);
            count++;
            if(count ==10){
                break;
            }
        }
        return result;


    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId){
            return;
        }
        List<Integer> followees = followingMap.get(followerId);
        if(followees == null){
            followees = new ArrayList<>();
        }
        followees.add(followeeId);
        followingMap.put(followerId,followees);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(followerId == followeeId){
            return;
        }
        List<Integer> followers = followingMap.get(followerId);
        if(followers == null){
            return;
        }
        int index = followers.indexOf(followeeId);
        if(index !=-1){
            followers.remove(index);

        }
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1,5);
        twitter.postTweet(1,3);
        twitter.postTweet(1,101);
        twitter.postTweet(1,13);
        twitter.postTweet(1,10);
        twitter.postTweet(1,2);
        twitter.postTweet(1,94);
        twitter.postTweet(1,505);
        twitter.postTweet(1,333);
        twitter.postTweet(1,22);
        twitter.postTweet(1,11);
        System.out.println(twitter.getNewsFeed(1));
        twitter.follow(1,2);
        twitter.postTweet(2,6);
        twitter.getNewsFeed(1);

        twitter.follow(1,1);
        twitter.unfollow(1,1);
        twitter.getNewsFeed(1);
    }
}
