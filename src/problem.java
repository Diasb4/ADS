import java.util.Scanner;
/// This class finds an average of array
///
///
///
/// Input int n and array arr
/// Output average value
public class problem {
    public static double findAvg(int[] arr) {
                int sum = 0;
                for (int num : arr) {
                    sum += num;
                }
                return (double) sum / arr.length;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(findAvg(arr));
    }
}
