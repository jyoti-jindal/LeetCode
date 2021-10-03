package problems.string.easy;

/**
 * <a href="https://leetcode.com/problems/reverse-string/">344. Reverse String</a>
 *
 * <b>Write a function that reverses a string. The input string is given as an array of characters s.
 * </b>
 * Example 1:
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * <p>
 * Example 2:
 * Input: s = ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 * <p>
 * Constraints:
 * 1 <= s.length <= 105
 * s[i] is a printable ascii character.
 * <p>
 * Follow up: Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 */
public class ReverseString {
    public static void main(String[] args) {
        char ch[] = {'h', 'e', 'l', 'l', 'o'};
        reverseStringApproach1(ch);
        for (char c : ch) {
            System.out.print(c + " ");
        }
    }

    /**
     * Approach: Two Pointer Approach
     * TC: O(N)
     * SC: O(1)
     *
     * @param s
     */
    public static void reverseStringApproach1(char[] s) {
        int start = 0, end = s.length - 1;
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * Approach: Recursion
     * TC: O(N), Total functions in Call Stack
     * SC: O(N), Auxilary space for active functions in Call Stack
     *
     * @param s
     */
    public void reverseString(char[] s) {
        reverseString(s, 0, s.length - 1);
    }

    public void reverseString(char[] s, int start, int end) {
        if (start >= end) return;
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;
        reverseString(s, start + 1, end - 1);
    }
}