class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        /* 
         int n=text1.length();
        int m= text2.length();
         
        data matrix[][] = findLCS(text1,text2);
         
            
          
                  String lcs = getLCS(matrix, text1,text2);
     return lcs.length();

     */

     int n = text1.length();
     int m = text2.length();
     int dp[][] = new int[n][m];
     for(int a[] :dp){
        Arrays.fill(a , -1);
     }
    return  func(text1 , text2 , n-1, m-1, dp);

        }
        int func(String text1 , String text2, int n , int m, int dp[][]){
            if(n <0 || m<0){
                return 0;
            }
            if(dp[n][m] != -1){
                return dp[n][m];
            }
            if(text1.charAt(n) == text2.charAt(m)){
                return dp[n][m] = 1+ func(text1 , text2 , n-1 , m-1 , dp);
            }
            return dp[n][m]= 0 + Math.max(func(text1 , text2 ,n-1 , m ,dp) , func(text1 , text2 , n , m-1 , dp));
        }

}

  /*  
    
    
    public static data[][]  findLCS(String X,String Y){
             
        int n=X.length();
        int m=Y.length();
        data [][] matrix=new data[n+1][m+1];
        
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                matrix[i][j]=new data('H',0);
            }
        }
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                
                if(X.charAt(i-1)==Y.charAt(j-1)){
                    int value=matrix[i-1][j-1].val+1;
                    char dir='D';
                    matrix[i][j]=new data(dir,value);
                }else{
                    if(matrix[i-1][j].val> matrix[i][j-1].val){
                        int val=matrix[i-1][j].val;
                        char dir='U';
                          matrix[i][j]=new data(dir,val);
                    }else{
                         int value = matrix[i][j - 1].val;
                        char direction = 'L'; // Left
                        matrix[i][j] = new data( direction,value);
                    }
                }
            }
        }
        
        return matrix;
        
    }
    
    
    public static String getLCS(data matrix[][],String X,String Y){
        
        int n = X.length();
        int m = Y.length();
        StringBuilder lcs = new StringBuilder();
        int i = n, j = m;

        while(i>0  && j> 0){
            if(matrix[i][j].dir=='D'){
                lcs.append(X.charAt(i-1));
                i--;
                j--;
            }else{
                if(matrix[i][j].dir=='U'){
                i--;
            }else{
                j--;
            }
        }
        }
        return lcs.reverse().toString();
    }
    
    
    
}
class data{
    
    char dir;
    int val;

    public data(char dir, int val) {
        this.dir = dir;
        this.val = val;
    }

    @Override
    public String toString() {
        return "data{" + "dir=" + dir + ", val=" + val + '}';
    }   
    
}
 */   