class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
          if (hand.length % groupSize != 0) {
            return false; 
          }
       
        Arrays.sort(hand);
        
        TreeMap<Integer, Integer> cardCount = new TreeMap<>();
        for (int card : hand) {
            cardCount.put(card, cardCount.getOrDefault(card, 0) + 1);
        }
        
        for (int card : hand) {
            if (cardCount.get(card) == 0) {
                continue; // This card has already been used in a previous group
            }
            
            
            for (int i = 0; i < groupSize; i++) {
                int currentCard = card + i;
                if (cardCount.getOrDefault(currentCard, 0) == 0) {
                    return false; 
                }
                cardCount.put(currentCard, cardCount.get(currentCard) - 1); // Use this card in the group
            }
        }
        
        return true; 
    }
}