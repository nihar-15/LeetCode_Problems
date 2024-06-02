class Solution {
    public int minimumChairs(String s) {
        int res = 0, ct=0;
	for(char ch : s.toCharArray()){
		if(ch == 'E') ct++;
		else ct--;

		res = Math.max(res, ct);
	}
	return res;
    }
}