class Trie {

    static class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        TrieNode() {
            children = new TrieNode[26];
            isEndOfWord = false;
        }
    }

    private TrieNode getNode() {
        return new TrieNode();
    }

    private TrieNode root;

    Trie() {
        root = getNode();
    }

    public void insert(String word) {
        TrieNode crawler = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (crawler.children[index] == null) {
                crawler.children[index] = getNode();
            }
            crawler = crawler.children[index];
        }
        crawler.isEndOfWord = true;
    }

    public boolean startsWith(String prefix) {
        TrieNode crawler = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (crawler.children[index] == null)
                return false;

            crawler = crawler.children[index];
        }
        return true;
    }
}

class Solution {
    public int prefixCount(String[] words, String pref) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        int count = 0;
        for (String word : words) {
            if (word.startsWith(pref)) {
                count++;
            }
        }
        return count;
    }
}
