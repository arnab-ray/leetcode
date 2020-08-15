package graph.medium;

public class FriendCircles {
    private void dfs(int u, boolean[] visited, int[][] M) {
        visited[u] = true;

        for(int v = 0; v < M.length; v++) {
            if(M[u][v] == 1 && !visited[v]) {
                dfs(v, visited, M);
            }
        }
    }

    public int findCircleNum(int[][] M) {
        int n = M.length;
        if(n == 0 || n == 1)
            return n;

        boolean[] visited = new boolean[n];
        int count = 0;

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                count++;
                dfs(i, visited, M);
            }
        }

        return count;
    }
}
