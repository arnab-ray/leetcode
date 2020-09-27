package string.easy;

import java.util.*;

public class ReorderLogs {
    private boolean isDigit(String log) {
        int index = log.indexOf(" ") + 1;
        return Character.isDigit(log.charAt(index));
    }

    private static final Comparator<String> comparator = (o1, o2) -> {
        int index1 = o1.indexOf(" ") + 1;
        int index2 = o2.indexOf(" ") + 1;
        int diff = o1.substring(index1).compareTo(o2.substring(index2));
        if (diff == 0)
            return o1.substring(0, index1).compareTo(o2.substring(0, index2));
        return diff;
    };

    public String[] reorderLogFiles(String[] logs) {
        Queue<String> queue = new PriorityQueue<>(1, comparator);

        int pos = logs.length - 1;
        for (int i = logs.length - 1; i >= 0; i--) {
            if (isDigit(logs[i])) {
                logs[pos--] = logs[i];
            } else {
                queue.add(logs[i]);
            }
        }

        pos = 0;
        while (!queue.isEmpty())
            logs[pos++] = queue.poll();

        return logs;
    }
}
