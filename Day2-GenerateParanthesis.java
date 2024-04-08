/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
Example 1:
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:
Input: n = 1
Output: ["()"]
Constraints:

1 <= n <= 8
 
*/

import java.util.*;

public class Main {

    static List<String> arr = new ArrayList<>();

    static void recursion(String s, int lc, int rc, int l) {
        if (rc == 0 && lc == l) {
            arr.add(s);
        }
        if (lc < l) {
            recursion(s + '(', lc + 1, rc + 1, l);
        }
        if (rc > 0) {
            recursion(s + ')', lc, rc - 1, l);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        recursion("", 0, 0, n);
        System.out.println(arr);
    }
}
