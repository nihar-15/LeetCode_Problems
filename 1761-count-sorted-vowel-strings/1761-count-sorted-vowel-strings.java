class Solution {
    char[] vowels = {'a', 'e', 'i', 'o', 'u'};
    
    public int countVowelStrings(int n) {
       
     
        return count(n, 0);
    }
    
    private int count(int remaining, int start) {
        if (remaining == 0) {
            return 1; 
        }
        
        int total = 0;
        // Start with the current index and continue to the end of vowels
        for (int i = start; i < vowels.length; i++) {
            total += count(remaining - 1, i); 
        }
        
        return total;
    }
}
