package string.medium;

import java.util.*;

public class ReorganizeString {

    public String reorganizeString(String S) {
        Map<Character, Integer> map = new HashMap<>();
        for(Character c : S.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        PriorityQueue<Character> queue = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

        for(Character c : S.toCharArray()) {
            if(map.get(c) > (S.length() + 1) / 2)
                return "";
            if(!queue.contains(c))
                queue.offer(c);
        }

        StringBuilder sb = new StringBuilder();
        while (queue.size() >= 2) {
            Character p = queue.poll();
            Character q = queue.poll();

            sb.append(p); sb.append(q);
            if(map.get(p) - 1 > 0) {
                map.put(p, map.get(p) - 1);
                queue.offer(p);
            }
            if(map.get(q) - 1 > 0) {
                map.put(q, map.get(q) - 1);
                queue.offer(q);
            }
        }

        if(queue.size() > 0)
            sb.append(queue.poll());

        return sb.toString();
    }
}
