package string.easy;

public class LongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        int namePos = 0, typePos = 0;
        while (namePos < name.length() && typePos < typed.length()) {
            if (typed.charAt(typePos) == name.charAt(namePos)) {
                typePos++; namePos++;
            } else if (typePos > 0 && typed.charAt(typePos) == typed.charAt(typePos - 1)) {
                typePos++;
            } else {
                return false;
            }
        }

        while (typePos < typed.length()) {
            if (typePos > 0 && typed.charAt(typePos) == typed.charAt(typePos - 1))
                typePos++;
            else
                return false;
        }

        return namePos == name.length() && typePos == typed.length();
    }
}
