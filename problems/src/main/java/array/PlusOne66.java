package array;

public class PlusOne66 {
    public static void main(String[] args) {
        PlusOne66 plusOne = new PlusOne66();
        int digits[] = {9,9};
        plusOne.plusOne(digits);
    }

    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int d = digits[n - 1];
        int outputArray[] = new int[n + 1];
        int num = 0;
        if (d == 9) {
            for (int i = 0; i < n; i++) {
                num = num * 10 + digits[i];
            }
            num = num + 1;
            int i = n;
            while (num > 0 && i>=0) {
                outputArray[i--] = num % 10;
                num = num / 10;
            }
        } else {
            digits[n - 1] = digits[n - 1] + 1;
            outputArray = digits;
        }
        return outputArray;
    }
}
