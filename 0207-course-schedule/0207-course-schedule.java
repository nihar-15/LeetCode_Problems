class Solution {
    public boolean canFinish(int V, int[][] prerequisites) {
        

      
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    for(int i = 0 ;i< V; i++){
        adj.add(new ArrayList());
    }
    for(int p[] :prerequisites){
        adj.get(p[0]).add(p[1]);
    }
        // add your code here
         int indegree[] = new int[V];
         for(int i =0 ; i< V ;i++){
             for(Integer a : adj.get(i)){
              indegree[a] ++;   
             }
         }
         Queue<Integer> q = new LinkedList<>();
         for(int i =0 ; i<V ;i++){
             if(indegree[i] == 0){
                 
                 q.offer(i);
             }
         }
         int i =0 ;
         int ans[] = new int[V];
         while(!q.isEmpty()){
           int node =  q.poll();
           ans[i++] = node;
           for(Integer it  : adj.get(node)){
               if(indegree[it] != 0){
                   indegree[it] --;
               }
               if(indegree[it]  == 0){
                   q.offer(it);
               }
           }
           
         }
      if(i== V ) return true;

        return false;
        
    }
}