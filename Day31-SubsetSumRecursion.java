import java.util.*;

class Main {
    public static boolean checkSubset(int a[], int n, int target) { // O(2^n)
        // Base cases
        if (target == 0)
            return true;
        if (n == 0)
            return false;
        if (a[n - 1] > target) // if the element selected at n -1 and it is > then ignore
            checkSubset(a, n - 1, target);
        boolean result = checkSubset(a, n - 1, target) || checkSubset(a, n - 1, target - a[n - 1]);
        return result;

    }


    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();

        }
        int target = sc.nextInt();
        if (checkSubset(a, n, target))
            System.out.print("Yes");
        else
            System.out.print("No");
    }
}


//using DP

import java.util.*;

class Main {
    public static int checkSubset(int a[], int n, int target) { //Top down DP

        int table[][] = new int[n + 1][target + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                table[i][j] = -1;
            }
        }

        // Base cases
        if (target == 0)
            return 1;
        if (n == 0)
            return 0;
        if (table[n - 1][target] != -1)
            return table[n - 1][target];


        if (a[n - 1] > target) // if the element selected at n -1 and it is > then ignore
            return table[n - 1][target] = checkSubset(a, n - 1, target);
        if (checkSubset(a, n - 1, target) != 0 || checkSubset(a, n - 1, target - a[n - 1]) != 0)
            return table[n - 1][target] = 1;
        else
            return table[n - 1][target] = 0;



    }


    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();

        }
        int target = sc.nextInt();
        if (checkSubset(a, n, target) != 0)
            System.out.print("Yes");
        else
            System.out.print("No");
    }
}

//Altered
import java.util.*;

class Main {
    public static int checkSubset(int a[], int n, int target) { //Top down DP

        int table[][] = new int[n + 1][target + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                table[i][j] = -1;
            }
        }

        // Base cases
        if (target == 0)
            return 1;
        if (n <= 0)
            return 0;
        if (table[n - 1][target] != -1)
            return table[n - 1][target];


        if (a[n - 1] > target) // if the element selected at n -1 and it is > then ignore
            return table[n - 1][target] = checkSubset(a, n - 1, target);
        else {
            if (checkSubset(a, n - 1, target) != 0 || checkSubset(a, n - 1, target - a[n - 1]) != 0)
                return table[n - 1][target] = 1;
            else
                return table[n - 1][target] = 0;


        }
    }


    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();

        }
        int target = sc.nextInt();
        if (checkSubset(a, n, target) != 0)
            System.out.print("Yes");
        else
            System.out.print("No");
    }
}


//Bottom up DP approach

import java.util.*;
class Main { // Bottom up DP

    public static int Catalan(int n) {
        int table[] = new int[n + 1]; // to store the result of sub problem
        table[0] = 1;
        table[1] = 1;
        for (int i = 2; i <= n; i++) { // n
            for (int j = 0; j < i; j++) {
                table[i] = table[i] + (table[j] * table[i - j - 1]); // 2
            }
        }
        return table[n];
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(Catalan(n));
    }
}

//Top down

import java.util.*;
class Main { // Top down Recursion ( Top down DP (memoization))

    public static int Catalan(int n) {
        int table[] = new int[n + 2];
        for (int i = 0; i < n + 2; i++) {
            table[i] = -1;
        }

        int result = 0;
        if (n == 0 || n == 1) { // base condition
            return table[n] = 1;

        }
        if (table[n] != -1)
            return table[n];
        // backtracking logic
        for (int i = 0; i < n; i++) {
            result = result + (Catalan(i) * Catalan(n - i - 1));
            table[n] = result;
        }
        return table[n] = result;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(Catalan(n));
    }
}