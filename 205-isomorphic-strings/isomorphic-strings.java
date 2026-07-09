class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        HashMap<Character, Character> map1 = new HashMap<>();
        for(int i=0; i<n; i++){
            if(map1.containsKey(s.charAt(i))){
                if(map1.get(s.charAt(i)) != t.charAt(i)) return false;
            }
            map1.put(s.charAt(i), t.charAt(i));
        }
        HashMap<Character, Character> map2 = new HashMap<>();
        for(int i=0; i<n; i++){
            if(map2.containsKey(t.charAt(i))){
                if(map2.get(t.charAt(i)) != s.charAt(i)) return false;
            }
            map2.put(t.charAt(i), s.charAt(i));
        }
        return true;
    }
}