import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
            System.out.print("["+result[i][0]+","+result[i][1]+"], ");
        }
        sc.close();
    }

    public static int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            int dis = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            map.put(i, dis);
        }
        for (int i = 0; i < k; i++) {
            int key = 0;
            int min = Integer.MAX_VALUE;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() < min) {
                    min = entry.getValue();
                    key = entry.getKey();
                }
            }
            result[i][0] = points[key][0];
            result[i][1] = points[key][1];
            map.remove(key);
        }
        return result;
    }
}
