class Solution {
    public String getSmallestString(String sq) {
          StringBuilder s = new StringBuilder(sq);
        for (int i = 0; i < s.length() - 1; i++) {
            if ((int) s.charAt(i) % 2 == 0 && (int) s.charAt(i + 1) % 2 == 0 && (int) s.charAt(i) > (int) s.charAt(i + 1)) {
                s = swap(i, i + 1, s);
                break;
            }
            if ((int) s.charAt(i) % 2 == 1 && (int) s.charAt(i + 1) % 2 == 1 && (int) s.charAt(i) > (int) s.charAt(i + 1)) {
                s = swap(i, i + 1, s);
                break;
            }
        }
        return s.toString();
    }

    public StringBuilder swap(int se, int e, StringBuilder s) {
        char t = s.charAt(se);
        s.setCharAt(se, s.charAt(e));
        s.setCharAt(e, t);
        return s;
    }
}