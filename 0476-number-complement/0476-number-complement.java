class Solution {
    public int findComplement(int num) {

        class Solution {
    public int findComplement(int num) {
        String str = Integer.toBinaryString(num);
        String res = "";
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == '0'){
                res += '1';
            }
            else{
                res += '0';
            }
        }
        return Integer.parseInt(res,2);
    }
}
/*
        String binaryString = getBinary(num);
        int number = Integer.parseInt(binaryString, 2);
        return number;
    }
    String getBinary(int num){
        StringBuilder sb = new StringBuilder();
        while(num > 1 ){
           int  x  = num % 2;
           x = (x == 1) ? 0 : 1;
            sb.append(Integer.toString(x));
            num = num / 2;
        }
        num = 1 - num ;
        sb.append(Integer.toString(num));
        System.out.println(sb.toString());
        return sb.reverse().toString();
    }

}

*/