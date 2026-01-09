import java.util.*;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int k = sc.nextInt();
        System.out.println(characterReplacement(s, k));
        sc.close();
    }
    public static int characterReplacement(String s, int k) {
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] count = new int[26];
            int maxRepeat = 0;
            for (int j = i; j < s.length(); j++) {
                int x = s.charAt(j) - 'A';
                count[x]++;
                if (count[x] > maxRepeat) {
                    maxRepeat = count[x];
                }
                if (((j - i + 1) - maxRepeat) > k) {
                    break;
                }
                maxLength = Math.max(maxLength, (j - i + 1));
            }
        }
        return maxLength;
    }
}
