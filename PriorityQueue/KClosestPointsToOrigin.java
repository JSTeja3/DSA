package PriorityQueue;

import java.util.*;

public class KClosestPointsToOrigin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] points = new int[N][2];
        for (int i = 0; i < N; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
        }
        int k = sc.nextInt();
        int[][] result = kClosest(points, k);
        for (int i = 0; i < k; i++) {
            System.out.print("[" + result[i][0] + "," + result[i][1] + "] ");
        }
        sc.close();
    }

    public static int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.second - a.second);
        for (int i = 0; i < points.length; i++) {
            int distance = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            pq.offer(new Pair(i, distance));
            if (pq.size() > k) {
                pq.poll();
            }
        }
        for (int i = 0; i < k; i++) {
            int t = pq.poll().first;
            result[i][0] = points[t][0];
            result[i][1] = points[t][1];
        }

        return result;
    }

    static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
