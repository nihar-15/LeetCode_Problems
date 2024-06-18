class Solution {
    public String orderlyQueue(String s, int k) {
        if( k  > 1){
         char tempArray[] = s.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
        }
        String result = s;

        for(int i = 0; i < s.length() -1 ; i++){
            char firstChar = s.charAt(0);
            s = s.substring(1) + firstChar;

            if(s.compareTo( result) <0 ){
                result = s;
            }
        }
        return result;
    }
}