import heapq
from typing import List

class TaskManager:
    def __init__(self, tasks: List[List[int]]):
        self.tasks = []  # max-heap (store as (-priority, taskId))
        self.taskPriority = {}
        self.taskOwner = {}
        for task in tasks:
            self.add(task[0], task[1], task[2])

    def add(self, userId: int, taskId: int, priority: int) -> None:
        heapq.heappush(self.tasks, (-priority, taskId))
        self.taskPriority[taskId] = priority
        self.taskOwner[taskId] = userId

    def edit(self, taskId: int, newPriority: int) -> None:
        heapq.heappush(self.tasks, (-newPriority, taskId))
        self.taskPriority[taskId] = newPriority

    def rmv(self, taskId: int) -> None:
        self.taskPriority[taskId] = -1

    def execTop(self) -> int:
        while self.tasks:
            priority, taskId = heapq.heappop(self.tasks)
            priority = -priority
            if self.taskPriority.get(taskId, -1) == priority:
                self.taskPriority[taskId] = -1
                return self.taskOwner[taskId]
        return -1
