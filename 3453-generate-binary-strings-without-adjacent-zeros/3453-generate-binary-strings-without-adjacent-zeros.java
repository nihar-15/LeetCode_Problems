class Solution {
    List<String>  ans;
    public List<String> validStrings(int n) {
        ans =  new ArrayList<>();
        fun(1, new StringBuilder() , n);
        return ans;
    }
     private void fun(int prev, StringBuilder str, int n) {
        if (str.length() == n) {
            ans.add(str.toString());
            return;
        }
        str.append('1');
        fun(1, str, n);
        str.deleteCharAt(str.length() - 1);
        if (prev == 1) {
            str.append('0');
            fun(0, str, n);
            str.deleteCharAt(str.length() - 1);
        } 
}
}