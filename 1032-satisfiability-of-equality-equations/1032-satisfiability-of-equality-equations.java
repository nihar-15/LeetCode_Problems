class Solution {
     private int[] parent; 
      public int find(int i) { 
        if (parent[i] == i) { 
            return i; 
        } 
        
        parent[i] = find(parent[i]); 
        return parent[i]; 
    } 

    public void union(int i, int j) { 
        int irep = find(i); 
        int jrep = find(j); 
  
    
        parent[irep] = jrep; 
    } 
  
    public boolean equationsPossible(String[] equations) {
        parent = new int[26];
         for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        for(String s : equations){
            if(s.charAt(1) == '='){
                union(s.charAt(0) -'a' , s.charAt(3) - 'a');
            }
        }
        for(String s : equations ){
             if(s.charAt(1) == '!'){
             int a = find(s.charAt(0) -'a');
             int b = find(s.charAt(3) - 'a');
             if( a == b){
                return false;
             }
             }
        }
        return true;
    }
}