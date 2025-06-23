import java.util.*;

class Q174_GFG {
    String minSum(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length, carry = 0;
        StringBuilder ans = new StringBuilder();

        for (int i = n - 1; i >= 0; i -= 2) {
            int a = arr[i];
            int b = (i > 0) ? arr[i - 1] : 0;
            int sum = a + b + carry;
            int ld = sum % 10;
            carry = sum / 10;
            ans.append(ld);
        }

        if (carry != 0) {
            ans.append(carry);
        }

        // Remove trailing zeroes
        while (ans.length() > 1 && ans.charAt(ans.length() - 1) == '0') {
            ans.deleteCharAt(ans.length() - 1);
        }

        return ans.reverse().toString();
    }
}
