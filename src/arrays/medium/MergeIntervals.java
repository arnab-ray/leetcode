package arrays.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    private class Node {
        int first, last;
        Node(int first, int last) {
            this.first = first;
            this.last = last;
        }
    }

    private static final Comparator<Node> comparator = (o1, o2) -> o1.first - o2.first;

    public int[][] merge(int[][] intervals) {
        List<Node> nodeList = new ArrayList<>();

        for (int[] interval : intervals)
            nodeList.add(new Node(interval[0], interval[1]));

        nodeList.sort(comparator);

        List<Node> result = new ArrayList<>();
        for (Node value : nodeList) {
            if (result.isEmpty()) {
                result.add(value);
            } else {
                Node node = result.get(result.size() - 1);
                if (node.last > value.first && node.last < value.last) {
                    Node newNode = new Node(node.first, value.last);
                    result.remove(result.size() - 1);
                    result.add(newNode);
                } else if (node.last < value.first) {
                    result.add(value);
                }
            }
        }
        result.remove(result.size() - 1);

        int[][] resultVal = new int[result.size()][2];
        int i = 0;
        for(Node node : result) {
            resultVal[i][0] = node.first;
            resultVal[i][1] = node.last;
            i++;
        }

        return resultVal;
    }
}
