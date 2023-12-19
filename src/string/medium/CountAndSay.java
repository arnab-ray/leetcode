package string.medium;

public class CountAndSay {
    public static String countAndSay(int n) {
        if (n == 1)
            return "1";

        String val = countAndSay(n - 1);
        StringBuilder s = new StringBuilder();
        int counter = 1;
        char currChar = val.charAt(0);

        for (int i = 1; i < val.length(); i++) {
            if (currChar == val.charAt(i)) {
                counter++;
            } else {
                s.append(counter);
                s.append(currChar);
                currChar = val.charAt(i);
                counter = 1;
            }
        }

        s.append(counter);
        s.append(currChar);

        return s.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }
}
