class Solution {
    class Pair implements Comparable<Pair>{
        int val;
        int indx;
        Pair(int val,int indx){
            this.val = val;
            this.indx = indx;
        }
        public int compareTo(Pair p){
            if(this.val-p.val==0){
                return this.indx-p.indx;
            }
            return this.val-p.val;
        }
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        int r = mat.length;
        int c = mat[0].length;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
       
        for(int i=0;i<r;i++){
            int count = 0;
            for(int j=0;j<c;j++){
                if(mat[i][j]==1){
                    count++;
                }
            }
            pq.add(new Pair(count,i));
        }
        int res[] = new int[k];       
        for(int i=0;i<k;i++){
            res[i] = pq.poll().indx;
        }
        return res;
    }
}