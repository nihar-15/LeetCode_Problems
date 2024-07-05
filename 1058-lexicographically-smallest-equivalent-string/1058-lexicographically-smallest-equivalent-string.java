class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
         int n = s1.length();
         int m = baseStr.length();

         List<List<Character>> adj = new ArrayList<>(26);
         for(int i =0 ; i<26 ; i++){
            adj.add(new ArrayList<>());
         }
         for(int i =0; i <n ;i++){
            adj.get(s1.charAt(i) -'a').add(s2.charAt(i));
            adj.get(s2.charAt(i) -'a').add(s1.charAt(i));
         }
         String result = "";
         for(int i =0 ; i< m ;i++){
            boolean isVisited[] = new boolean[26];
            result += dfs(adj , baseStr.charAt(i) , isVisited);
         }
         return result;
    }
    char dfs( List<List<Character>> adj , char cur_char , boolean []isVisited){
        char minChar = cur_char;
        isVisited[cur_char -'a'] = true;
        for(char v : adj.get(cur_char - 'a')){
            if(!isVisited[ v - 'a']){
                minChar = (char) Math.min(minChar, dfs(adj, v, isVisited));
            }
        }
        return minChar;
    }
}