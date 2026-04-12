package MonotonicQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class RottingOranges {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] grid = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        System.out.println(orangesRotting(grid));
        sc.close();
    }

    public static int orangesRotting(int[][] grid) {
        Deque<Node> queue = new ArrayDeque<>();
        int fresh = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    queue.addLast(new Node(i, j));
                }
            }
        }
        int time = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node temp = queue.removeFirst();
                int x = temp.x;
                int y = temp.y;
                if ((x - 1 >= 0) && (grid[x - 1][y] == 1)) {
                    grid[x - 1][y] = 2;
                    queue.addLast(new Node(x - 1, y));
                    fresh--;
                }
                if ((x + 1 < grid.length) && (grid[x + 1][y] == 1)) {
                    grid[x + 1][y] = 2;
                    queue.addLast(new Node(x + 1, y));
                    fresh--;
                }
                if ((y - 1 >= 0) && (grid[x][y - 1] == 1)) {
                    grid[x][y - 1] = 2;
                    queue.addLast(new Node(x, y - 1));
                    fresh--;
                }
                if ((y + 1 < grid[0].length) && (grid[x][y + 1] == 1)) {
                    grid[x][y + 1] = 2;
                    queue.addLast(new Node(x, y + 1));
                    fresh--;
                }
            }
            if (queue.size() == 0) {
                break;
            }
            time++;

        }
        if (fresh > 0) {
            return -1;
        }
        return time;
    }

}

class Node {
    public int x;
    public int y;

    public Node(int _x, int _y) {
        this.x = _x;
        this.y = _y;
    }
}
