class Q049_Leetcode {
    private int buildSequence(int currentIndex, int currentCount, String pattern, StringBuilder answer) {
        if (currentIndex != pattern.length()) {
            if (pattern.charAt(currentIndex) == 'I') {
                buildSequence(currentIndex + 1, currentIndex + 1, pattern, answer);
            } else {
                currentCount = buildSequence(currentIndex + 1, currentCount, pattern, answer);
            }
        }
        answer.append(currentCount + 1);
        return currentCount + 1;
    }

    public String smallestNumber(String pattern) {
        StringBuilder answer = new StringBuilder();
        buildSequence(0, 0, pattern, answer);
        return answer.reverse().toString();
    }
}
