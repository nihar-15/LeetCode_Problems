
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            boolean[] vis = new boolean[n + 1];
            if (!adj.get(u).isEmpty() && !adj.get(v).isEmpty() && dfs(adj, vis, u, v)) {
                return edge;
            }
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return new int[0];
    }
    
    private boolean dfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int u, int target) {
        if (u == target) return true;
        vis[u] = true;
        for (int neighbor : adj.get(u)) {
            if (!vis[neighbor] && dfs(adj, vis, neighbor, target)) {
                return true;
            }
        }
        return false;
    }
}
