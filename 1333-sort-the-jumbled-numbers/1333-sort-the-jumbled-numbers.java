class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
      Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < mapping.length; i++) {
            map.put(i, mapping[i]);
        }
        ArrayList<Pair> list = new ArrayList<>();
        for (int num : nums) {
            String number = Integer.toString(num);
            int val = func(number, map);
            list.add(new Pair(number, val));
        }
        Collections.sort(list);
        
        int[] sortedNums = new int[nums.length];
        for (int i = 0; i < list.size(); i++) {
            sortedNums[i] = Integer.parseInt(list.get(i).str);
        }
        return sortedNums;
    }
    
    int func(String num, Map<Integer, Integer> map) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            int a = map.get(Character.getNumericValue(num.charAt(i)));
            ans.append(a);
        }
        return Integer.parseInt(ans.toString());
    }
}
    
    class Pair implements Comparable<Pair> {
        String str;
        int val;
        
        Pair(String str, int val) {
            this.str = str;
            this.val = val;
        }
        
        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.val, other.val);
        }

    }