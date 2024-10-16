
class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p2.freq - p1.freq);
        if (a > 0) pq.offer(new Pair(a, 'a'));
        if (b > 0) pq.offer(new Pair(b, 'b'));
        if (c > 0) pq.offer(new Pair(c, 'c'));

        StringBuilder str = new StringBuilder();
        
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int len = str.length();
            if (len >= 2 && str.charAt(len - 1) == curr.ch && str.charAt(len - 2) == curr.ch) {
                if (pq.isEmpty()) {
                    break; 
                }

                Pair next = pq.poll();
                str.append(next.ch);
                next.freq--;

                if (next.freq > 0) {
                    pq.offer(next);
                }

                pq.offer(curr); 
            } else {
                
                str.append(curr.ch);
                curr.freq--;

                if (curr.freq > 0) {
                    pq.offer(curr); 
                }
            }
        }

        return str.toString();
    }

    class Pair {
        int freq;
        char ch;

        Pair(int freq, char ch) {
            this.freq = freq;
            this.ch = ch;
        }
    }
}
