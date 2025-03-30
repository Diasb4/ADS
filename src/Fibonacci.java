import java.util.Scanner;
/// This class finds a n'th term of fibonacci series
///
///
///
/// Input int n
/// Output n'th term of fibonacci series
public class Fibonacci {
    public static long fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        else return fibonacci(n - 1) + fibonacci(n - 2);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(fibonacci(n));
    }


}