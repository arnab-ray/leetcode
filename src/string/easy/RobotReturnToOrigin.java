package string.easy;

public class RobotReturnToOrigin {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;

        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == 'R')
                y++;
            else if (moves.charAt(i) == 'L')
                y--;
            else if (moves.charAt(i) == 'U')
                x--;
            else
                x++;
        }

        return x == 0 && y == 0;
    }
}
