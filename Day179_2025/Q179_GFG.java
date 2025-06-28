import java.util.*;

class Q179_GFG {
    public static ArrayList<Integer> countLessEq(int[] a, int[] b) {
        Arrays.sort(b);
        ArrayList<Integer> ans = new ArrayList<>();

        for (int num : a) {
            int start = 0, end = b.length - 1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (b[mid] <= num) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            ans.add(end + 1); // Because indices start at 0
        }

        return ans;
    }
}
