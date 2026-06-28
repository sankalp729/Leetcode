class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> front = new ArrayList<>();
        int n = triangle.size();
        for(int i=0; i<n; i++){
            front.add(triangle.get(n-1).get(i));
        }
        for(int i=n-2; i>=0; i--){
            List<Integer> curr = new ArrayList<>();
            for(int j=0; j<=i; j++){
                int d = triangle.get(i).get(j) + front.get(j);
                int dg = triangle.get(i).get(j) + front.get(j+1);
                curr.add(Math.min(d, dg));
            }
            front = curr;
        }
        return front.get(0);
    }
}