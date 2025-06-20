import java.util.Arrays;

class Q171_GFG {
    public boolean validgroup(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        boolean[] used = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (used[i]) continue;
            int count = 0;
            int curr = arr[i];

            for (int j = i; j < n; j++) {
                if (!used[j] && arr[j] == curr) {
                    used[j] = true;
                    count++;
                    curr++;
                }
                if (count == k) break;
            }

            if (count != k) return false;
        }

        return true;
    }
}
