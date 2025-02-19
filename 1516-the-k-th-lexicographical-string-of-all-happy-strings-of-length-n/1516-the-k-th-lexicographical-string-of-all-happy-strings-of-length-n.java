class Solution {
    public String getHappyString(int n, int k) {
        
        List<String> ans = new ArrayList<>(); 
        List<Character> list = new ArrayList<>(); 
        list.add('a');
        list.add('b');
        list.add('c');
        for(int i = 0 ; i<=2 ; i++){
            String str = "";
            str += list.get(i);
            func(ans , list , str , n );
        }
        Collections.sort(ans); 
        if(k > ans.size()){
            return "";
        }
        return ans.get(k - 1);
    }
    void func(List<String> ans , List<Character> list , String str , int n){
        if(str.length() == n){
            ans.add(str);
            return;
        }
        for(int i = 0 ; i <= 2 ; i ++){
            char a = list.get(i);
            if(a != str.charAt(str.length() - 1)){
                str += a ; 
                func(ans , list , str, n);
                str = str.substring(0 , str.length() - 1);
            }
        }
    }
}