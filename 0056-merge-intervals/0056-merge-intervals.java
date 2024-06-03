class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<Pair> arr =  new ArrayList<>();
       Stack<Pair> stack = new Stack<>();
        for(int i =0;i<intervals.length;i++){
            Pair p = new Pair(intervals[i][0] , intervals[i][1]);
            arr.add(p);
        }
     Collections.sort(arr);
        for(int i =0;i<arr.size();i++){
            if(i ==0){
                stack.push(arr.get(i));
            }else{
                Pair top = stack.peek();
                if(arr.get(i).st > top.et){
                    stack.push(arr.get(i));
                }else{
                    top.et = Math.max(top.et , arr.get(i).et);
                }
            }
            
        }
         int[][] result = new int[stack.size()][2];
        int index = 0;
        
        while (!stack.isEmpty()) {
            Pair p = stack.pop();
            result[index][0] = p.st;
            result[index][1] = p.et;
            index++;
        }
        
        return result;
    }
}



class Pair  implements Comparable<Pair>{
    int st , et;


    Pair(int s , int e){
        st = s;
        et =e;
    }

    public int compareTo(Pair ob){
        if(this.st != ob.st ){
            return this.st - ob.st;
        }
        return this.et - ob.et;
    }
}
