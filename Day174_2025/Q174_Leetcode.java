import java.util.ArrayList;
import java.util.List;

class Q174_Leetcode {
    private boolean isPalindromeInBaseK(long num, int k) {
        List<Integer> digits = new ArrayList<>();
        while (num > 0) {
            digits.add((int)(num % k));
            num /= k;
        }
        int i = 0, j = digits.size() - 1;
        while (i < j) {
            if (!digits.get(i).equals(digits.get(j))) return false;
            i++;
            j--;
        }
        return true;
    }

    public long kMirror(int k, int n) {
        long sum = 0;
        int count = 0;
        int left = 1;

        while (count < n) {
            int right = left * 10;
            for (int op = 0; op < 2 && count < n; op++) {
                for (int i = left; i < right && count < n; i++) {
                    long num = i;
                    int x = (op == 0 ? i / 10 : i);
                    while (x > 0) {
                        num = num * 10 + x % 10;
                        x /= 10;
                    }
                    if (isPalindromeInBaseK(num, k)) {
                        sum += num;
                        count++;
                    }
                }
            }
            left = right;
        }

        return sum;
    }
}
