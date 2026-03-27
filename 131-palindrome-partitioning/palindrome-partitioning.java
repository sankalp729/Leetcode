class Solution {
    public boolean isPalindrome(String s, int start, int end){
        for(int i=start, j=end; i<j; i++, j--){
            if(s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }
    public List<List<String>> partition(String s) {
        List<List<String>> list= new ArrayList<>();
        List<String> temp= new ArrayList<>();
        rec(s, list, temp, 0);
        return list;
    }
    public void rec(String s, List<List<String>> list, List<String> temp, int idx){
        if(idx == s.length()){
            list.add(new ArrayList<>(temp));
            return;
        }
        for(int i=idx; i<s.length(); i++){
            if(isPalindrome(s, idx, i)){
                temp.add(s.substring(idx, i+1));
                rec(s, list, temp, i+1);
                temp.remove(temp.size() -1);
            }
        }
    }
}