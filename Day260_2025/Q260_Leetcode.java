import java.util.*;

class Q260_Leetcode {
    private Map<String, Integer> foodRatingMap;
    private Map<String, String> foodCuisineMap;
    private Map<String, TreeSet<Food>> cuisineFoodMap;

    private static class Food implements Comparable<Food> {
        String name;
        int rating;

        Food(String name, int rating) {
            this.name = name;
            this.rating = rating;
        }

        public int compareTo(Food other) {
            if (this.rating != other.rating) {
                return other.rating - this.rating; // Descending by rating
            }
            return this.name.compareTo(other.name); // Lexicographical order
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Food food = (Food) o;
            return name.equals(food.name);
        }

        @Override
        public int hashCode() {
            return name.hashCode();
        }
    }

    public Q260_Leetcode(String[] foods, String[] cuisines, int[] ratings) {
        foodRatingMap = new HashMap<>();
        foodCuisineMap = new HashMap<>();
        cuisineFoodMap = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            foodRatingMap.put(foods[i], ratings[i]);
            foodCuisineMap.put(foods[i], cuisines[i]);
            cuisineFoodMap.putIfAbsent(cuisines[i], new TreeSet<>());
            cuisineFoodMap.get(cuisines[i]).add(new Food(foods[i], ratings[i]));
        }
    }
    
    public void changeRating(String food, int newRating) {
        String cuisine = foodCuisineMap.get(food);
        int oldRating = foodRatingMap.get(food);
        cuisineFoodMap.get(cuisine).remove(new Food(food, oldRating));
        foodRatingMap.put(food, newRating);
        cuisineFoodMap.get(cuisine).add(new Food(food, newRating));
    }
    
    public String highestRated(String cuisine) {
        return cuisineFoodMap.get(cuisine).first().name;
    }
}
