class Solution {
    public String reverseWords(String str) {
        
  
        
         String[] words =  str.trim().split("\\s+"); 
        System.out.println(words[0]);
          
        String ans="";
        
        for(int i=words.length-1;i>=0;i--){
            ans += words[i];
            if(i!=0){
            ans+=" ";
            }
        }
        return ans;
        
    }
}