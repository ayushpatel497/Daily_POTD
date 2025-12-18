import java.util.*;

class Solution {
    public void sortIt(int[] arr) {
        Integer[] temp = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        Arrays.sort(temp, (a, b) -> {
            if ((a & 1) == (b & 1)) {
                if ((a & 1) == 0) {
                    return a - b;      // even → ascending
                } else {
                    return b - a;      // odd → descending
                }
            }
            return (a & 1) == 1 ? -1 : 1; // odd first
        });

        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }
    }
}
