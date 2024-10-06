class Solution {
    public boolean areSentencesSimilar(String s1, String s2) {
        Deque<String> d1 = new ArrayDeque<>(Arrays.asList(s1.split(" ")));
        Deque<String> d2 = new ArrayDeque<>(Arrays.asList(s2.split(" ")));
        while(!d1.isEmpty() && !d2.isEmpty() && d1.peek().equals(d2.peek())){
            d1.poll();
            d2.poll();
        }
         while(!d1.isEmpty() && !d2.isEmpty() && d1.peekLast().equals(d2.peekLast())){
            d1.pollLast();
            d2.pollLast();
        }
        return d1.isEmpty() || d2.isEmpty();
    }
}