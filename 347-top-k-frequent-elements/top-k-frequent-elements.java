class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // bucket sort
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);

        List<Integer>[] list = new ArrayList[nums.length + 1];
        
        for(int i : map.keySet()){
            int freq = map.get(i);
            if(list[freq] == null) list[freq] = new ArrayList<>();
            list[freq].add(i);
        }

        List<Integer> ans = new ArrayList<>();

        for(int i = list.length - 1; i>0 && k>0; i--){
            if(list[i] != null){
                for(int j =0; j<list[i].size(); j++){
                    if(k == 0) break;
                    ans.add(list[i].get(j));
                    k--;
                }
            }
        }

        int[] arr = new int[ans.size()];
        for(int i =0; i<ans.size(); i++){
            arr[i] = ans.get(i);
        }

        return arr;
    }
}