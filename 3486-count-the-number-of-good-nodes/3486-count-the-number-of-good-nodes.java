class Solution {
    int cnt = 0;

    public int countGoodNodes(int[][] edges) {
        int n = edges.length + 1;  // Number of nodes
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build undirected graph
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        dfs(adj, 0, -1);
        return cnt;
    }

    int dfs(List<List<Integer>> adj, int node, int parent) {
        int size = 1;
        int firstSubtreeSize = -1;

        boolean isGood = true;
        for (int neighbor : adj.get(node)) {
            if (neighbor != parent) {
                int subtreeSize = dfs(adj, neighbor, node);
                size += subtreeSize;

                if (firstSubtreeSize == -1) {
                    firstSubtreeSize = subtreeSize;
                } else if (firstSubtreeSize != subtreeSize) {
                    isGood = false;
                }
            }
        }

        
        if (isGood) {
            cnt++;
        }

        return size;
    }
}
