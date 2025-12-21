class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // this is the same as n meetings in one room.
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1], b[1]));
        int freeTime = intervals[0][1];
        int cnt = 1;
        for(int i =1; i<intervals.length; i++){
            if(intervals[i][0] >= freeTime){
                cnt++;
                freeTime = intervals[i][1];
            }
        }
        return intervals.length - cnt;
    }
}