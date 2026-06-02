class DisjointSet{
    List<Integer> parent= new ArrayList<>();
    List<Integer> size= new ArrayList<>();
    DisjointSet(int n){
        for(int i=0; i<n; i++){
            parent.add(i);
            size.add(1);
        }
    }
    public int findUPar(int node){
        if(node == parent.get(node)) return node;
        int ulp= findUPar(parent.get(node));
        parent.set(node, ulp);
        return ulp;
    }
    public void union(int u, int v){
        int ulpU= findUPar(u);
        int ulpV= findUPar(v);
        if(ulpU == ulpV) return;
        if(size.get(ulpU) > size.get(ulpV)){
            parent.set(ulpV, ulpU);
            size.set(ulpU, size.get(ulpU) + size.get(ulpV));
        }else{
            parent.set(ulpU, ulpV);
            size.set(ulpV, size.get(ulpU) + size.get(ulpV));    
        }
    }
}
class Solution {
    public int largestIsland(int[][] grid) {
        int n= grid.length;
        int[] drow= {-1, 0, 1, 0};
        int[] dcol= {0, 1, 0, -1};
        DisjointSet ds= new DisjointSet(n*n);
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    for(int k=0; k<4; k++){
                        int nrow= i+drow[k];
                        int ncol= j+dcol[k];
                        if(nrow>=0 && nrow<n && ncol>=0 && ncol<n && grid[nrow][ncol] == 1){
                            int node= i*n + j;
                            int adjNode = nrow*n + ncol;
                            ds.union(node, adjNode);
                        }
                    }
                }
            }
        }
        int mx= 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                HashSet<Integer> set = new HashSet<>();
                if(grid[i][j] == 0){
                    for(int k=0; k<4; k++){
                        int nrow= i+drow[k];
                        int ncol= j+dcol[k];
                        if(nrow>=0 && nrow<n && ncol>=0 && ncol<n && grid[nrow][ncol] == 1){
                            int adjNode= nrow*n + ncol;
                            set.add(ds.findUPar(adjNode));
                        }
                    }
                }
                int sizeTotal= 0;
                for(int it : set){
                    sizeTotal += ds.size.get(it);
                }
                mx= Math.max(mx, sizeTotal + 1);
            }
        }
        for(int i=0; i<n*n; i++){
            mx= Math.max(mx, ds.size.get(ds.findUPar(i)));
        }
        return mx;
    }
}