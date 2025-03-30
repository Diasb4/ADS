import java.util.Scanner;
public class Fibonacci {
    public static long Fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        else return Fibonacci(n - 1) + Fibonacci(n - 2);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(Fibonacci(n));
    }


}