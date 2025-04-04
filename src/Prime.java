import java.util.Scanner;
/// This class finds if a number is prime or not
///
///
///
/// Input int n
/// Output boolean value
public class Prime {
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt();

        System.out.println(isPrime(n));
    }
}


