package arrays.medium;

import java.util.HashMap;
import java.util.Map;

public class PrisonCellAfterNDays {
    private int[] nextDayState(int[] cells) {
        int[] next = new int[cells.length];
        for (int i = 1; i < 7; i++)
            next[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;

        return next;
    }

    public int[] prisonAfterNDays(int[] cells, int N) {
        N = (N - 1) % 14 + 1;
        for (int i = 0; i < N; i++)
            cells = nextDayState(cells);

        return cells;
    }
}
