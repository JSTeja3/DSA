import java.util.Scanner;

public class MaximumNumberOfVowelsInASubstringOfGivenLength {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int k = sc.nextInt();
        System.out.println(maxVowels(s, k));
        sc.close();
    }

    public static int maxVowels(String s, int k) {
        int maxCount = 0;
        for (int i = 0; i <= s.length() - k; i++) {
            int v = 0;
            for (int j = i; j < i + k; j++) {
                if (s.charAt(j) == 'a' || s.charAt(j) == 'e' || s.charAt(j) == 'i' || s.charAt(j) == 'o'
                        || s.charAt(j) == 'u') {
                    v++;
                }
            }
            maxCount = Integer.max(maxCount, v);
        }
        return maxCount;
    }
}
