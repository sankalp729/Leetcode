class Pair{
    String word;
    int steps;
    Pair(String word, int steps){
        this.word = word;
        this.steps = steps;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        int n = wordList.size();
        for(int i=0; i<n; i++){
            set.add(wordList.get(i));
        }
        set.remove(beginWord);
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        
        while(!q.isEmpty()){
            Pair p= q.poll();
            String word = p.word;
            int steps = p.steps;
            if(word.equals(endWord) == true) return steps;

            for(int i=0; i<word.length(); i++){
                for(char ch= 'a'; ch<='z'; ch++){
                    char[] replacedWord = word.toCharArray();
                    replacedWord[i] = ch;
                    String newWord = new String(replacedWord);
                    if(set.contains(newWord) == true){
                        set.remove(newWord);
                        q.offer(new Pair(newWord, steps+1));
                    }
                }
            }
        }
        return 0;
    }
}