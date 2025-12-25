class Solution {
    public boolean isPalindrome(String s, int start, int end){
        for(int i = start, j = end; i<=j; i++, j--){
            if(s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), s, 0);
        return ans;
    }
    public void backtrack(List<List<String>> ans, List<String> temp, String s, int idx){
        if(idx == s.length()){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i = idx; i<s.length(); i++){
            if(isPalindrome(s, idx, i)){
                temp.add(s.substring(idx, i+1));
                backtrack(ans, temp, s, i+1);
                temp.remove(temp.size() - 1);
            }
        }
    }
}