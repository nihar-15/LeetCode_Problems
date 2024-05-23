class Solution {
    public String longestPalindrome(String s) {
     int maxLength = 1, n = s.length(); // Initialize maxLength to 1
        if (n == 0) {
            return ""; 
        }
        if (n == 1) {
            return s;
        }
        String ans = s.substring(0, 1); // 
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) { 
                if (isValid(s, i, j) && (j - i + 1 > maxLength)) {
                    ans = s.substring(i, j + 1);
                    maxLength = j - i + 1;
                }
            }
        }
        return ans;
    }

    boolean isValid(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;

    }
    }