class Solution {
    public List<String> letterCombinations(String digits) {
        
        
        String []dial={"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
            
            
        List<String> ans= new ArrayList<>();
          if(digits.length()==0){
              return ans;
          }             
       fun(digits,ans,dial,"",0);
                       
                       
          return ans;  
        
        
    }
        
        public void fun(String digits,List<String> ans,String[] dial,String sub,int idx){
            
            
            
            if(idx==digits.length()){
                ans.add(sub);
                return;
            }
              
            String letters=dial[digits.charAt(idx)-'0'];       
            for(int i=0;i<letters.length();i++){
                fun(digits,ans,dial,sub+letters.charAt(i),idx+1);
            }
        }
}