class Trie{

    static class TrieNode{
        TrieNode []children; 
        boolean isEndOfWord;
    
    TrieNode(){
        children = new TrieNode[26];
        isEndOfWord= false;
    }
  }
   private TrieNode getNode(){
    return new TrieNode();
   }
   private TrieNode root;

   Trie(){
    root= getNode();
   }
   public void insert(String word){
    TrieNode crawler = root; 
    for(int i = 0 ; i < word.length(); i++){
        int index = word.charAt(i) - 'a';
        if(crawler.children[index] == null){
            crawler.children[index] = getNode();
        }
        crawler = crawler.children[index];
    }
    crawler.isEndOfWord = true;
   }
    

    public boolean searchPrefix(String prefix){
        TrieNode crawler = root; 
        int i = 0 ;
        for(; i < prefix.length() ; i++){
            int index = prefix.charAt(i) - 'a';
            if (crawler.children[index] == null)
                return false;

            crawler = crawler.children[index];
        }
        return i == prefix.length();
    }


}


class Solution {
    public int countPrefixSuffixPairs(String[] words) {
      
        int n = words.length;
        int count = 0;

        for (int j = 0; j < n; j++) {
            Trie prefixTrie = new Trie();
            Trie suffixTrie = new Trie();

            prefixTrie.insert(words[j]);
            String reversed = new StringBuilder(words[j]).reverse().toString();
            suffixTrie.insert(reversed);

            for (int i = 0; i < j; i++) {
                if (words[i].length() > words[j].length()) {
                    continue;
                }

                String rev = new StringBuilder(words[i]).reverse().toString();

                if (prefixTrie.searchPrefix(words[i]) && suffixTrie.searchPrefix(rev)) {
                    count++;
                }
            }
        }

        return count;
    }
}