class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        // this question is going to be solved using the treemap approach.
        if(hand.length % groupSize != 0) return false;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i : hand){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        while(!map.isEmpty()){
            int start = map.firstKey();
            for(int i =0; i<groupSize; i++){
                int curr = start + i;
                if(!map.containsKey(curr)) return false;
                map.put(curr, map.get(curr) - 1);
                if(map.get(curr) == 0) map.remove(curr);
            }
        }
        return true;
    }
}