class Solution {
   boolean isSimiliar(String a , String b){
    int diff =0 ;
    if(a.length() != b.length()){
        return false;
    }
    for(int i =0 ; i< a.length();i++){
        if(a.charAt(i) != b.charAt(i)){
            diff ++;
        }
    }
    return diff<=2;
   }
    public int numSimilarGroups(String[] strs) {
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < strs.length;i++){
            adj.add(new ArrayList<>());
        }
        for(int i =0 ; i< strs.length-1;i++){
            for(int j = i+1; j< strs.length; j++){
                if(isSimiliar(strs[i] , strs[j])){
                 adj.get(i).add(j);
                 adj.get(j).add(i);
                }
               
            }
        }
        boolean isVisited[] = new boolean[strs.length];
        int cnt = 0;
        for(int i =0 ; i<strs.length;i++){
            if(!isVisited[i]){
                dfs(adj , i , isVisited);
                cnt++;
            }
        }
        return cnt;
    }
    void dfs(List<List<Integer>> adj , int node , boolean isVisited[] ){
        isVisited[node] = true;
        for(Integer a : adj.get(node)){
            if(!isVisited[a]){
               dfs(adj , a , isVisited);
            }
            
        }
    }
}