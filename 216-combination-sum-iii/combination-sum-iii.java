class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list= new ArrayList<>();
        List<Integer> temp= new ArrayList<>();
        rec(list, temp, k, n, 0, 1);
        return list;
    }
    public void rec(List<List<Integer>> list, List<Integer> temp, int k, int n, int sum, int curr){
        if(k == temp.size() && n == sum){
            list.add(new ArrayList<>(temp));
            return;
        }
        for(int i=curr; i<=9; i++){
            temp.add(i);
            rec(list, temp, k, n, sum+i, i+1);
            temp.remove(temp.size() - 1);
        }
    }
}