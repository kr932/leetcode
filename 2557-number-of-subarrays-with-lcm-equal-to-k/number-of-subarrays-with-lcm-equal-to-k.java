class Solution {
    public int subarrayLCM(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int lcm = nums[i];
            if (lcm == k) count++;  // Single element match

            for (int j = i + 1; j < n; j++) {
                lcm = lcm(lcm, nums[j]);
                if (lcm > k) break; // No point in continuing
                if (lcm == k) count++;
            }
        }

        return count;
    }

    // Helper function to compute GCD
    private int gcd(int a, int b) {
        while (b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }

    // Helper function to compute LCM
    private int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }
}
