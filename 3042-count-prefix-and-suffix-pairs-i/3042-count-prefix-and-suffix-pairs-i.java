class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int n = words.length;
	int ct = 0;
	for(int i=0; i<n; i++){
		for(int j=i+1; j<n; j++) {
			int ilen = words[i].length(), jlen = words[j].length();

			if(ilen <= jlen) {
				boolean prefixFlag = words[j].substring(0, ilen).equals(words[i]);
				boolean postfixFlag = words[j].substring(jlen-ilen).equals(words[i]);
				if(prefixFlag && postfixFlag){
					ct++;
				}
			}
		}
	}
	return ct;
    }
}