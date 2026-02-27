import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class PALINDROMCHECKERAPP {

    // UC-1: Case-sensitive palindrome check
    public static boolean isPalindromeUC1(String str) {
        int left = 0, right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

    // UC-2: Case-insensitive palindrome check
    public static boolean isPalindromeUC2(String str) {
        return isPalindromeUC1(str.toLowerCase());
    }

    // UC-6: Queue + Stack palindrome check (FIFO vs LIFO)
    public static boolean isPalindromeUC6(String str) {
        str = str.replaceAll("\\s+", "").toLowerCase();

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            queue.add(ch);   // FIFO
            stack.push(ch);  // LIFO
        }

        while (!queue.isEmpty()) {
            if (!queue.remove().equals(stack.pop()))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a word or phrase: ");
        String input = sc.nextLine();

        System.out.println("\nUC-1: " +
                (isPalindromeUC1(input) ? "Palindrome" : "Not a Palindrome"));

        System.out.println("UC-2: " +
                (isPalindromeUC2(input) ? "Palindrome" : "Not a Palindrome"));

        System.out.println("UC-6: " +
                (isPalindromeUC6(input) ? "Palindrome (Queue + Stack)" : "Not a Palindrome"));

        sc.close();
    }
}