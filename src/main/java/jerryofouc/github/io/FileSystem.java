package jerryofouc.github.io;

import java.util.List;

/**
 * Created by xiaojiez on 5/21/17.
 */
public class FileSystem {
    private static class Node{
        boolean isDir = true;
        String content;
        String name;
        List<Node> next;
    }
    private Node root;
    public FileSystem() {
        root = new Node();
        root.isDir = true;
        root.name = "/";
    }

    public List<String> ls(String path) {

    }

    public void mkdir(String path) {
        String[] a = path.split("/");

    }

    public void addContentToFile(String filePath, String content) {

    }

    public String readContentFromFile(String filePath) {

    }
}
