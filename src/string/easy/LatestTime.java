package string.easy;

public class LatestTime {
    public String maximumTime(String time) {
        char[] timeArr = time.toCharArray();

        if (timeArr[0] == '?') {
            timeArr[0] = Character.getNumericValue(timeArr[1]) < 4 ? '2' : '1';
        }
        if (timeArr[1] == '?') {
            timeArr[1] = Character.getNumericValue(timeArr[0]) < 2 ? '9' : '3';
        }

        if (timeArr[3] == '?') {
            timeArr[3] = '5';
        }
        if (timeArr[4] == '?') {
            timeArr[4] = '9';
        }

        return new String(timeArr);
    }
}
