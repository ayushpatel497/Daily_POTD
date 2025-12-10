import java.util.*;

class Q344_GFG {
    ArrayList<Integer> findTwoElement(int arr[]) {
        int n = arr.length;

        int[] freq = new int[n];
        int rep = -1, miss = -1;

        for (int x : arr) {
            freq[x - 1]++;
        }

        for (int i = 0; i < n; i++) {
            if (freq[i] == 0) miss = i + 1;
            else if (freq[i] == 2) rep = i + 1;
        }

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(rep);
        ans.add(miss);
        return ans;
    }
}
