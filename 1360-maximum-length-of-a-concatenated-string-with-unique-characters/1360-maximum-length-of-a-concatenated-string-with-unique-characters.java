class Solution {
    public int maxLength(List<String> arr) {
        int  n = arr.size();
        String temp = "";
        return func(arr , 0 , n , temp);
    }
    int func(List<String> arr , int idx , int n , String temp){
        if( idx >= n){
            return temp.length();
        }
        int include = 0 ,exclude = 0;
        if(hasDuplicates(arr.get(idx) , temp)){
            exclude = func(arr , idx+1, n , temp);
        }else{
            exclude = func(arr, idx+1, n , temp);
            include = func(arr , idx+1 , n , temp+arr.get(idx));
        }
        return Math.max(include , exclude);
    }
    boolean hasDuplicates(String s1 , String s2){
        boolean v[] = new boolean[26];
        for(int i =0 ; i<s1.length() ; i++){
            if(v[s1.charAt(i) -'a'] == true){
                return true;
            }
            v[s1.charAt(i) -'a'] = true;
        }

        for(int i =0 ; i<s2.length() ; i++){
            if(v[s2.charAt(i) -'a'] == true){
                return true;
            }
            v[s2.charAt(i) -'a'] = true;
        }
        return false ;
    }
}