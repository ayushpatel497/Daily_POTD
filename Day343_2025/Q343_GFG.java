import java.util.ArrayList;

class Q343_GFG {
    public ArrayList<Integer> findDuplicates(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int idx = Math.abs(arr[i]) - 1;

            if (arr[idx] < 0) {
                ans.add(Math.abs(arr[i]));
            } else {
                arr[idx] = -arr[idx];
            }
        }

        return ans;
    }
}
