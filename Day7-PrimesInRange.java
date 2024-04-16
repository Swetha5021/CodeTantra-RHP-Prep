/*
Print the prime numbers in range
Optimized Approach
Approach: Seive of Erasthothenes
Time complexity: O(N * log(log(N))) 
*/

//-2, -3, 4, -1, -2, 1, 5, -3
import java.util.*;
class Main {
    // Prime numbers in logn time
    public static void sieveMethod( int n) {
        boolean table[] = new boolean[n+1];
        for( int i = 0; i<=n ; i++) { // All true values//n
            table[i]= true;// Arrays.fill
        }
        for( int i=2; i * i <=n ; i++) {// exclusion
        if(table[i]== true) {
            for( int j= i * i ; j<=n ; j= j+i) {
                table[j]=false;
            }
        }
        }
        for( int i = 2; i<=n ; i++)
            if(table[i]==true)
                System.out.print(i+" ");
    }

    public static void main( String args[]) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    sieveMethod(n);
    }
}