class Solution {
    public String stringHash(String s, int k) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n ; i += k){
           String subStr = s.substring(i , i+k);
           int sum = 0;
           for(char c : subStr.toCharArray()){
            sum += c -'a';
           }
           int hashed = sum % 26;

            sb.append((char) (hashed +'a'));
        }
        return sb.toString();
    }
}