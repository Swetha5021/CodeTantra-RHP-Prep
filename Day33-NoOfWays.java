import java.util.*;
class Main {

    public static int noOfWays(int a[][], int n, int i, HashSet < Integer > set) {
        // Base
        if (i == n)
            return 1;
        int counter = 0;
        for (int j = 0; j < n; j++) {

            if (a[i][j] == 1 && !set.contains(j)) {
                set.add(j);
                counter = counter + noOfWays(a, n, i + 1, set);
                // bactracking
                set.remove(j);
            }

        }
        return counter;

    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // no nodes / vertices
        int a[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        HashSet < Integer > set = new HashSet < > ();
        System.out.print(noOfWays(a, n, 0, set));
        sc.close();

    }
}

//recursive
Count ways to select N pair of distinct balls of distinct colors
Test
case :
N = 3
Matrix[3][3] = {
    {
        0,
        1,
        1
    },
    {
        1,
        0,
        1
    },
    {
        1,
        1,
        1
    }
}


Recursive logic(N!)
import java.util.*;
class Main {

    public static int noOfWays(int a[][], int n, int i, HashSet < Integer > set) {
        // Base
        if (i == n)
            return 1;
        int counter = 0;
        for (int j = 0; j < n; j++) {

            if (a[i][j] == 1 && !set.contains(j)) {
                set.add(j);
                counter = counter + noOfWays(a, n, i + 1, set);
                // bactracking
                set.remove(j);
            }

        }
        return counter;

    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // no nodes / vertices
        int a[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        HashSet < Integer > set = new HashSet < > ();
        System.out.print(noOfWays(a, n, 0, set));
        sc.close();

    }
}

//other approach
import java.util.*;
class Main {

    public static int noOfWays(int a[][], int n) {
        // every entry in table[i][j] this table represents
        // count of ways to make pairs between i red balls and n blue balls
        int table[][] = new int[n + 1][1 << n];

        table[0][0] = 1; // their is no red and no blue ball, count of ways to make n pair is 1
        // outer loop i represents red balls
        for (int i = 0; i < n; i++) {
            // j ideally generates a permutation of blue ball 0 selected 1 not selected
            for (int j = 0; j < 1 << n; j++) {

                // iterate on the range 0 to n
                for (int k = 0; k < n; k++) {
                    // Creating a mask with the k bit as a set bit
                    int mask = 1 << k; // 10
                    // if the kth bit of the mask is not set and a[i][k] is 1
                    if ((mask & j) == 0 && a[i][k] == 1) { // 010 | 000 = 010
                        table[i + 1][j | mask] = table[i + 1][j | mask] + table[i][j];
                        System.out.print(table[i + 1][j | mask] + " ");

                    }
                }

            }

        }
        System.out.println();
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 1 << n; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }

        return table[n][(1 << n) - 1];
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // no nodes / vertices
        int a[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        //HashSet<Integer> set = new HashSet<>();
        System.out.print(noOfWays(a, n));
        sc.close();

    }
}