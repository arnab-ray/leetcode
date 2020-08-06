package graph.medium;

import java.util.*;

public class EquateDivision {
    private double calcUtil(Map<String, Map<String, Double>> map, String num, String den, Set<String> visitedNums) {

        // checking visited to avoid cycles
        if (visitedNums.contains(num) || !map.containsKey(num) || !map.containsKey(den))
            return -1;

        // found exact num/den
        if (map.get(num).containsKey(den))
            return map.get(num).get(den);

        visitedNums.add(num);

        for (Map.Entry<String, Double> entry : map.get(num).entrySet()) {
            // DFS
            // for given (num/d1) = v1, equation for query (num/den) = v1 * (d1/den)
            double temp = calcUtil(map, entry.getKey(), den, visitedNums);
            if (temp != -1) {
                return entry.getValue() * temp;
            } // else if not found (d1/den), we look for v2 * (d2/den) {where v2 = num/d2}
        }

        return -1;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // map holding all num -> (den -> value)
        Map<String, Map<String, Double>> map = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String num = equations.get(i).get(0);
            String den = equations.get(i).get(1);

            Map<String, Double> m = map.getOrDefault(num, new HashMap<>());
            m.put(den, values[i]);
            map.put(num, m);

            // putting den/num = 1/v values as well for easy lookup
            m = map.getOrDefault(den, new HashMap<>());
            m.put(num, 1.0 / values[i]);
            map.put(den, m);
        }

        double[] result = new double[queries.size()];
        for (int i = 0; i < result.length; i++) {
            String s1 = queries.get(i).get(0);
            String s2 = queries.get(i).get(1);
            result[i] = calcUtil(map, s1, s2, new HashSet<>());
        }

        return result;
    }
}
