/*
Problem: Two Sum
Platform: LeetCode
Approach: One-pass HashMap
Time Complexity: O(n)
Space Complexity: O(n)

----------------------------------------------------
Explanation:

We are given an array of integers and a target value.
We need to return the indices of two numbers such that:

    nums[i] + nums[j] = target

Optimized Approach:
Instead of using two nested loops (O(n^2)),
we use a HashMap to store numbers and their indices.

For each element:
1. Compute complement = target - current element
2. Check if complement already exists in HashMap
3. If yes → return stored index and current index
4. If not → store current number and index in map

This gives O(n) time complexity.
----------------------------------------------------
*/

import java.util.HashMap;

class Solution {

    public int[] twoSum(int[] nums, int target) {

        // HashMap to store number as key and its index as value
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];

            // Check if complement exists in map
            if (map.containsKey(complement)) {

                // If found, return indices
                return new int[] { map.get(complement), i };
            }

            // Store current number and its index
            map.put(nums[i], i);
        }

        // Return empty array (though problem guarantees one solution)
        return new int[] {};
    }
}
