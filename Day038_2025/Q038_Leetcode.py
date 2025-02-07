from typing import List

class Solution:
    def queryResults(self, limit: int, queries: List[List[int]]) -> List[int]:
        answer = []
        color_map = {}  # Stores frequency of colors
        ball_map = {}   # Stores ball to color mapping

        for ball, color in queries:
            # If the ball already has a color, decrement the count of its previous color
            if ball in ball_map:
                prev_color = ball_map[ball]
                color_map[prev_color] -= 1
                if color_map[prev_color] == 0:
                    del color_map[prev_color]

            # Update the ball with the new color
            ball_map[ball] = color
            color_map[color] = color_map.get(color, 0) + 1

            # Store the number of distinct colors
            answer.append(len(color_map))

        return answer
