package design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author arnab.ray
 * @created on 05/11/22
 */
public class FileSystem {
    static class File {
        boolean isFile;
        final Map<String, File> fileMap;
        String content;

        File() {
            this.fileMap = new HashMap<>();
            this.isFile = false;
            this.content = "";
        }
    }

    private final File root;

    public FileSystem() {
        root = new File();
    }

    public List<String> ls(String path) {
        List<String> result;
        File t = root;
        if (!path.equals("/")) {
            result = new ArrayList<>();
            String[] pathSeg = path.split("/");
            for (int i = 1; i < pathSeg.length; i++) {
                t = t.fileMap.get(pathSeg[i]);
            }
            if (t.isFile) {
                result.add(pathSeg[pathSeg.length - 1]);
            }
        } else {
            result = new ArrayList<>(t.fileMap.keySet());
            Collections.sort(result);
        }
        return result;
    }

    public void mkdir(String path) {
        File t = root;
        String[] pathSeg = path.split("/");
        for (int i = 1; i < pathSeg.length; i++) {
            if (!t.fileMap.containsKey(pathSeg[i])) {
                t.fileMap.put(pathSeg[i], new File());
            }
            t = t.fileMap.get(pathSeg[i]);
        }
    }

    public void addContentToFile(String filePath, String content) {
        File t = root;
        String[] pathSeg = filePath.split("/");
        for (int i = 1; i < pathSeg.length - 1; i++) {
            t = t.fileMap.get(pathSeg[i]);
        }

        if (!t.fileMap.containsKey(pathSeg[pathSeg.length - 1])) {
            t.fileMap.put(pathSeg[pathSeg.length - 1], new File());
        }

        t = t.fileMap.get(pathSeg[pathSeg.length - 1]);
        t.isFile = true;
        t.content = t.content + content;
    }

    public String readContentFromFile(String filePath) {
        File t = root;
        String[] pathSeg = filePath.split("/");
        for (int i = 1; i < pathSeg.length - 1; i++) {
            t = t.fileMap.get(pathSeg[i]);
        }
        return t.fileMap.get(pathSeg[pathSeg.length - 1]).content;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */
