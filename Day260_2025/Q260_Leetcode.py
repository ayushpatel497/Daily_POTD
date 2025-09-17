from typing import List
from collections import defaultdict
import bisect

class FoodRatings:
    def __init__(self, foods: List[str], cuisines: List[str], ratings: List[int]):
        self.food_rating = {}
        self.food_cuisine = {}
        self.cuisine_foods = defaultdict(list)

        for food, cuisine, rating in zip(foods, cuisines, ratings):
            self.food_rating[food] = rating
            self.food_cuisine[food] = cuisine
            # Store as (-rating, food) for max heap behavior with sorted list
            self.cuisine_foods[cuisine].append((-rating, food))

        # Sort the lists initially
        for cuisine in self.cuisine_foods:
            self.cuisine_foods[cuisine].sort()

    def changeRating(self, food: str, newRating: int) -> None:
        cuisine = self.food_cuisine[food]
        old_rating = self.food_rating[food]
        self.food_rating[food] = newRating

        # Remove old entry
        self.cuisine_foods[cuisine].remove((-old_rating, food))
        # Insert new entry and maintain sorted order
        bisect.insort(self.cuisine_foods[cuisine], (-newRating, food))

    def highestRated(self, cuisine: str) -> str:
        return self.cuisine_foods[cuisine][0][1]
