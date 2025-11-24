import java.util.ArrayList;
import java.util.List;

class Q328_Leetcode {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> answer = new ArrayList<>();
        int prefix = 0;

        for (int bit : nums) {
            prefix = ((prefix << 1) + bit) % 5;
            answer.add(prefix == 0);
        }

        return answer;
    }
}
