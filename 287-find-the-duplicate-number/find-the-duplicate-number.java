class Solution {
    public int findDuplicate(int[] nums) {
        // Phase 1: Find the intersection point of the two runners.
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];       // move one step
            fast = nums[nums[fast]]; // move two steps
        } while (slow != fast);

        // Phase 2: Find the entrance to the cycle.
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow; // or fast
    }
}
