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
        int minRooms = 1;
        for (int i = 0; i < start.length; i++) {
            int count = 0;
            for (int j = 0; j < start.length; j++) {
                if (start[i] < end[j] && end[i] > start[j]) {
                    count++;
                }
            }
            minRooms = Math.max(minRooms, count);
        }
        return minRooms;
    }
}
