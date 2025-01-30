int findPeakElement(int* nums, int numsSize) {
    int left = 0, right = numsSize - 1;
    
    while (left < right) {
        int mid = left + (right - left) / 2;
        
        if (nums[mid] > nums[mid + 1]) {
            right = mid; // Peak is in the left half (including mid)
        } else {
            left = mid + 1; // Peak is in the right half
        }
    }
    
    return left; // left and right converge to the peak element
}