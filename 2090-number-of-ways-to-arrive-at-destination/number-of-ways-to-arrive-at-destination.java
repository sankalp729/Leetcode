class Pair{
    long dist;
    int node;
    Pair(long dist, int node){
        this.dist= dist;
        this.node= node;
    }
}
class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<Pair>> list= new ArrayList<>();
        for(int i=0; i<n; i++){
            list.add(new ArrayList<>());
        }
        for(int i=0; i<roads.length; i++){
            int u= roads[i][0];
            int v= roads[i][1];
            int dist= roads[i][2];

            list.get(u).add(new Pair(dist, v));
            list.get(v).add(new Pair(dist, u));
        }
        int[] ways= new int[n];
        long[] ans= new long[n];
        PriorityQueue<Pair> pq= new PriorityQueue<>((x, y) -> Long.compare(x.dist,y.dist));
        pq.add(new Pair(0, 0));
        Arrays.fill(ans, Long.MAX_VALUE);
        ans[0] = 0;
        ways[0] = 1;
        int mod= (int)(1e9 + 7);
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int node= p.node;
            long cost= p.dist;
            
            if(cost > ans[node]) continue;

            for(Pair it : list.get(node)){
                int adjNode= it.node;
                long dist= it.dist;
                if(ans[adjNode] > cost+dist){
                    ans[adjNode] = cost+dist;
                    ways[adjNode] = ways[node];
                    pq.add(new Pair(cost+dist, adjNode));
                }else if(ans[adjNode] == cost+dist){
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }
        return ways[n-1]%mod;
    }
}