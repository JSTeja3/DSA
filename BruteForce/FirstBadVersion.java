import java.util.Scanner;

public class FirstBadVersion {

    private static boolean[] verArray; 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int bad = sc.nextInt();
        fillArray(N, bad);
        System.out.println(firstBadVersion(N));
        sc.close();
    }
    public static void fillArray(int N, int bad){
        verArray = new boolean[N];
        for(int i=bad-1; i<verArray.length; i++){
            verArray[i] = true;
        }
    }
    public static boolean isBadVersion(int ver){
        return verArray[ver-1];
    }
    public static int firstBadVersion(int n) {
        for(int i=1; i<=n; i++){
            if(isBadVersion(i)){
                return i;
            }
        }
        return -1;
    }


}
