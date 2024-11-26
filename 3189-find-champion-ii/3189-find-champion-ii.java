class Solution {
    public int findChampion(int numVertices, int[][] edges) {
        

        int[] inDegrees = new int[numVertices];
        List<Integer>[] adjacencyList = new ArrayList[numVertices];

        for (int i = 0; i < numVertices; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            adjacencyList[from].add(to);
            inDegrees[to]++;
        }

        int vertexWithZeroInDegree = -1;
        int countZeroInDegreeVertices = 0;

        for (int i = 0; i < numVertices; i++) {
            if (inDegrees[i] == 0) {
                if (vertexWithZeroInDegree != -1) {
                    // Multiple vertices with 0 in-degrees found, return -1.
                    return -1;
                }
                vertexWithZeroInDegree = i;
                countZeroInDegreeVertices++;
            }
        }

        if (countZeroInDegreeVertices == 1) {
            return vertexWithZeroInDegree;
        } 
            // Multiple vertices with 0 in-degrees found, return -1.
            return -1;
        
    

  

    }
}