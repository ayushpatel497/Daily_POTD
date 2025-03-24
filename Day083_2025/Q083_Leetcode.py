class Solution:
    def countDays(self, days: int, meetings: list[list[int]]) -> int:
        free_days, latest_end = 0, 0

        meetings.sort()

        for start, end in meetings:
            if start > latest_end + 1:
                free_days += start - latest_end - 1
            latest_end = max(latest_end, end)

        free_days += days - latest_end
        return free_days
