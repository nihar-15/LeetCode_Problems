class Solution {
      int cache[][];
    public int maxValue(int[][] events, int k) {
       List<Event> arr = new ArrayList<>();
       
       for(int event[] : events){
        arr.add(new Event(event[0] , event[1] , event[2]));
       }
       Collections.sort(arr);
       int n = arr.size();
        cache = new int[n + 1][k + 1];
        for (int c[] : cache) {
            Arrays.fill(c, -1);
        }
       return func(arr ,  0 , k ); 
    //return 0;
    }
    int func(List<Event> arr , int idx , int k ){
        if(idx >= arr.size() || k <= 0){
            return 0;
        }
        if (cache[idx][k] != -1) return cache[idx][k];
        int notTake = func(arr , idx+1,k );
        int take = Integer.MIN_VALUE;
        int i = idx + 1;
        for( ; i< arr.size() ; i++){
            if(arr.get(i).start > arr.get(idx).end){
                break ;
            }
        }
       
            take = arr.get(idx).profit + func(arr , i , k-1  );
    
        
        return cache[idx][k] = Math.max(take , notTake);
    }
}

class Event implements Comparable<Event> {
    int start, end, profit;

    Event(int s, int e, int p) {
        start = s;
        end = e;
        profit = p;
    }

    public int compareTo(Event other) {
        return Integer.compare(this.start, other.start);
    }
}