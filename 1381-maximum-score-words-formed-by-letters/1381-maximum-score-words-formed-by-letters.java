class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
       
        int freq[] = new int[26];
        for(int i = 0; i < letters.length; i++){
            freq[letters[i] - 'a']++;
        }
        int maxScore = 0 ;
        return func( 0, new ArrayList<>(), freq, words, score, maxScore);
    }

    int func(int idx, List<String> cur, int freq[], String[] words, int score[], int maxScore) {
        if(idx == words.length){
            int currentScore = 0;
            for(int i = 0; i < cur.size(); i++){
                for(int j = 0; j < cur.get(i).length(); j++){
                    currentScore += score[cur.get(i).charAt(j) - 'a'];
                }
            }
            return Math.max(maxScore, currentScore);
        }

        if(isFeasible(words[idx], freq)){
            cur.add(words[idx]);
            reduce(freq, words[idx]);
            maxScore = func( idx + 1, cur, freq, words, score, maxScore);
            cur.remove(cur.size() - 1);
            add(freq, words[idx]);
        }

        return func( idx + 1, cur, freq, words, score, maxScore);
    }

    boolean isFeasible(String word, int freq[]) {
        int[] tempFreq = Arrays.copyOf(freq, freq.length);
        for(int i = 0; i < word.length(); i++){
            if(--tempFreq[word.charAt(i) - 'a'] < 0){
                return false;
            }
        }
        return true;
    }

    void reduce(int freq[], String word) {
        for(int i = 0; i < word.length(); i++){
            freq[word.charAt(i) - 'a']--;
        }
    }

    void add(int freq[], String word) {
        for(int i = 0; i < word.length(); i++){
            freq[word.charAt(i) - 'a']++;
        }
    }
}