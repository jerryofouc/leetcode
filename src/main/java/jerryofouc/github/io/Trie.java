package jerryofouc.github.io;

/**
 * Created by xiaojiez on 1/22/17.
 * Trie 的Node定义比较重要
 */
public class Trie {
    /** Initialize your data structure here. */
    static class Node{
        Node[] array = new Node[128];
        boolean end;
    }
    final Node preHeader = new Node();
    public Trie() {

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node current = preHeader;
        for(int i=0;i<word.length();i++){
            Node node = current;
            if(current.array[word.charAt(i)] == null){
                node = new Node();
                current.array[word.charAt(i)] = node;
            }
            current = current.array[word.charAt(i)];
        }
        current.end = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node current = preHeader;
        for(int i=0;i<word.length();i++){
            if(current.array[word.charAt(i)] == null){
                return false;
            }
            current = current.array[word.charAt(i)];
        }
        if(current != null && current.end){
            return true;
        }
        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node current = preHeader;
        for(int i=0;i<prefix.length();i++){
            if(current.array[prefix.charAt(i)] == null){
                return false;
            }
            current = current.array[prefix.charAt(i)];
        }

        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("worlda");
        trie.insert("pptv");
        trie.insert("pptvcc");
        System.out.println(trie.search("world"));
        System.out.println(trie.startsWith(""));
    }
}
