class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;

        for (int num : nums) {
            // first appearance: add to ones
            // second appearance: remove from ones, add to twos
            // third appearance: remove from twos
            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }

        // 'ones' holds the single unique number
        return ones;
    }
}
