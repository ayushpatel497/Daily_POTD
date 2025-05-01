import java.util.*;

class Q121_GFG {

    ArrayList<Integer> nthRowOfPascalTriangle(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        long prev = 1;
        res.add((int) prev);

        for (int i = 1; i < n; i++) {
            long curr = (prev * (n - i)) / i;
            res.add((int) curr);
            prev = curr;
        }

        return res;
    }
}
