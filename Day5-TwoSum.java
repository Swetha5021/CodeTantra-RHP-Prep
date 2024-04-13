/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

Example 1:
Input: nums = [2,7,11,15], target = 9 Output: [0,1] Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:
Input: nums = [3,2,1,4], target = 6 Output: [1,2]
Example 3:
Input: nums = [3,3], target = 6 Output: [0,1]

Constraints:
• 2 <= nums.length <= 1000000000
• -109 <= nums[i] <= 109
• -109 <= target <= 109
• Only one valid answer exists.
 
*/

import java.util.*;
class Main {
    public static void twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    System.out.println(i + " " + j);
                }
            }
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
        arr[i] = sc.nextInt();
        twoSum(arr, n);
    }
}