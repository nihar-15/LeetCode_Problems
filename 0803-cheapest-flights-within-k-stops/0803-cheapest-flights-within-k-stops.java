class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

        int m = flights.length;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Pair>());
        }

        for (int i = 0; i < m; i++) {
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }

        Queue<Tuple> q = new LinkedList<>();

        q.add(new Tuple(0, src, 0));

        int dist[] = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = (int) 1e9;
        }

        dist[src] = 0;

        while (q.isEmpty() != true) {
            Tuple it = q.peek();
            q.remove();
            int node = it.second;
            int stops = it.first;
            int cost = it.third;

            for (Pair iter : adj.get(node)) {
                int adjNode = iter.first;
                int adjW = iter.second;

                if (cost + adjW < dist[adjNode] && stops <= K) {
                    dist[adjNode] = cost + adjW;
                    q.add(new Tuple(stops + 1, adjNode, cost + adjW));
                }
            }
        }

        if (dist[dst] == (1e9)) {
            return -1;
        }
        return dist[dst];
    }
}

class Pair {
    int first, second;

    Pair(int f, int s) {
        first = f;
        second = s;
    }

}

class Tuple {
    int first, second, third;

    Tuple(int f, int s, int t) {
        first = f;
        second = s;
        third = t;
    }

}
