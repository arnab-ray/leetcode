package string.hard;

public class CountAnagrams {
    private static int fact(int n) {
        if (n == 0)
            return 1;
        return ((n * fact(n - 1)));// % (new Double(Math.pow(10, 9)).intValue() + 7));
    }

    private static int countPermutation(String s) {
        System.out.println("Counting permutation for " + s);
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        int denom = 1;
        for (int i = 0; i < 26; i++) {
            if (count[i] > 1) {
                denom = (denom * fact(count[i]));// % (new Double(Math.pow(10, 9)).intValue() + 7);
            }
        }

        int result = fact(s.length()) / denom;
        System.out.println(result);
        return result;
    }

    public static int countAnagrams(String s) {
        String[] strs = s.split(" ");
        int total = 1;
        for (String str : strs) {
            total = (total * countPermutation(str)) % (new Double(Math.pow(10, 9)).intValue() + 7);
        }

        return total;
    }

    public static void main(String[] args) {
        String s = "too hot";
        System.out.println(countAnagrams(s));
    }
}
