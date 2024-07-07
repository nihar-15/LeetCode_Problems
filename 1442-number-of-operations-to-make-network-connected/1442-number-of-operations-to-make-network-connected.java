class Solution {
    private int[] parent;
    public void union(int i , int j){
        int irep = find(i);
        int jrep = find(j);
        parent[irep] = jrep;
    }
    public int find(int i ){
        if(parent[i] == i){
            return i ;
        }
        parent[i] = find(parent[i]);
        return parent[i];
    }
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1 ){
            return -1 ;
        }
        parent = new int[n];
        for(int i = 0 ; i < n ; i++){
            parent[i] = i;
        }
        int connected = n;
        for(int edge[] : connections){
            if(find(edge[0]) != find(edge[1])){
                union(edge[0] , edge[1]);
                connected --;
            }
        }
        return connected -1;
    }
}
