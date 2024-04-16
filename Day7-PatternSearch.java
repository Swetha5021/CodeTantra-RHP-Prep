/*
Find the indices of the pattern in the given string
Approach 1: Naive/Brute Force
input:
abababababa 
aba
output:
0 2 4 6 8
*/

import java.util.*;
    class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        char[] str = s.nextLine().toCharArray();
        char[] pattern = s.nextLine().toCharArray();
        int k = pattern.length;
        for(int i = 0;i <= str.length-k;i++) {
            int j=0;
            while(j < k && str[i+j] == pattern[j]) {
                j++;
            }
            if(j == k) {
                System.out.print(i+" ");
            }
        }
        s.close();
    }
}