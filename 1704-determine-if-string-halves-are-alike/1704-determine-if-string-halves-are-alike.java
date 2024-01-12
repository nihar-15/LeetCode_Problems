class Solution {
    public boolean halvesAreAlike(String s) {
        
        
        int len=s.length();
        s=s.toLowerCase() ;
        String a= s.substring(0,(len/2));
        String b= s.substring(len/2,len);    
        
           if(countvowels(a)==countvowels(b)){    
            return true;    
           }
        return false;

    }
    
    int countvowels(String s){
        int cnt=0;
        Set<Character> set=new HashSet<>();
        Character[] arr = {'a','e','i','o','u'};
        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }
        for(int i=0;i<s.length();i++){
         if(set.contains(s.charAt(i))){
             cnt++;
         }   
        }
        
        return cnt;
    }
}