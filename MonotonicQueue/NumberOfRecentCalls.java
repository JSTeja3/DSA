package MonotonicQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class NumberOfRecentCalls {
    class RecentCounter {
        private Deque<Integer> queue;

        public RecentCounter() {
            queue = new ArrayDeque<>();
        }

        public int ping(int t) {
            queue.addLast(t);
            while ((int) queue.peekFirst() < (t - 3000)) {
                queue.removeFirst();
            }
            return queue.size();
        }
    }

    /**
     * Your RecentCounter object will be instantiated and called as such:
     * RecentCounter obj = new RecentCounter();
     * int param_1 = obj.ping(t);
     */
}
