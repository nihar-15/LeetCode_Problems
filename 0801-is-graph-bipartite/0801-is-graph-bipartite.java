class Solution {
    public boolean isBipartite(int[][] graph) {
        int m = graph.length;

        int[] isColoured = new int[m];
        Arrays.fill(isColoured, -1);

        for (int i = 0; i < m; i++) {
            if (isColoured[i] == -1) {
                if (dfs(i, isColoured, graph, 0)== false) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(int i, int[] isColoured, int[][] graph, int colour) {
        isColoured[i] = colour;

        for (int node : graph[i]) {
            if (isColoured[node] == -1) {
                if (!dfs(node, isColoured, graph, 1 - colour)) {
                    return false;
                }
            } else if (isColoured[node] == isColoured[i]) {
                return false;
            }
        }

        return true;
    }
}