class Pair{
    int time;
    int node;
    Pair(int time, int node){
        this.time= time;
        this.node= node;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> list= new ArrayList<>();
        for(int i=0; i<=n; i++){
            list.add(new ArrayList<Pair>());
        }
        for(int i=0; i<times.length; i++){
            int u= times[i][0];
            int v= times[i][1];
            int wt= times[i][2];

            list.get(u).add(new Pair(wt, v));
        }
        PriorityQueue<Pair> pq= new PriorityQueue<>((x, y) -> (x.time- y.time));
        pq.add(new Pair(0, k));
        int[] dist= new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        while(!pq.isEmpty()){
            Pair p= pq.poll();
            int time= p.time;
            int node= p.node;

            for(Pair it : list.get(node)){
                int adjNode = it.node;
                int edW = it.time;

                if(dist[adjNode] > edW+time){
                    dist[adjNode] = edW+time;
                    pq.add(new Pair(edW+time, adjNode));
                }
            }
        }
        int ans= 0;
        for(int i=1; i<=n; i++){
            if(dist[i] == Integer.MAX_VALUE) return -1;
            ans= Math.max(ans, dist[i]);
        }
        return ans;
    }
}