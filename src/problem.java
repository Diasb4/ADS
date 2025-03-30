import java.util.Scanner;

public class problem {
    public static double findAvg(int[] arr) {
                int sum = 0;
                for (int num : arr) {
                    sum += num;
                }
                return (double) sum / arr.length;

    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scr.nextInt();
        }
        System.out.println(findAvg(arr));
    }
}
