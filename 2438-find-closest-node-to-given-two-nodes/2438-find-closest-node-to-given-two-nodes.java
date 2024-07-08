class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
      int n = edges.length;
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        Arrays.fill(dist1, Integer.MAX_VALUE); 
        Arrays.fill(dist2, Integer.MAX_VALUE); 
        
        bfs(edges, node1, dist1);
        bfs(edges, node2, dist2);
        
        int minNode = -1;
        int minDistanceTillNow = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (dist1[i] != Integer.MAX_VALUE && dist2[i] != Integer.MAX_VALUE) {
                int maxDist = Math.max(dist1[i], dist2[i]);
                if (maxDist < minDistanceTillNow) {
                    minDistanceTillNow = maxDist;
                    minNode = i;
                }
            }
        }
        
        return minNode;
    }

    void bfs(int[] edges, int startNode, int[] dist) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(startNode);
        dist[startNode] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            int neighbor = edges[cur];
            if (neighbor != -1 && dist[neighbor] == Integer.MAX_VALUE) {
                dist[neighbor] = dist[cur] + 1;
                q.offer(neighbor);
            }
        }

    }
}   