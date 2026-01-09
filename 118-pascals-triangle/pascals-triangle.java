class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 1; i<=numRows; i++){
            printN(i, list);
        }
        return list;
    }
    public void printN(int n, List<List<Integer>> list){
        int ans = 1;
        List<Integer> temp = new ArrayList<>();
        temp.add(ans);    
        for(int i = 1; i<n; i++){
            ans = ans*(n-i);
            ans = ans/i;
            temp.add(ans);
        }
        list.add(temp);
    }
}