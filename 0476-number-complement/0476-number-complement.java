class Solution {
    public int findComplement(int num) {
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