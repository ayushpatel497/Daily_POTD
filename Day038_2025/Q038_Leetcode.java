import java.util.*;

class Q038_Leetcode {
    public int[] queryResults(int limit, int[][] queries) {
        int querySize = queries.length;
        int[] answer = new int[querySize];

        Map<Integer, Integer> colorMap = new HashMap<>(); // Stores frequency of colors
        Map<Integer, Integer> ballMap = new HashMap<>();  // Stores ball to color mapping

        for (int index = 0; index < querySize; ++index) {
            int ball = queries[index][0];
            int color = queries[index][1];

            // If the ball already exists, decrement the count of its previous color
            if (ballMap.containsKey(ball)) {
                int prevColor = ballMap.get(ball);
                colorMap.put(prevColor, colorMap.get(prevColor) - 1);
                if (colorMap.get(prevColor) == 0) {
                    colorMap.remove(prevColor);
                }
            }

            // Update the ball with the new color
            ballMap.put(ball, color);
            colorMap.put(color, colorMap.getOrDefault(color, 0) + 1);

            // Store the number of distinct colors
            answer[index] = colorMap.size();
        }

        return answer;
    }
}
