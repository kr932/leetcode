class Solution {
    public int sumFourDivisors(int[] nums) {
        int totalSum = 0;
        
        for (int num : nums) {
            int sum = sumIfFourDivisors(num);
            totalSum += sum;
        }
        
        return totalSum;
    }
    
    private int sumIfFourDivisors(int n) {
        int count = 0;
        int sum = 0;
        
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                int other = n / i;
                if (i == other) {
                    count++; 
                    sum += i;
                } else {
                    count += 2;
                    sum += i + other;
                }
                
                if (count > 4) return 0; // early exit, not valid
            }
        }
        
        return count == 4 ? sum : 0;
    }
}
