package greedy.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GroupPeople {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> result = new LinkedList<>();

        for (int groupSize : groupSizes) {
            map.put(groupSize, new LinkedList<>());
        }

        for(int i = 0; i < groupSizes.length; i++) {
            List<Integer> list = map.get(groupSizes[i]);
            list.add(i);
            if(list.size() == groupSizes[i]) {
                result.add(list);
                map.put(groupSizes[i], new LinkedList<>());
            } else {
                map.put(groupSizes[i], list);
            }
        }

        return result;
    }
}
