class Solution {
    public int maximumPrimeDifference(int[] nums) {
        
           int i=0, j=nums.length - 1;

        while(i < j) {
            if(isPrime(nums[i]) && isPrime(nums[j])) {
                return j-i;
            } 
            else if(isPrime(nums[i]) && !isPrime(nums[j])) {
                j--;
            } else if(!isPrime(nums[i]) && isPrime(nums[j])) {
                i++;
            } else {
                i++;
                j--;
            }
        }
        return 0;
    }
      public static boolean isPrime(int n) {
        if (n <= 1) {
            return false; // 0 and 1 are not prime numbers
        }
        if (n <= 3) {
            return true; // 2 and 3 are prime numbers
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false; // numbers divisible by 2 or 3 are not prime
        }
        // Check for prime using 6k +/- 1 rule
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }
}