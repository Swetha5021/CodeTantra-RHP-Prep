/*
find the maximum subarray sum with size k
Approach: Sliding Window
input:
7
1 2 3 -2 3 4 5
3
output:
12 
*/
import java.util.*;
public class Main
{
    public static int maxSumSlidingWindow(int arr[], int n, int k)
    {
        int i, maxSum = Integer.MIN_VALUE;
        for(i=0;i<k;i++)
        maxSum += arr[i];
        int windowSum = maxSum;
        for(i=k;i<n;i++) {
        windowSum += arr[i] - arr[i-k];
        maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
        arr[i] = sc.nextInt();
        int k = sc.nextInt();
        System.out.print(maxSumSlidingWindow(arr, n, k));
    }
}