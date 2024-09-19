class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        return solve(expression);
    }
    public List<Integer> solve(String s) {
        List<Integer> result = new ArrayList<>();
        for(int i =0 ;i < s.length(); i++){
            char curr = s.charAt(i);
            if(curr == '+'|| curr == '-'  ||curr == '*' ){
                List<Integer> leftResults = solve(s.substring(0, i));
                List<Integer> rightResults = solve(s.substring(i + 1));
                for(int x : leftResults){
                    for(int y : rightResults){
                        if(curr == '+'){
                            result.add(x + y);
                        }else  if(curr == '-'){
                            result.add(x - y);
                        }else  if(curr == '*'){
                            result.add(x * y);
                        }
                    }
                }
            }
        }
        if(result.isEmpty()){
            result.add(Integer.parseInt(s));
        }
        return result;
    }
}