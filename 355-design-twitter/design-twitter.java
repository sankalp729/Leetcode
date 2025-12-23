class Twitter {

    int time = 0;

    class Tweet{
        int tweetId;
        int time;
        Tweet next;

        Tweet(int tweetId, int time){
            this.tweetId = tweetId;
            this.time = time;
        }
    }
    class User{
        int userId;
        Set<Integer> followed;
        Tweet tweetHead;

        User(int userId){
            this.userId = userId;
            followed = new HashSet<>();
            follow(userId); // self follow
        }

        void follow(int userId){
            followed.add(userId);
        }
        void unfollow(int userId){
            followed.remove(userId);
        }
        void post(int tweetId){
            Tweet t = new Tweet(tweetId, time++);
            t.next = tweetHead;
            tweetHead = t;                
        }
    }
    
    HashMap<Integer, User> map;
    
    private User getUser(int userId){
        if(!map.containsKey(userId)){
            map.put(userId, new User(userId));
        }
        return map.get(userId);
    }

    public Twitter() {
        map = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        getUser(userId).post(tweetId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        
        if(!map.containsKey(userId)) return res;

        PriorityQueue<Tweet> pq = new PriorityQueue<>((x, y) -> Integer.compare(y.time, x.time));
        
        for(int followeeId : getUser(userId).followed){
            Tweet t = getUser(followeeId).tweetHead;
            if(t != null) pq.add(t);
        }
        while(!pq.isEmpty() && res.size() < 10){
            Tweet t = pq.poll();
            res.add(t.tweetId);
            if(t.next != null) pq.add(t.next);
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        getUser(followerId).follow(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerId == followeeId) return;
        getUser(followerId).unfollow(followeeId);
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