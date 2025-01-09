class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;
    int count;

    TrieNode() {
        children = new TrieNode[26];
        isEndOfWord = false;
        count = 0;
    }
}

class Trie {
    TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    void insert(String word) {
        TrieNode pCrawl = root;
        for(char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if(pCrawl.children[idx] == null) {
                pCrawl.children[idx] = new TrieNode();
            }
            pCrawl = pCrawl.children[idx];
            pCrawl.count++;
        }
        pCrawl.isEndOfWord = true;
    }

    int searchPrefixCount(String pref) {
        TrieNode pCrawl = root;
        for(char ch : pref.toCharArray()) {
            int idx = ch - 'a';
            if(pCrawl.children[idx] == null) {
                return 0;
            }
            pCrawl = pCrawl.children[idx];
        }

        return pCrawl.count;
    }
}


class Solution {
    public int prefixCount(String[] words, String pref) {
        Trie trie = new Trie();

        for(String word : words) {
            trie.insert(word);
        }

        return trie.searchPrefixCount(pref);
    }
}