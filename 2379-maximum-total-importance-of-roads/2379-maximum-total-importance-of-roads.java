class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int degree[] = new int[n];
        for (int a[]: roads){
            degree[a[0]]++;
            degree[a[1]]++;
        }

        Arrays.sort(degree);
        long val =1;
        long ans =0;
        for(int i =0;i<n;i++){
            ans += val * degree[i];
            val++;
        }

        return ans;
    }
}