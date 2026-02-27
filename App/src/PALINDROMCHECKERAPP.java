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

    // UC-3: Palindrome check using String reverse
    public static boolean isPalindromeUC3(String str) {
        String reverse = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reverse += str.charAt(i);
        }
        return str.equals(reverse);
    }

    // UC-4: Character array based palindrome check
    public static boolean isPalindromeUC4(String str) {
        char[] chars = str.toCharArray();
        int start = 0, end = chars.length - 1;

        while (start < end) {
            if (chars[start] != chars[end])
                return false;
            start++;
            end--;
        }
        return true;
    }

    // UC-6: Queue + Stack palindrome check
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

        System.out.println("\nUC-1: " + (isPalindromeUC1(input) ? "Palindrome" : "Not a Palindrome"));
        System.out.println("UC-2: " + (isPalindromeUC2(input) ? "Palindrome" : "Not a Palindrome"));
        System.out.println("UC-3: " + (isPalindromeUC3(input) ? "Palindrome (Reverse)" : "Not a Palindrome"));
        System.out.println("UC-4: " + (isPalindromeUC4(input) ? "Palindrome (char[])" : "Not a Palindrome"));
        System.out.println("UC-6: " + (isPalindromeUC6(input) ? "Palindrome (Queue + Stack)" : "Not a Palindrome"));

        sc.close();
    }
}