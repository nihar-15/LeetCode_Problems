class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] totalMoves = new int[n];
        for (int i = 0; i < shifts.length; i++) {
            int start = shifts[i][0];
            int end = shifts[i][1];
            int direction = shifts[i][2] == 1 ? 1 : -1;
            
            totalMoves[start] += direction;
            if (end + 1 < n) {
                totalMoves[end + 1] -= direction;
            }
        }
   
        for (int i = 1; i < n; i++) {
            totalMoves[i] += totalMoves[i - 1];
        }
 
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            // Normalize the shift to be within 0-25
            int shift = totalMoves[i] % 26;
            if (shift < 0) {
                shift += 26;
            }
            
          
            char newChar = (char) ((s.charAt(i) - 'a' + shift) % 26 + 'a');
            result.append(newChar);
        }
        
        return result.toString();
    }
}
