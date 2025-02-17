class Solution {
    public static void perm(HashSet<String> s,String permutation,String str,int r){
        if (permutation.length()==r){
           // System.out.println(permutation);
            s.add(permutation);
            return;
        }

        for (int i=0;i<str.length();i++){
            char c=str.charAt(i);
            String newstr=str.substring(0,i)+str.substring(i+1);
            perm(s,permutation+c,newstr,r);
        }
    }
    public int numTilePossibilities(String tiles) {
        HashSet<String> s= new HashSet<String>();
        for (int i=1;i<=tiles.length();i++){
            perm(s,"",tiles,i);
        }
        return s.size();
    }

}