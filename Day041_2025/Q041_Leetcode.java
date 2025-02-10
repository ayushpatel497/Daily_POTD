class Q041_Leetcode {
    public String clearDigits(String s) {
        StringBuilder answer = new StringBuilder();
        
        for (char character : s.toCharArray()) {
            if (Character.isLetter(character)) {
                answer.append(character);
            } else if (Character.isDigit(character) && answer.length() > 0) {
                answer.deleteCharAt(answer.length() - 1);
            }
        }
        
        return answer.toString();
    }
}