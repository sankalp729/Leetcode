class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        int n = intervals.length;
        List<int[]> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(list.isEmpty() || intervals[i][0] > list.get(list.size() - 1)[1]){
                int[] temp = new int[2];
                temp[0] = intervals[i][0];
                temp[1] = intervals[i][1];
                list.add(temp);
            }else{
                int[] temp = new int[2];
                temp[0] = list.get(list.size() - 1)[0];
                temp[1] = Math.max(intervals[i][1], list.get(list.size() - 1)[1]);
                list.remove(list.size() - 1);
                list.add(temp);
            }
        }
        int[][] ans = new int[list.size()][2];
        for(int i=0; i<list.size(); i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}