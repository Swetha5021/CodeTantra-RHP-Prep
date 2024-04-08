import java.util.*;

public class Main {

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    char[][] arr = new char[3][n];

    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < n; j++) {
            arr[i][j] = sc.next().charAt(0);
        }
    }

    for (int i = 0; i < n; i++) {
        if (arr[0][i] == '#' && arr[1][i] == '#' && arr[2][i] == '#') {
        System.out.print('#');
        } 
        else if (arr[0][i] == '.' && arr[1][i] == '.' && arr[2][i] == '.') {
        // Do nothing for '.'
        } else {
            char a, b, c, a1, b1, c1, a2, b2, c2;

            a = arr[0][i];
            b = arr[0][i + 1];
            c = arr[0][i + 2];

            a1 = arr[1][i];
            b1 = arr[1][i + 1];
            c1 = arr[1][i + 2];

            a2 = arr[2][i];
            b2 = arr[2][i + 1];
            c2 = arr[2][i + 2];

            if (a == '.' && b == '*' && c == '.' && a1 == '*' && b1 == '*' && c1 == '*' && a2 == '*' && b2 == '.' && c2 == '*') {
            System.out.print("A");
            i += 2;
            } else if (a == '*' && b == '*' && c == '*' && a1 == '*' && b1 == '*' && c1 == '*' && a2 == '*' && b2 == '*' && c2 == '*') {
            System.out.print("E");
            i += 2;
            } else if (a == '*' && b == '*' && c == '*' && a1 == '.' && b1 == '*' && c1 == '.' && a2 == '*' && b2 == '*' && c2 == '*') {
            System.out.print("I");
            i += 2;
            } else if (a == '*' && b == '*' && c == '*' && a1 == '*' && b1 == '.' && c1 == '*' && a2 == '*' && b2 == '*' && c2 == '*') {
            System.out.print("O");
            i += 2;
            } else {
            System.out.print("U");
            i += 2;
            }
        }
    }
  }
}