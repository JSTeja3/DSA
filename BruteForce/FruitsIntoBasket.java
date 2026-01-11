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
        int N = fruits.length;

        for (int i = 0; i < N; i++) {
            int c = 0;
            int[] unique = new int[N];

            for (int j = i; j < N; j++) {
                if (unique[fruits[j]] == 0)
                    c++;
                unique[fruits[j]]++;

                if (c > 2)
                    break;

                maxFruits = Math.max(maxFruits, j - i + 1);
            }
        }
        return maxFruits;
    }
}
