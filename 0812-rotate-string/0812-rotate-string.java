class Solution {
    public boolean rotateString(String s, String goal) {
        String str = (new StringBuilder(s).append(s)).toString();
        return str.contains(goal) && s.length() == goal.length();
    }
}