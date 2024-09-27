class MyCalendarTwo {
    List<Pair> doubleBookings ,  bookings ; 
    public MyCalendarTwo() {
         bookings = new ArrayList<>(); 
         doubleBookings = new ArrayList<>(); 
    }
    
    public boolean book(int start, int end) {
        for(Pair pair : doubleBookings){
            if(isOverlap(pair.start , start , pair.end , end)){
                return false;
            }
        }
        for(Pair pair : bookings){
            if(isOverlap(pair.start, start , pair.end , end)){
                int ans[] = findOverlap(pair.start, start , pair.end , end);
                 doubleBookings.add(new Pair(ans[0] , ans[1]));
            }
        }
        bookings.add(new Pair(start , end));
        return true;
    }
     private boolean isOverlap(int start1, int start2, int end1, int end2) {
        return Math.max(start1, start2) < Math.min(end1, end2);
    }

     private int[] findOverlap(int start1, int start2, int end1, int end2) {
        return new int[]{Math.max(start1, start2), Math.min(end1, end2)};
    }

}

class Pair{
    int start , end ;
    Pair(int s , int e){
        start = s; 
        end =  e;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */