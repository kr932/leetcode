import java.util.*;

public class Solution {
    static final int MOD = 1_000_000_007;

    public int idealArrays(int n, int maxValue) {
        int maxK = 14; // since 2^14 > 10000, longest chain length possible

        // Step 1: Precompute combinations C[n][k] up to n = 10000
        long[][] comb = new long[n + 1][maxK + 1];
        for (int i = 0; i <= n; i++) {
            comb[i][0] = 1;
            for (int j = 1; j <= Math.min(i, maxK); j++) {
                comb[i][j] = (comb[i - 1][j - 1] + comb[i - 1][j]) % MOD;
            }
        }

        // Step 2: dp[val][len] = number of divisor chains of length len ending at val
        long[][] dp = new long[maxValue + 1][maxK + 1];
        for (int i = 1; i <= maxValue; i++) dp[i][1] = 1; // base: chain of length 1

        for (int len = 2; len <= maxK; len++) {
            for (int val = 1; val <= maxValue; val++) {
                for (int mult = 2 * val; mult <= maxValue; mult += val) {
                    dp[mult][len] = (dp[mult][len] + dp[val][len - 1]) % MOD;
                }
            }
        }

        // Step 3: Combine chain counts with combinations
        long ans = 0;
        for (int val = 1; val <= maxValue; val++) {
            for (int len = 1; len <= maxK; len++) {
                ans = (ans + dp[val][len] * comb[n - 1][len - 1]) % MOD;
            }
        }

        return (int) ans;
    }

    // Optional: local test
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.idealArrays(2, 5)); // Output: 10
        System.out.println(sol.idealArrays(5, 3)); // Output: 11
    }
}
