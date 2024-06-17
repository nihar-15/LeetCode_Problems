class Solution {
    public int compress(char[] chars) {
        int count =0;
        int index =0 , i=0;
            
        while( i < chars.length){
            char cur_char =   chars[i];
            count = 0;
            while( i < chars.length && cur_char == chars[i] ){
                i++;
                count++;
            }    
            chars[index++] =cur_char;
            if(count > 1){
                String s = Integer.toString(count);
                
                for(int k =0;k<s.length();k++){
                    chars[index++] = s.charAt(k);
                }
            }
        }
        return index;
    }
}

