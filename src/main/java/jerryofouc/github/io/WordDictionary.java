package jerryofouc.github.io;

/**
 * Created by xiaojiez on 1/23/17.
 */
public class WordDictionary {
    static class TrieNode{
        TrieNode[] array = new TrieNode[128];
        boolean end;
    }
    TrieNode preHeader = new TrieNode();

    /** Initialize your data structure here. */
    public WordDictionary() {

    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode cur = preHeader;
        for(int i=0;i<word.length();i++){
            if(cur.array[word.charAt(i)] == null){
                TrieNode trieNode = new TrieNode();
                cur.array[word.charAt(i)] = trieNode;
            }
            cur = cur.array[word.charAt(i)];
        }
        cur.end = true;

    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(word,0,preHeader);
    }

    private boolean search(String word, int start, TrieNode cur) {
        for(int i=start;i<word.length();i++){
            if(word.charAt(i) != '.'){
                if(cur.array[word.charAt(i)] == null){
                    return false;
                }
                cur = cur.array[word.charAt(i)];
            }else {
                for(int j=0;j<128;j++){
                    if(cur.array[j] != null){
                        if(search(word,i+1,cur.array[j])){
                            return true;
                        }
                    }
                }
                return false;

            }
        }
        return cur.end;
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("at");
        wordDictionary.addWord("bat");


        System.out.println(wordDictionary.search("a"));
        System.out.println(wordDictionary.search(".at"));


    }


}
