class Solution {
    public String compressedString(String word) {
        StringBuilder ans = new StringBuilder();
        int len = 1;
        for (int i = 0; i < word.length(); i++) {
            if (i < word.length() - 1 && word.charAt(i) == word.charAt(i + 1) && len < 9) {
                len++;
            } else {
                ans.append(len).append(word.charAt(i));
                len = 1; 
            }
        }

        return ans.toString();  
    }
}