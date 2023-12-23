package bfs.medium;

import java.util.*;

public class VideosWatchedByFriends {
    private static class VideoFreq {
        String name;
        Integer freq;

        VideoFreq(String name, Integer freq) {
            this.name = name;
            this.freq = freq;
        }
    }

    private static class VideoFreqComparator implements Comparator<VideoFreq> {

        @Override
        public int compare(VideoFreq o1, VideoFreq o2) {
            if (o1.freq.equals(o2.freq))
                return o1.name.compareTo(o2.name);
            else
                return  o1.freq - o2.freq;
        }
    }

    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        List<Integer>[] adjList = new ArrayList[friends.length];
        Queue<VideoFreq> videosQueue = new PriorityQueue<>(new VideoFreqComparator());
        Map<String, Integer> videoToFreqMap = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < friends.length; i++) {
            adjList[i] = new ArrayList<>();
            for (int friend : friends[i]) {
                adjList[i].add(friend);
            }
        }

        boolean[] visited = new boolean[friends.length];

        queue.add(id);
        visited[id] = true;

        int k = 0;
        while (!queue.isEmpty()) {
            int n = queue.size();
            if (k == level) {
                for (int i = 0; i < n; i++) {
                    Integer identifier = queue.poll();
                    if (identifier != null) {
                        for (String video : watchedVideos.get(identifier)) {
                            videoToFreqMap.put(video, videoToFreqMap.getOrDefault(video, 0) + 1);
                        }
                    }
                }
            } else {
                for (int i = 0; i < n; i++) {
                    Integer identifier = queue.poll();
                    if (identifier != null) {
                        for (Integer friend : adjList[identifier]) {
                            if (!visited[friend]) {
                                queue.add(friend);
                                visited[friend] = true;
                            }
                        }
                    }
                }
                k++;
            }
        }

        for (Map.Entry<String, Integer> entry : videoToFreqMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
            videosQueue.add(new VideoFreq(entry.getKey(), entry.getValue()));
        }

        List<String> result = new LinkedList<>();
        while (!videosQueue.isEmpty())
            result.add(videosQueue.poll().name);

        return result;
    }
}
