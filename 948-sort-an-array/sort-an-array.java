class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(nums, n, i);
        }

        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;

            // Call heapify on the reduced heap
            heapify(nums, i, 0);
        }

        return nums;
    }

    // Heapify a subtree rooted at index i
    private void heapify(int[] nums, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // left child
        int right = 2 * i + 2; // right child

        // If left child is larger than root
        if (left < n && nums[left] > nums[largest]) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && nums[right] > nums[largest]) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            int swap = nums[i];
            nums[i] = nums[largest];
            nums[largest] = swap;

            // Recursively heapify the affected subtree
            heapify(nums, n, largest);
        }
    }

    // For local testing
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] nums1 = {5, 2, 3, 1};
        int[] nums2 = {5, 1, 1, 2, 0, 0};

        nums1 = s.sortArray(nums1);
        nums2 = s.sortArray(nums2);

        System.out.println(java.util.Arrays.toString(nums1)); // [1, 2, 3, 5]
        System.out.println(java.util.Arrays.toString(nums2)); // [0, 0, 1, 1, 2, 5]
    }
}
