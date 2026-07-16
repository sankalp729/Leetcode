class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int max = Integer.MIN_VALUE;
        for(char ch : map.keySet()){
            max = Math.max(max, map.get(ch));
        }
        List<Character>[] arr = new ArrayList[max+1];
        for(int i=0; i<arr.length; i++){
            arr[i] = new ArrayList<>();
        }
        for(char ch : map.keySet()){
            arr[map.get(ch)].add(ch);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=arr.length-1; i>=0; i--){
            for(char ch : arr[i]){
                int freq = i;
                while(freq>0){
                    sb.append(ch);
                    freq--;
                }
            }
        }
        String ans = new String(sb);
        return ans;
    }
}