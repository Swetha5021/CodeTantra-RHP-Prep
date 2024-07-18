// . Straight coding to game theory problem
// 2. Dynamic programming with game theory
// Problems based on game theory:
// Problem statement:
// 1. Two players are playing the game Ram and Sham
// 2. Ram can remove non zero elements from the array those are multiples of 3.
// 3. Sham can remove non zero elements from the array those are multiples of 5.
// 4. Always Ram will start game.

// Int a[] : { 1, 2,3, 5, 6}

// Approach:
// Count: RemoveA, RemoveB, RemoveBoth



// Step 1: if RemoveBoth == 0
// Both players can remove only elements those are multiple of 3/5 and if
// RemoveA > RemoveB then I can say that A will win the game
// Step 2: if RemoveBoth > 0
// Then A will remove all the elements that are divisible by both 3 and 5, it means that
// B is left with no elements to remove from the commons then obvious A is the winner if and only if
// RemoveA + 1 > RemoveB
// 15, 30, 3, 5, 10

// Solution
import java.util.*;
class Main {

    public static void solutionWinner(int a[], int n) {

        int removeA = 0;
        int removeB = 0;
        int removeBoth = 0;
        // trace whole array
        for (int i = 0; i < n; i++) {
            if (a[i] % 3 == 0 && a[i] % 5 == 0) {
                removeBoth++;
            } else if (a[i] % 3 == 0) {
                removeA++;
            } else if (a[i] % 5 == 0) {
                removeB++;
            }
        } // for closed
        // First winning state of A
        if (removeBoth == 0) {
            if (removeA > removeB) {
                System.out.print(" Ram is the winner");
            } else {
                System.out.print(" Sham is the winner");
            }
        } // if closed
        else {
            if (removeA + 1 > removeB) {
                System.out.print(" Ram is the winner");
            } else {
                System.out.print(" Sham is the winner");
            }
        }
    }

    public static void main(String args[]) { // n + nlogn ---> O(nlogn)
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // no of jobs
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        // do the sorting ascending order according to the end time n logn
        //HashSet<Integer> set = new HashSet<>();

        solutionWinner(a, n); //n
        sc.close();

    }
}