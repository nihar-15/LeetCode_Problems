import java.util.*;

class Solution {
    public List<String> commonChars(String[] words) {
        for (int i = 0; i < words.length; i++) {
            char[] ar = words[i].toCharArray();
            Arrays.sort(ar);
            words[i] = new String(ar);
        }

        // Using words.length instead of words.length-1 in the loop condition
        String ans = words[0];
        for (int j = 1; j < words.length; j++) {
            ans = lcs(ans, words[j]);
        }

        // Convert the result string to the list of characters
        List<String> result = new ArrayList<>();
        for (char c : ans.toCharArray()) {
            result.add(String.valueOf(c));
        }
        return result;
    }

    public String lcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int dp[][] = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 0;
        }

        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1))
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                else
                    dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
            }
        }

        int len = dp[n][m];
        int i = n;
        int j = m;

        int index = len - 1;
        char[] str = new char[len];
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                str[index] = s1.charAt(i - 1);
                index--;
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        return new String(str);
    }

}
