class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;
        
        if (canFormOriginal(derived, 0)) {
            return true;
        }
       
        return canFormOriginal(derived, 1);
    }
    
    private boolean canFormOriginal(int[] derived, int initial) {
        int n = derived.length;
        int[] original = new int[n];
        original[0] = initial;
        
        for (int i = 1; i < n; i++) {
            original[i] = original[i - 1] ^ derived[i - 1];
        }
        
        
        return (original[0] == (original[n - 1] ^ derived[n - 1]));
    }
}
