// Problem:
// Swapping the odd bits with even bits:
// Int a = 10
// 4 bytes: 32 bits
// 3 bits: 2 ^ 3 - 1 = 7
// 4 bits: 2 ^ 4 - 1 = 15


import java.util.*;

class Main {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 6 00000000000000000000000000000110
        int evenBits = n & 0xAAAAAAAA; // 10101010101010101010101010101010
        // 00000000000000000000000000000010
        int oddBits = n & 0x55555555; // 01010101010101010101010101010101
        // 00000000000000000000000000000100
        int x = evenBits >> 1; // 00000000000000000000000000000001
        int y = oddBits << 1; // 00000000000000000000000000001000

        System.out.println(x | y); // 00000000000000000000000000001001--> 9

        sc.close();

    }



}