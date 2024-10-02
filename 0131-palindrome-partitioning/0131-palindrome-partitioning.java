class Solution {
    public List<List<String>> partition(String s) {
         List<List<String>> ans=new ArrayList<>();
        List<String> path =new ArrayList<>();
        
        fun(s,ans,path,0);
        return ans;
    }
    
      public static void fun(String a,List<List<String>> ans,List<String> path,int idx){
       
        
        if(idx==a.length()){
            ans.add(new ArrayList<>(path));
        }
        
        for(int i=idx;i<a.length();i++){
            if(isPalindrome(a,idx,i)){
                path.add(a.substring(idx,i+1));
                fun(a,ans,path,i+1);
                path.remove(path.size() - 1);
            }
        }
    }
    
    
    public static boolean isPalindrome(String s,int start,int end){
        
         while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }
}