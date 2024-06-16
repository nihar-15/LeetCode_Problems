class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        ArrayList<Pair> arr = new ArrayList<>();
        for(int i=0;i<profits.length;i++){
            arr.add(new Pair(capital[i] , profits[i]));
        }
        Collections.sort(arr , new  CapitalComparator());
        int n = profits.length;
        int maxProfit=0 , i =0;
        PriorityQueue<Pair> pq = new PriorityQueue<>(new  ProfitComparator());
        while(k -->0 ){
           while(i < n && arr.get(i).capital <= w){
            pq.offer(arr.get(i));
            i++;
           }
           if(pq.isEmpty()){
            break;
           }
           w += pq.poll().profit;
         
        }
        return w;
    }
}


class Pair {
    int capital, profit;

    Pair(int c, int p) {
        capital = c;
        profit = p;
    }

    @Override
    public String toString() {
        return "(" + capital + ", " + profit + ")";
    }
}

class CapitalComparator implements Comparator<Pair> {
    @Override
    public int compare(Pair p1, Pair p2) {
        return Integer.compare(p1.capital, p2.capital);
    }
}

class ProfitComparator implements Comparator<Pair> {
    @Override
    public int compare(Pair p1, Pair p2) {
        return Integer.compare(p2.profit, p1.profit);
    }
}