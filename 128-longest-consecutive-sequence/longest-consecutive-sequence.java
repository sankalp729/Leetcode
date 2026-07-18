class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        int maxLen = 0;
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        for(int num : set){
            int curr = num;
            if(!set.contains(curr-1)){
                int len = 1;
                while(set.contains(curr+1)){
                    len++;
                    curr++;
                }
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }
}