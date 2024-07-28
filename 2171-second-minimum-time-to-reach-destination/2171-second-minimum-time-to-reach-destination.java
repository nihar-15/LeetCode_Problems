import java.util.*;

class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] d1 = new int[n + 1];
        int[] d2 = new int[n + 1];
        Arrays.fill(d1, Integer.MAX_VALUE);
        Arrays.fill(d2, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 1});
        d1[1] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int timePassed = cur[0];
            int node = cur[1];

            if (d2[n] != Integer.MAX_VALUE && node == n) {
                return d2[n];
            }

            int mult = timePassed / change;
            if (mult % 2 == 1) { // Red Light
                timePassed = change * (mult + 1);
            }

            for (int neighbour : adj.get(node)) {
                if (d1[neighbour] > timePassed + time) {
                    d2[neighbour] = d1[neighbour];
                    d1[neighbour] = timePassed + time;
                    pq.offer(new int[]{timePassed + time, neighbour});
                } else if (d2[neighbour] > timePassed + time && d1[neighbour] != timePassed + time) {
                    d2[neighbour] = timePassed + time;
                    pq.offer(new int[]{timePassed + time, neighbour});
                }
            }
        }

        return -1;
    }
}
