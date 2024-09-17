class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        List<String> ans = new ArrayList<>();
        String str1[] = s1.split(" ");
        String str2[] = s2.split(" ");
        Map<String , Integer> map = new HashMap<>();

        for(int i =0 ; i< str1.length ; i++){
            if(map.containsKey(str1[i])){
                map.put(str1[i] ,map.get(str1[i])+1);
            }else{
                map.put(str1[i] , 1);
            }
        }
        for(int i = 0; i< str2.length ; i++){
            if(map.containsKey(str2[i])){
              map.put(str2[i] ,map.get(str2[i])+1);
            }else{
                map.put(str2[i] , 1);
            }
        }
        for(String key : map.keySet()){
            if(map.get(key) == 1){
                ans.add(key);
            }
        }
           String[] arr = new String[ans.size()];
           int i = 0 ;
          for(String a : ans){
            arr[i++] = a;
          }
           return arr;
    }
}