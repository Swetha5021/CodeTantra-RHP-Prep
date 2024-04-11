/*

Given an integer array, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
Note that you must do this in-place without making a copy of the array.

Example 1:
Input: nums = [0,1,0,3,12] Output: [1,3,12,0,0]

Example 2:
Input: nums = [0] Output: [0]

Constraints:
• 1 <= nums.length <= 104
• -231 <= nums[i] <= 231 – 1 // signed integer

*/

import java.util.*;
class Main {

    // 2 pointer
    public static void moveZero( int nums[], int n) {
        int left = 0;
        int right =0;
        while(right < n) { // n --- > O(n)
            if(nums[right]!=0 && nums[left]==0) {
                nums[left] = nums[left]^ nums[right];
                nums[right] = nums[left]^ nums[right];
                nums[left] = nums[left] ^ nums[right];
                left++;
        }
        right++;
        } 
    }

    // O(n^2)
    public static void moveZero( int nums[], int n) {
            // Greedy approach i.e. sorting
            for( int i = 0 ; i< n ; i++) {// customized bubble n
                for( int j=0 ; j <n-i-1 ; j++) { // n
                    if(nums[j]==0) {
                        int temp = nums[j];
                        nums[j]=nums[j+1];
                        nums[j+1] = temp;
                }
            }
        }

    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int a[]= new int[n];
        for( int i=0 ; i< n; i++)
        a[i]= s.nextInt();
        for(int i=0 ; i< n ; i++)
        System.out.print(a[i]+" ");
        moveZero(a, n);
        System.out.print("\n");
        for(int i=0 ; i< n ; i++)
        System.out.print(a[i]+" ");

    }
}
