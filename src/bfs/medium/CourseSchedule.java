package bfs.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {

    private boolean bfsUtil(int numCourses, int[] inDegree, List<Integer>[] adjList) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for(int v : adjList[u]) {
                inDegree[v]--;
                if(inDegree[v] == 0)
                    queue.add(v);
            }
            numCourses--;
        }

        return numCourses == 0;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses <= 0)
            return true;

        List<Integer>[] adjList = new LinkedList[numCourses];
        int[] inDegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++)
            adjList[i] = new LinkedList<>();

        for (int[] e : prerequisites) {
            adjList[e[1]].add(e[0]);
            inDegree[e[0]]++;
        }

        return bfsUtil(numCourses, inDegree, adjList);
    }
}
