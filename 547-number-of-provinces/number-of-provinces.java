class Solution {
    public void dfs(List<List<Integer>> list, boolean[] vis, int curr){
        vis[curr] = true;

        for(int i : list.get(curr)){
            if(vis[i] == false){
                dfs(list, vis, i);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int v = isConnected.length;
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<v; i++){
            list.add(new ArrayList<>());
        }

        for(int i=0; i<v; i++){
            for(int j=0; j<v; j++){
                if(isConnected[i][j] == 1 && i!=j){
                    list.get(i).add(j);
                    list.get(j).add(i);
                }
            }
        }
        
        int cnt = 0;
        boolean[] vis = new boolean[v];
        for(int i=0; i<v; i++){
            if(vis[i] == false){
                cnt++;
                dfs(list, vis, i);
            }
        }
        return cnt;
    }
}