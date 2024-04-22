class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        List<List<Integer>> adj =new ArrayList<>();
        boolean visited[] = new boolean[n];

        Set<Integer> set = new HashSet<>();
        for(int i : restricted){
            set.add(i);
        }
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] i : edges){                                           //creating bi-directional edges in the the graph 
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int ans=1;
        visited[0]= true;
        while(!q.isEmpty()){
            int ind =q.remove();
            for(int i:adj.get(ind)){
                if(!visited[i] && !set.contains(i)){
                    visited[i] = true;
                    q.add(i);
                    ans++;
                }
            }
        }
return ans;
    }
}