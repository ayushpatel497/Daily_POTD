import java.util.*;

class Q229_GFG {
    public void rearrange(int[] arr, int x) {
        Arrays.sort(arr, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return Math.abs(a - x) - Math.abs(b - x);
            }
        });
    }
}
