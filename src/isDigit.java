import java.util.Scanner;
/// This class finds is there is a digit in a array
///
///
/// Input string s
/// Output boolean value
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
