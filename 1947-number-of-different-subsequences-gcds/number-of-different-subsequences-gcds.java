import java.util.*;

public class Solution {
    public int countDifferentSubsequenceGCDs(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        boolean[] present = new boolean[max + 1];
        for (int num : nums) {
            present[num] = true;
        }

        int count = 0;

        // For every possible GCD value g
        for (int g = 1; g <= max; g++) {
            int currentGCD = 0;

            // Check all multiples of g
            for (int multiple = g; multiple <= max; multiple += g) {
                if (present[multiple]) {
                    currentGCD = gcd(currentGCD, multiple);
                    if (currentGCD == g) {
                        count++;
                        break; // No need to check further multiples
                    }
                }
            }
        }

        return count;
    }

    // Helper function to compute GCD
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // Optional: local testing (not used in LeetCode)
    public static void main(String[] args) {
        Solution solver = new Solution();

        int[] nums1 = {6, 10, 3};
        System.out.println(solver.countDifferentSubsequenceGCDs(nums1)); // Output: 5

        int[] nums2 = {5, 15, 40, 5, 6};
        System.out.println(solver.countDifferentSubsequenceGCDs(nums2)); // Output: 7
    }
}
