class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int ans[][] = image;
        int m = image.length;
        int n = image[0].length;
        int dr[] = {0 ,-1 ,0, 1};
        int dc[] ={-1, 0 ,1,0};
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(sr , sc));
        int oldColor = image[sr][sc];
        ans[sr][sc] = color;
        while(!q.isEmpty()){
            Pair cur =  q.poll();
            int row = cur.row;
            int col = cur.col;
            
            for(int i =0;i<4;i++){
                int newRow = row+dr[i];
                int newCol = col+dc[i];
                if(isSafe(newRow , newCol , m , n) && image[newRow][newCol] == oldColor && ans[newRow][newCol] != color){
                    q.offer(new Pair(newRow , newCol));
                    ans[newRow][newCol]= color;
                }
            }
        }
        return ans;
        
    }
    boolean isSafe(int i ,int j , int m , int n){
        if(i<0 || i>=m|| j<0|| j>= n) return false;

        return true;
    }

}
class Pair{
    int row , col;
    Pair(int r , int c){
        row = r;
        col = c;
    }
}