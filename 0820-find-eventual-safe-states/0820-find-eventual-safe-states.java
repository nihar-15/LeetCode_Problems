class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer> result = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
     
        ArrayList<ArrayList<Integer>> reversedGraph = new ArrayList<>();
        int[] indegree = new int[n];
        
        for (int i = 0; i < n; i++) {
            reversedGraph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < n; i++) {
            for (int neighbor : graph[i]) {
                reversedGraph.get(neighbor).add(i);
                indegree[i]++; 
            }
        }
       
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
      
        while (!q.isEmpty()) {
            int curr = q.poll();
            result.add(curr); 
            for (int neighbor : reversedGraph.get(curr)) {
                indegree[neighbor]--; 
                if (indegree[neighbor] == 0) { 
                    q.offer(neighbor);
                }
            }
        }
        
        Collections.sort(result);
        return result;
    }
}
