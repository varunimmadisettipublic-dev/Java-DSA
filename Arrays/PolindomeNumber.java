/**
 * LeetCode 9 - Palindrome Number
 *
 * Problem:
 * Given an integer x, return true if x is a palindrome,
 * and false otherwise.
 *
 * A palindrome number reads the same backward as forward.
 *
 * Example:
 * Input: 121
 * Output: true
 *
 * Constraints:
 * - Do not convert the integer to a string.
 *
 * Approach:
 * - Negative numbers are not palindromes.
 * - Reverse only half of the number.
 * - Compare the first half and reversed half.
 *
 * Time Complexity  : O(log10(n))
 * Space Complexity : O(1)
 */

public class PalindromeNumber {

    public static boolean isPalindrome(int x) {

        // Negative numbers are not palindrome
        // Also numbers ending with 0 (except 0 itself) cannot be palindrome
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;

        // Reverse only half of the digits
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x = x / 10;
        }

        // For even length numbers:
        // x == reversedHalf
        //
        // For odd length numbers:
        // x == reversedHalf / 10 (middle digit removed)
        return (x == reversedHalf) || (x == reversedHalf / 10);
    }

    // Main method for local testing
    public static void main(String[] args) {

        int num1 = 121;
        int num2 = -121;
        int num3 = 10;

        System.out.println(num1 + " → " + isPalindrome(num1)); // true
        System.out.println(num2 + " → " + isPalindrome(num2)); // false
        System.out.println(num3 + " → " + isPalindrome(num3)); // false
    }
}
