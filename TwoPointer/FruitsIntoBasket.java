package TwoPointer;

import java.util.Scanner;

public class FruitsIntoBasket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] fruits = new int[N];
        for (int i = 0; i < N; i++) {
            fruits[i] = sc.nextInt();
        }
        System.out.println(totalFruit(fruits));
        sc.close();
    }

    public static int totalFruit(int[] fruits) {
        int maxFruits = 0;
        int B = 2;
        int N = fruits.length;
        int p1 = 0;
        int p2 = 0;
        int[] unique = new int[N];
        int c = 0;
        while (p2 < N) {
            unique[fruits[p2]]++;
            if (unique[fruits[p2]] == 1) {
                c++;
            }
            while (c > B) {
                unique[fruits[p1]]--;
                if (unique[fruits[p1]] == 0) {
                    c--;
                }
                p1++;
            }
            maxFruits = Math.max(maxFruits, p2 - p1 + 1);
            p2++;
        }
        return maxFruits;
    }
}
