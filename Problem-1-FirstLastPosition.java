/*
 * Finds the first and last position of a target value in a sorted array.
 * 1. Perform binary search to find the first (leftmost) occurrence of the target.
 *    - If found, store index and continue search to the left.
 * 2. Perform another binary search to find the last (rightmost) occurrence.
 *    - If found, store index and continue search to the right.
 * 3. If the target is not found in either search, return [-1, -1].
 */

// Time Complexity : O(log n) - two Binary searches of O(log n) equates to this
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1}; // Default result if target is not found

        // Edge case: empty array
        if (nums.length == 0)
            return res;

        int l = 0;
        int r = nums.length - 1;

        // First binary search to find the leftmost (starting) index of target
        while (r >= l) {
            int mid = (l + r) / 2;

            // If target found, store index and keep searching left
            if (nums[mid] == target) {
                res[0] = mid;
                r = mid - 1;
            }

            // If target is greater, move right
            if (target > nums[mid])
                l = mid + 1;
            // If target is smaller, move left
            else if (nums[mid] > target)
                r = mid - 1;
        }

        // Reset pointers for second search
        l = 0;
        r = nums.length - 1;

        // Second binary search to find the rightmost (ending) index of target
        while (r >= l) {
            int mid = (l + r) / 2;

            // If target found, store index and keep searching right
            if (nums[mid] == target) {
                res[1] = mid;
                l = mid + 1;
            }

            // If target is greater, move right
            if (target > nums[mid])
                l = mid + 1;
            // If target is smaller, move left
            else if (nums[mid] > target)
                r = mid - 1;
        }

        // Return the first and last position of target
        return res;
    }
}
