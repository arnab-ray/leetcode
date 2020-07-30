package graph.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CourseSchedule {

    private boolean isCycleUtil(int v, boolean[] visited, boolean[] inStack, List<Integer>[] adjList) {
        if(inStack[v])
            return true;
        if(visited[v])
            return false;

        visited[v] = inStack[v] = true;
        for(Integer w : adjList[v])
            if(isCycleUtil(w, visited, inStack, adjList))
                return true;

        inStack[v] = false;
        return false;
    }

    private boolean isCycle(int numCourses, List<Integer>[] adjList) {
        boolean[] visited = new boolean[numCourses];
        boolean[] inStack = new boolean[numCourses];

        for(int i = 0; i < numCourses; i++)
            if(isCycleUtil(i, visited, inStack, adjList))
                return true;

        return false;
    }

    private void topologicalSort(int u, boolean[] visited, List<Integer>[] adjList, Stack<Integer> stack) {
        visited[u] = true;

        for(Integer v : adjList[u]) {
            if (!visited[v]) {
                topologicalSort(v, visited, adjList, stack);
            }
        }
        stack.push(u);
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjList = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++)
            adjList[i] = new ArrayList<>();

        for(int[] edges : prerequisites)
            adjList[edges[1]].add(edges[0]);

        if(!isCycle(numCourses, adjList)) {
            boolean[] visited = new boolean[numCourses];
            Stack<Integer> stack = new Stack<>();

            for(int i = 0; i < numCourses; i++) {
                if(!visited[i]) {
                    topologicalSort(i, visited, adjList, stack);
                }
            }

            int i = 0;
            int[] result = new int[numCourses];
            while (!stack.isEmpty())
                result[i++] = stack.pop();

            return result;
        } else {
            return new int[0];
        }
    }
}
