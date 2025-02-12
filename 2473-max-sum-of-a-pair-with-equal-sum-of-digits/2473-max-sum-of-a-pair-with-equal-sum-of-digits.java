class Solution {
    public int maximumSum(int[] nums) {
     Map<Integer , List<Integer>> map = new HashMap<>(); 
     int maxSum = -1 ;
     for(int num : nums){
        int sum = sumOfDigits(num);
        System.out.println(sum);
        if(map.containsKey(sum)){
          map.get(sum).add(num);
        }else{
            List<Integer> list = new ArrayList<>(); 
            list.add(num);
            map.put(sum , list);
        }
     }

     for(int key : map.keySet()){
         List<Integer> list = map.get(key); 
         if(list.size() > 1){
            Collections.sort(list);
            maxSum = Math.max(maxSum , list.get(list.size() - 1) + list.get(list.size() -2));
         }
     }
     return maxSum;
    }
    private int sumOfDigits(int num){
        int sum = 0; 
        while(num > 0){
            sum += (num % 10);
            num = num / 10;
        }
        return sum;
    }
}