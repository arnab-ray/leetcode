package string.medium;

public class ReverseWordsInString {
    public String reverseWords(String s) {
        if(s == null || s.isEmpty())
            return s;

        String[] strArr = s.trim().split("\\s+");
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = strArr.length - 1; i > 0; i--) {
            if(!strArr[i].isEmpty()) {
                stringBuilder.append(strArr[i]);
                stringBuilder.append(" ");
            }
        }

        if(!strArr[0].isEmpty())
            stringBuilder.append(strArr[0]);

        return stringBuilder.toString();
    }
}
