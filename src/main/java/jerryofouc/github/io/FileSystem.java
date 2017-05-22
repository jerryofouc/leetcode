package jerryofouc.github.io;

import java.util.*;

/**
 * Created by xiaojiez on 5/21/17.
 */
public class FileSystem {
    private static class Node{
        boolean isDir = true;
        String content;
        String name;
        Map<String,Node> nextMap = new HashMap<>();
    }
    private Node root;
    public FileSystem() {
        root = new Node();
        root.isDir = true;
    }

    public List<String> ls(String path) {
        String[] a = {};
        if(!path.equals("/")){
            a = path.substring(1).split("/");
        }

        Node cur = root;
        for(int i=0;i<a.length;i++){
            cur = cur.nextMap.get(a[i]);
        }
        List<String> ret =  new ArrayList<>();
        if(cur.isDir){
            for(Node n : cur.nextMap.values()){
                ret.add(n.name);
            }
            Collections.sort(ret);
        }else {
            ret.add(cur.name);
        }

        return ret;
    }

    public void mkdir(String path) {
        String[] a = path.substring(1).split("/");
        Node cur = root;
        for(int i=0;i<a.length;i++){
            if(!cur.nextMap.containsKey(a[i])){
                Node temp = new Node();
                temp.name = a[i];
                cur.nextMap.put(a[i],temp);
                cur = temp;
            }else {
                cur = cur.nextMap.get(a[i]);
            }
        }
    }

    public void addContentToFile(String filePath, String content) {
        String[] a = filePath.substring(1).split("/");
        Node cur = root;
        for(int i=0;i<a.length;i++){
            if(!cur.nextMap.containsKey(a[i])){
                Node temp = new Node();
                temp.name = a[i];
                cur.nextMap.put(a[i],temp);
                cur = temp;
            }else {
                cur = cur.nextMap.get(a[i]);
            }
        }
        cur.isDir = false;
        if(cur.content == null){
            cur.content = content;
        }else {
            cur.content += content;
        }

    }

    public String readContentFromFile(String filePath) {
        String[] a = filePath.substring(1).split("/");
        Node cur = root;
        for(int i=0;i<a.length;i++){
            cur = cur.nextMap.get(a[i]);
        }
        return cur.content;
    }

    public static void main(String[] args) {
        FileSystem fs = new FileSystem();
        System.out.println(fs.ls("/"));
        fs.mkdir("/lfs");
        System.out.println(fs.ls("/"));
        System.out.println(fs.ls("/"));
        fs.mkdir("/lfs/oztebbp");
        System.out.println(fs.ls("/lfs/oztebbp"));
        System.out.println(fs.ls("/lfs"));
    }
}
