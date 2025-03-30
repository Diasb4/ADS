import java.util.Scanner;

public class Main {
    public static int findMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scr.nextInt();
        }
        System.out.println(findMin(arr));
    }
}