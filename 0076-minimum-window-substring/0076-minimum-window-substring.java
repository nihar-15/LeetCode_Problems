class Solution {
    public String minWindow(String s, String p) {
        if (s.length() == 0 || p.length() == 0) return "";
        
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int count = map.size();  
        int start = 0, end = 0;
        int minStart = 0, minLength = Integer.MAX_VALUE;
        int n = s.length();
        
        while (end < n) {
            char currEndChar = s.charAt(end);
            if (map.containsKey(currEndChar)) {
                map.put(currEndChar, map.get(currEndChar) - 1);
                if (map.get(currEndChar) == 0) {
                    count--;
                }
            }
            end++;
            
            while (count == 0) {
                if (end - start < minLength) {
                    minLength = end - start;
                    minStart = start;
                }
                
                char currStartChar = s.charAt(start);
                if (map.containsKey(currStartChar)) {
                    map.put(currStartChar, map.get(currStartChar) + 1);
                    if (map.get(currStartChar) > 0) {
                        count++;
                    }
                }
                start++;
            }
        }
        
        if (minLength == Integer.MAX_VALUE) {
            return "";
        }
        
        return s.substring(minStart, minStart + minLength);
    }
}