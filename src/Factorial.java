import java.util.Scanner;
/// This class finds a n'th term of factorial
///
///
///
/// Input int n
/// Output n'th term of factorial
public class Factorial {
    public static long factorial(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt();

        System.out.println(factorial(n));
    }
}
