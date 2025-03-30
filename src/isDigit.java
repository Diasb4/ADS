import java.util.Scanner;

public class isDigit {
    public static boolean isdigit(String s) {
            for (char c : s.toCharArray()) {
                if (!Character.isDigit(c)) {
                    return false;
                }
            }
            return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputString = sc.next();
        System.out.println("Is all digits: " + isdigit(inputString));
    }
}
