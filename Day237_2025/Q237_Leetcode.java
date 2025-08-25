import java.util.*;

class Q237_Leetcode {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Map<Integer, List<Integer>> map = new TreeMap<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map.computeIfAbsent(i + j, _ -> new ArrayList<>()).add(mat[i][j]);
            }
        }
        
        List<Integer> resList = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> diag = entry.getValue();
            if (entry.getKey() % 2 == 0) Collections.reverse(diag);
            resList.addAll(diag);
        }
        
        int[] res = new int[resList.size()];
        for (int i = 0; i < res.length; i++) res[i] = resList.get(i);
        return res;
    }
}
