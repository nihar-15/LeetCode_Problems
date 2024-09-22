class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<String> a = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        for(int i =1 ; i <= n; i++){
           a.add(Integer.toString(i));
        }
        Collections.sort(a);
        for(String num : a){
            ans.add(Integer.parseInt(num));
        }
  return ans;
    }
}