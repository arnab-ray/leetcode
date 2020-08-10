package graph.medium;

import java.util.*;

public class OpenTheLock {
    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>();

        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        Queue<String> secondaryQueue = new LinkedList<>();
        int level = 0;
        visited.add("0000");

        while (!queue.isEmpty()) {
            String str = queue.poll();
            System.out.print(str + " ");
            if(target.equals(str))
                return level;

            if(!Arrays.asList(deadends).contains(str)) {
                for (int i = 0; i < 4; i++) {
                    char[] arr = str.toCharArray();
                    int val = (Integer.parseInt(String.valueOf(str.charAt(i))) + 1) % 10;
                    arr[i] = (char) (val + '0');
                    String newStr = new String(arr);
                    if (!visited.contains(newStr)) {
                        secondaryQueue.add(newStr);
                        visited.add(newStr);
                    }

                    if(str.charAt(i) == '0')
                        val = 9;
                    else
                        val = Math.abs(Integer.parseInt(String.valueOf(str.charAt(i))) - 1) % 10;
                    arr[i] = (char) (val + '0');
                    newStr = new String(arr);
                    if (!visited.contains(newStr)) {
                        secondaryQueue.add(newStr);
                        visited.add(newStr);
                    }
                }
            }

            if(queue.isEmpty()) {
                queue = secondaryQueue;
                secondaryQueue = new LinkedList<>();
                level++;
            }
        }

        return -1;
    }
}
