class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> list= new ArrayList<>();
        StringBuilder sb= new StringBuilder();
        Map<Integer, String> map= new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        rec(list, digits, 0, sb, map);
        return list;
    }
    public void rec(List<String> list, String digits, int idx, StringBuilder sb, Map<Integer, String> map){
        if(idx == digits.length()){
            list.add(sb.toString());
            return;
        }
        String str = map.get(digits.charAt(idx) - '0');
        for(char ch : str.toCharArray()){
            sb.append(ch);
            rec(list, digits, idx+1, sb, map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}