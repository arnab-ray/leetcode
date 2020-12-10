package greedy.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LargestValuesFromLabels {
    private static class Node {
        int val, label;

        Node(int val, int label) {
            this.val = val;
            this.label = label;
        }
    }

    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        Node[] nodes = new Node[values.length];
        Map<Integer, Integer> labelFreq = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            nodes[i] = new Node(values[i], labels[i]);
            labelFreq.put(labels[i], 1);
        }

        Arrays.sort(nodes, (o1, o2) -> o2.val - o1.val);

        int sum = 0, count = 0;
        for (Node node : nodes) {
            int freq = labelFreq.get(node.label);
            if (freq <= use_limit) {
                sum += node.val;
                labelFreq.put(node.label, freq + 1);
                count++;
            }
            if (count == num_wanted)
                break;
        }

        return sum;
    }
}
