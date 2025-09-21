from sortedcontainers import SortedList
from typing import List

class Node:
    def __init__(self, shop: int, movie: int, price: int):
        self.shop = shop
        self.movie = movie
        self.price = price

    def __lt__(self, other):
        if self.price != other.price:
            return self.price < other.price
        if self.shop != other.shop:
            return self.shop < other.shop
        return self.movie < other.movie

    def __eq__(self, other):
        return self.shop == other.shop and self.movie == other.movie and self.price == other.price

    def __hash__(self):
        return hash((self.shop, self.movie, self.price))

class MovieRentingSystem:
    def __init__(self, n: int, entries: List[List[int]]):
        self.byPair = {}
        self.availableByMovie = {}
        self.rentedSet = SortedList()

        for shop, movie, price in entries:
            node = Node(shop, movie, price)
            self.byPair[(shop, movie)] = node
            if movie not in self.availableByMovie:
                self.availableByMovie[movie] = SortedList()
            self.availableByMovie[movie].add(node)

    def search(self, movie: int) -> List[int]:
        if movie not in self.availableByMovie:
            return []
        s = self.availableByMovie[movie]
        return [s[i].shop for i in range(min(5, len(s)))]

    def rent(self, shop: int, movie: int) -> None:
        node = self.byPair[(shop, movie)]
        self.availableByMovie[movie].remove(node)
        self.rentedSet.add(node)

    def drop(self, shop: int, movie: int) -> None:
        node = self.byPair[(shop, movie)]
        self.rentedSet.remove(node)
        self.availableByMovie[movie].add(node)

    def report(self) -> List[List[int]]:
        return [[self.rentedSet[i].shop, self.rentedSet[i].movie] for i in range(min(5, len(self.rentedSet)))]
