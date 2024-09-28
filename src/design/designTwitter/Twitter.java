package design.designTwitter;

import java.util.*;

class Twitter {
    private static final Twitter TITTER = new Twitter();

    public static void main(String[] args) {
        TITTER.postTweet(1,5);
        TITTER.unfollow(1,1);
        System.out.println(TITTER.getNewsFeed(1));
    }

    private final Map<Integer, User> activeUsers;

    public Twitter() {
        activeUsers = new HashMap<>();
    }

    private User saveUser(int userId){
        User user = activeUsers.get(userId);
        if (user==null) {
            user =new User(userId);
            activeUsers.put(userId, user);
        }
        return user;
    }

    public void postTweet(int userId, int tweetId) {
        User user = saveUser(userId);
        user.post(tweetId);
    }

    public List<Integer> getNewsFeed(int userId) {
        User user = saveUser(userId);
        return user.getRecentNews(10);
    }

    public void follow(int followerId, int followeeId) {
        if (followerId==followeeId) throw new RuntimeException("cannot follow yourself");
        User follower = saveUser(followerId);
        User followee = saveUser(followeeId);
        followee.follow(follower);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followerId==followeeId) throw new RuntimeException("cannot unfollow yourself");
        User follower = saveUser(followerId);
        User followee = saveUser(followeeId);
        followee.unfollow(follower);
    }

    private record Tweet(int id, int authorId, int time) {
    }

    private static class User{
        private static int globalTime = 0;
        private final int id;
        private Set<User> followers;
        private List<Tweet> recentPosts;

        public User(int id) {
            this.id = id;
            this.followers = new HashSet<>();
            this.recentPosts= new ArrayList<>();
        }

        public List<Integer> getRecentNews(int depth){
            List<Integer> news = new ArrayList<>();
            recentPosts.sort(Comparator.comparingInt(Tweet::time));
            depth = Math.min(depth,  recentPosts.size());
            for (int j = 0; j < depth; j++) {
                int i = recentPosts.size()-1-j;
                news.add(recentPosts.get(i).id);
            }
            return news;
        }

        public void post(int postId){
            Tweet tweet = new Tweet(postId, id, globalTime);
            recentPosts.add(tweet);
            for (User follower : followers){
                follower.getRecentPosts().add(tweet);
            }
            globalTime++;
        }

        public void follow(User follower){
            if (followers.add(follower)) follower.getRecentPosts().addAll(recentPosts.stream().filter(p->p.authorId==this.id).toList());
        }

        public void unfollow(User follower){
           follower.getRecentPosts().removeIf(p->p.authorId==this.id);
           followers.remove(follower);
        }

        public int getId() {
            return id;
        }

        public Set<User> getFollowers() {
            return followers;
        }

        public void setFollowers(Set<User> followers) {
            this.followers = followers;
        }

        public List<Tweet> getRecentPosts() {
            return recentPosts;
        }

        public void setRecentPosts(List<Tweet> recentPosts) {
            this.recentPosts = recentPosts;
        }
    }
}
