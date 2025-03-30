import java.util.Scanner;
/// This class makes a reversed version of inputted array
///
///
/// Input array arr and int index
/// Output reversed array
public class Reverse {
    public static void reverse(int[] arr, int index) {
        if (index < 0) return;
        System.out.print(arr[index] + " ");
        reverse(arr, index - 1);
    }

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
        int index = sc.nextInt();
        int[] arr = new int[index];
        for (int i = 0; i < index; i++) {
            arr[i] = sc.nextInt();
        }
     System.out.println("Reversed array:");
        reverse(arr, arr.length - 1);
    }
}
