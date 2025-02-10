import java.util.HashMap;

class Q041_GFG {
    private void recursion(Node root, int k, int sum, HashMap<Integer, Integer> map, int[] answer) {
        if (root == null)
            return;

        sum += root.data;
        answer[0] += map.getOrDefault(sum - k, 0);
        map.put(sum, map.getOrDefault(sum, 0) + 1);

        recursion(root.left, k, sum, map, answer);
        recursion(root.right, k, sum, map, answer);

        map.put(sum, map.get(sum) - 1);
        if (map.get(sum) == 0) 
            map.remove(sum);
    }

    public int sumK(Node root, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int[] answer = {0};
        recursion(root, k, 0, map, answer);
        return answer[0];
    }
}
