class Solution {
    public int leastInterval(char[] tasks, int n) {
    Map<Character , Integer> map = new HashMap<>();

    for(int i =0;i< tasks.length;i++){
        map.put(tasks[i] , map.getOrDefault(tasks[i] , 0)+1);
    }

    PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());

     for (Map.Entry<Character,Integer> entry : map.entrySet())  {
      pq.offer(entry.getValue()); 
     }

     int time =0;
         while(!pq.isEmpty()){
           ArrayList<Integer> arr = new ArrayList<>();
           for(int i =1;i<=n+1;i++){
            if(!pq.isEmpty()){
                int freq = pq.peek();
                pq.poll();
             
                arr.add(freq -1 );
            }
           }
           for(int f: arr){
            if(f != 0){
                pq.offer(f);
            }
           }
           if(pq.isEmpty()) //all processes finished
                time += arr.size();
            else
                time += (n+1);


         }
         return time;
                           
 
    }
}