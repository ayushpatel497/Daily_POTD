import java.util.Arrays;

class Q194_Leetcode
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int m = players.length, n = trainers.length;
        int count = 0;

        for (int i = 0, j = 0; i < m && j < n; i++, j++) {
            while (j < n && players[i] > trainers[j]) {
                j++;
            }
            if (j < n) {
                count++;
            }
        }

        return count;
    }
}
