/**
 * // This is the MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation.
 * interface MountainArray {
 *     public int get(int index);
 *     public int length();
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        
        // Step 1: Find the peak index
        int peak = findPeak(mountainArr, n);
        
        // Step 2: Binary search on the increasing side
        int leftResult = binarySearchAscending(mountainArr, target, 0, peak);
        if (leftResult != -1) return leftResult;
        
        // Step 3: Binary search on the decreasing side
        return binarySearchDescending(mountainArr, target, peak + 1, n - 1);
    }
    
    // Find the peak index using binary search
    private int findPeak(MountainArray mountainArr, int n) {
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                left = mid + 1;  // still going up
            } else {
                right = mid;     // start going down
            }
        }
        return left; // peak index
    }
    
    // Binary search on ascending side
    private int binarySearchAscending(MountainArray mountainArr, int target, int left, int right) {
        while (left <= right) {
            int mid = (left + right) / 2;
            int val = mountainArr.get(mid);
            
            if (val == target) return mid;
            if (val < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    
    // Binary search on descending side
    private int binarySearchDescending(MountainArray mountainArr, int target, int left, int right) {
        while (left <= right) {
            int mid = (left + right) / 2;
            int val = mountainArr.get(mid);
            
            if (val == target) return mid;
            if (val > target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
