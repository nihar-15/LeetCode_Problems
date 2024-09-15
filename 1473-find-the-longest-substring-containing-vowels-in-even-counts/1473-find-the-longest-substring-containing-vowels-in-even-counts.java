class Solution {
     public void check(boolean b[],String s,int in,int n){
             int a=0,e=0,i=0,o=0,u=0;
       for(int k=in;k<n;k++){
           if(s.charAt(k)=='a')
                a++;
           else if(s.charAt(k)=='e')
                e++;
           else if(s.charAt(k)=='i')
                i++;
           else if(s.charAt(k)=='o')
                o++;
            else if(s.charAt(k)=='u')
                u++;
            if(a%2==0 && e%2==0 && i%2==0 && o%2==0 && u%2==0)
                b[k]=true;
       }
        }
    public int findTheLongestSubstring(String s) {
        int n=s.length();
       boolean[] b=new boolean[n];
       check(b,s,0,n);
    //    System.out.println(Arrays.toString(b));
       int ans=0,i=0;
       while(i<n){
           int j=n-1;
           if(j-i>ans){
           while(i<j && !b[j])
                j--;
            ans=Math.max(ans,j-i+1);
            i++;
            check(b,s,i,n);
       }
       else return ans;
       }
       return ans;
    }
}