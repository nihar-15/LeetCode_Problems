class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {

        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        int k = 0;
        int ans[] = new int[queries.length];
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            edges.get(i).add(i + 1);
        }
     for(int query[] : queries){
        edges.get(query[0]).add(query[1]);
        ans[k++] = distance(edges, n);
     }
        return ans;
    }

   int distance(ArrayList<ArrayList<Integer>> edges , int n ){
   Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];
        int[] dist = new int[n]; 

        q.offer(0);
        vis[0] = true;
        dist[0] = 0;

        while (!q.isEmpty()) {
            int top = q.poll();

            for (Integer neighbor : edges.get(top)) {
                if (!vis[neighbor]) {
                    vis[neighbor] = true;
                    dist[neighbor] = dist[top] + 1; 
                    q.offer(neighbor);
             
                    if (neighbor == n - 1) {
                        return dist[neighbor];
                    }
                }
            }
        }

        return -1;
   }
}