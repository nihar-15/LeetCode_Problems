class Solution {
    public int findCenter(int[][] edges) {
        HashSet<Integer> set = new HashSet<>();
        for(int i =0;i <edges.length;i++){
            for(int j =0;j <edges[i].length; j++){
                if(set.contains(edges[i][j])){
                    return edges[i][j];
                }else{
                    set.add(edges[i][j]);
                }
            }
        }
        return -1;
    }
}