class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
      List<List<Integer>> adj = new ArrayList<>();
      boolean[][] pre = new boolean[numCourses][numCourses];
      int []indegree = new int[numCourses];
      Queue<Integer> q = new LinkedList<>();
      List<Boolean> ans = new ArrayList<>();

      for(int i = 0 ; i < numCourses ; i++){
          adj.add(new ArrayList<>());
      }
     
     for(int arr[] :  prerequisites ){
        adj.get(arr[0]).add(arr[1]);
        indegree[arr[1]]++;
        pre[arr[1]][arr[0]] = true;
     }

     for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) q.add(i);
        }
    
     while(!q.isEmpty()){
        int node = q.poll();
        for(int neighbour : adj.get(node)){
            for(int i = 0 ; i < numCourses ; i++){
                if(pre[node][i]){
                    pre[neighbour][i] = true;
                }
            }
            if(--indegree[neighbour] == 0){
                q.add(neighbour);
            }
        }
     }
     
     for(int []query : queries){
        ans.add(pre[query[1]][query[0]]);
     }

     return ans ;
    }
}