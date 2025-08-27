import java.util.*;

class Q239_GFG {
    public int countTriangles(int[] arr) {
        int n = arr.length;
        int cnt = 0;
        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int pos = j;
                int l = j + 1, h = n - 1;

                while (l <= h) {
                    int m = l + (h - l) / 2;

                    if (arr[m] < arr[i] + arr[j]) {
                        pos = m;
                        l = m + 1;
                    } else {
                        h = m - 1;
                    }
                }
                cnt += pos - j;
            }
        }
        return cnt;
    }
}
