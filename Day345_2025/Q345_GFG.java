import java.util.ArrayList;

class Q345_GFG {
    public ArrayList<Integer> constructArr(int[] arr) {

        int n = (int)(Math.sqrt(arr.length * 2)) + 1;
        ArrayList<Integer> res = new ArrayList<>(n);

        int a0 = (arr[0] + arr[1] - arr[n - 1]) / 2;
        res.add(a0);

        for (int i = 1; i < n; i++) {
            res.add(arr[i - 1] - a0);
        }

        return res;
    }
}
