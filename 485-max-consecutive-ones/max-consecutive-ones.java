class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int cnt1 = 0, maxCnt1 = 0;
        for(int i : nums){
            if(i == 1){
                cnt1++;
                maxCnt1 = Math.max(maxCnt1, cnt1);
            }else{
                cnt1 = 0;
            }
        }
        return maxCnt1;
    }
}