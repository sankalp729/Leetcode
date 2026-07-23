class Solution {
    public int maxF(int[] f){
        int max = Integer.MIN_VALUE;
        for(int i=0; i<f.length; i++){
            max = Math.max(max, f[i]);
        }
        return max;
    }
    public int minF(int[] f){
        int min = Integer.MAX_VALUE;
        for(int i=0; i<f.length; i++){
            if(f[i] > 0) min = Math.min(min, f[i]);
        }
        return min;
    }
    public int beautySum(String s) {
        int sum = 0;
        for(int i=0; i<s.length(); i++){
            int[] ch = new int[26];
            for(int j=i; j<s.length(); j++){
                ch[s.charAt(j) - 'a']++;
                sum+= maxF(ch) - minF(ch);
            }
        }
        return sum;
    }
}