class Solution:
    def clearDigits(self, s: str) -> str:
        answer = []
        
        for character in s:
            if character.isalpha():
                answer.append(character)
            elif character.isdigit() and answer:
                answer.pop()
        
        return "".join(answer)
