class Solution {
    public boolean dfs(List<List<Integer>> list, int[] color, int col, int node){
        color[node] = col;
        for(int i : list.get(node)){
            if(color[i] == -1){
                if(dfs(list, color, 1-col, i) == false) return false;
            }else if(color[i] == col){
                return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        List<List<Integer>> list= new ArrayList<>();
        for(int i=0; i<V; i++){
            list.add(new ArrayList<>());
        }
        for(int i=0; i<V; i++){
            for(int neigh : graph[i]){
                list.get(i).add(neigh);
            }
        }
        int[] color = new int[V];
        Arrays.fill(color, -1);
        for(int i=0; i<V; i++){
            if(color[i] == -1){
                if(dfs(list, color, 0, i) == false) return false;
            }
        }
        return true;
    }
}