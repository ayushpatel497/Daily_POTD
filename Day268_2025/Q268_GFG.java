import java.util.*;

class Q268_GFG {
    public ArrayList<String> generateBinary(int n) {
        ArrayList<String> res = new ArrayList<>();
        Queue<String> q = new LinkedList<>();

        q.add("1");

        while (n-- > 0) {
            String s1 = q.poll();
            res.add(s1);

            q.add(s1 + "0");
            q.add(s1 + "1");
        }

        return res;
    }
}
