import java.util.Scanner;

public class PALINDROMCHECKERAPP {

    // UC-1: Palindrome check (case-sensitive, spaces included)
    public static boolean isPalindromeUC1(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // UC-2: Case-insensitive palindrome check
    public static boolean isPalindromeUC2(String str) {
        str = str.toLowerCase();

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Palindrome Checker App ===");
        System.out.print("Enter a word or phrase: ");
        String input = scanner.nextLine();

        System.out.println("\nUC-1 Result:");
        if (isPalindromeUC1(input)) {
            System.out.println("Palindrome (case-sensitive)");
        } else {
            System.out.println("Not a Palindrome (case-sensitive)");
        }

        System.out.println("\nUC-2 Result:");
        if (isPalindromeUC2(input)) {
            System.out.println("Palindrome (case-insensitive)");
        } else {
            System.out.println("Not a Palindrome (case-insensitive)");
        }

        scanner.close();
    }
}