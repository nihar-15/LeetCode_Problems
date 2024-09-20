class Solution {
    public String shortestPalindrome(String s) {
        int length = s.length();
        String reverse = new StringBuilder(s).reverse().toString();
        for(int i = 0 ; i< length ; i++){
            if(s.substring(0 , length - i).equals(reverse.substring(i))){
                return new StringBuilder(reverse.substring(0 , i)).append(s).toString();
            }
        }
        return "";
    }
}

