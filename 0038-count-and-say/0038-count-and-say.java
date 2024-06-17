class Solution {
    public String countAndSay(int n) {
        if(n == 1){
            return "1";
        }

        String str = countAndSay(n-1);
       String result = "";
    
       for(int i =0;i< str.length() ; i++){
         int count = 1;
         char curChar = str.charAt(i);

         while( i <  str.length()-1 && str.charAt(i) == str.charAt(i+1)){
            i ++;
            count++;
         }

         result += Integer.toString(count)+Character.toString(curChar);
       }
       return result;
    }
}