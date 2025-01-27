class Node:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.prev = None
        self.next = None

class LRUCache:
    # Constructor for initializing the cache capacity with the given value.
    def __init__(self, cap):
        self.capacity = cap
        self.cache = {}
        self.head = Node(-1, -1)
        self.tail = Node(-1, -1)
        self.head.next = self.tail
        self.tail.prev = self.head

    # Function to return value corresponding to the key.
    def get(self, key):
        if key not in self.cache:
            return -1
        node = self.cache[key]
        self._remove(node)
        self._insert(node)
        return node.value

    # Function for storing key-value pair.
    def put(self, key, value):
        if key in self.cache:
            self._remove(self.cache[key])
        if len(self.cache) == self.capacity:
            self._remove(self.tail.prev)
        self._insert(Node(key, value))

    def _remove(self, node):
        del self.cache[node.key]
        node.prev.next = node.next
        node.next.prev = node.prev

    def _insert(self, node):
        self.cache[node.key] = node
        node.next = self.head.next
        node.prev = self.head
        self.head.next.prev = node
        self.head.next = node
