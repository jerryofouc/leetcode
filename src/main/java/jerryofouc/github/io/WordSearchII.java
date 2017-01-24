package jerryofouc.github.io;

import java.util.*;

/**
 * Created by xiaojiez on 1/23/17.
 */
public class WordSearchII {



    public static List<String> findWords(char[][] board, String[] words) {
        if(words.length == 0){
            return new ArrayList<String>();
        }
       Set<String> result = new HashSet<String>();
       TrieNode trieNode = buildTrieTree(words);
       for(int i=0;i<board.length;i++){
           for(int j=0;j<board[0].length;j++){
               dfs(i,j,board,trieNode,result);
           }
       }
       return new ArrayList<String>(result);

    }

    private static void dfs(int i, int j, char[][] board, TrieNode trieNode, Set<String> result) {
        char t = board[i][j];
        TrieNode cur = trieNode.next[board[i][j]-'a'];
        if(cur == null){
            return;
        }
        if(cur.word != null){
            result.add(cur.word);
        }
        board[i][j] = '#';
        if(i+1<board.length&&board[i+1][j] != '#'){
            dfs(i+1,j,board,cur,result);
        }
        if(i-1>=0&&board[i-1][j] != '#'){
            dfs(i-1,j,board,cur,result);
        }
        if(j-1>=0&&board[i][j-1] != '#'){
            dfs(i,j-1,board,cur,result);
        }
        if(j+1<board[0].length&&board[i][j+1] != '#'){
            dfs(i,j+1,board,cur,result);
        }
        board[i][j] = t;
    }

    private static TrieNode buildTrieTree(String[] words) {
        TrieNode header = new TrieNode();

        for(String w : words){
            TrieNode cur = header;
            for(int i=0;i<w.length();i++){
                if(cur.next[w.charAt(i)-'a'] == null){
                    TrieNode trieNode = new TrieNode();
                    cur.next[w.charAt(i)-'a'] = trieNode;
                }
                cur = cur.next[w.charAt(i)-'a'];
            }
            cur.word = w;
        }
        return header;
    }


    static class TrieNode{
        TrieNode[] next = new TrieNode[26];
        String word;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                "oaan".toCharArray(),"etae".toCharArray(),"ihkr".toCharArray(),"iflv".toCharArray()
        };
        String[] words = new String[]{"oath","pea","eat","rain"};
        System.out.println(findWords(board,words));
    }


}
