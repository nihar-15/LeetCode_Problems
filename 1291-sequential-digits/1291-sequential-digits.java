class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        
         String c = "123456789";
        List<Integer> a = new ArrayList<>();

        for (int i = 0; i < c.length(); i++) {
            for (int j = i + 1; j <= c.length(); j++) {
                int curr = Integer.parseInt(c.substring(i, j));
                if (curr <= high && curr >= low) {
                    a.add(curr);
                }
            }
        }

        a.sort(null);
        return a;
        
    }

    private void func(String digit, String num, int low, int high, List<Integer> ans) {
         if(num.length()>String.valueOf(high).length()){
             return;
         }
        
        if(num.length()==String.valueOf(high).length()){
        if (Integer.parseInt(num) >= low && Integer.parseInt(num) <= high &&(!(ans.contains(Integer.parseInt(num))))) {
            ans.add(Integer.parseInt(num));
        }
        }
        
         if (Integer.parseInt(digit) <= Integer.parseInt(Integer.toString(high).substring(0, 1))) {
            func(Integer.toString(Integer.parseInt(digit) + 1), num, low, high, ans);
    
        }
        
        
        int nextDigit = Integer.parseInt(String.valueOf(num.charAt(num.length() - 1))) + 1;
        num += Integer.toString(nextDigit);
        func(digit, num, low, high, ans);

       
    }
    
}