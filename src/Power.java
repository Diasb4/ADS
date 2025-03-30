import java.util.Scanner;
/// This class finds a n'th term of number a
///
///
///
/// Input int a and int n
/// Output n'th term of a
public class Power {
    public static long power(int a, int n) {
        if (n == 0) return 1;
        return a * power(a, n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int n = sc.nextInt();
        System.out.println(power(a, n));
    }
}
