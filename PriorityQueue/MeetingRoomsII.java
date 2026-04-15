package PriorityQueue;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MeetingRoomsII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] start = new int[N];
        int[] end = new int[N];
        for (int i = 0; i < N; i++) {
            start[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            end[i] = sc.nextInt();
        }
        System.out.println(minMeetingRooms(start, end));
        sc.close();
    }
    public static int minMeetingRooms(int[] start, int[] end) {
        // code here
        int minRooms = 1;
        int[][] sch = new int[start.length][2];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<start.length; i++){
            sch[i][0] = start[i];
            sch[i][1] = end[i];
        }
        Arrays.sort(sch, (a,b)->a[0]-b[0]);
        pq.offer(sch[0][1]);
        for(int i=1; i<start.length; i++){
            if(sch[i][0] >= pq.peek()){
                pq.poll();
            }
            pq.offer(sch[i][1]);
            minRooms = Math.max(minRooms, pq.size());
        }
        return minRooms;
    }
}
