import java.util.Scanner;
/// This class finds a binomial coefficient
///
///
///
/// Input int n
/// Output Coefficient of binomial
public class Binomial {
    public static long binomialCoefficient(int n, int k) {
        if (k == 0 || k == n) return 1;
        return binomialCoefficient(n - 1, k - 1) + binomialCoefficient(n - 1, k);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(binomialCoefficient(n, k));
    }
}
