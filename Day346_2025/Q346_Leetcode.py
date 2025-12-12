from typing import List


class Solution:
    def countMentions(self, numberOfUsers: int, events: List[List[str]]) -> List[int]:
        count = [0] * numberOfUsers
        next_online_time = [0] * numberOfUsers

        # Sort events
        def cmp(e):
            timestamp = int(e[1])
            type_ = e[0]
            # OFFLINE should come last if same timestamp
            return (timestamp, 1 if type_ == "OFFLINE" else 0)

        events.sort(key=cmp)

        for event in events:
            type_ = event[0]
            cur_time = int(event[1])

            if type_ == "MESSAGE":
                target = event[2]

                # MESSAGE ALL
                if target == "ALL":
                    for i in range(numberOfUsers):
                        count[i] += 1

                # MESSAGE HERE
                elif target == "HERE":
                    for i in range(numberOfUsers):
                        if next_online_time[i] <= cur_time:
                            count[i] += 1

                # MESSAGE specific users "0 1 4"
                else:
                    idx = 0
                    for i, ch in enumerate(target):
                        if ch.isdigit():
                            idx = idx * 10 + int(ch)
                        if i + 1 == len(target) or target[i + 1] == ' ':
                            count[idx] += 1
                            idx = 0

            else:  
                # OFFLINE
                idx = int(event[2])
                next_online_time[idx] = cur_time + 60

        return count
