package jerryofouc.github.io;

import java.util.*;

/**
 *
 * User: zhangxiaojie
 * Date: 3/6/14
 * Time: 0:27
 *
 */
public class WordLadder2 {
    public static ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        if(start == null || end == null || start.length() != end.length()){
            return new ArrayList<ArrayList<String>>();
        }
        HashSet<String> visitSet = new HashSet<String>();
        Queue<String> queue = new LinkedList <String>();
        boolean found = false;
        int levelSize = 1;
        HashMap<String,HashSet<String>> parentMap = new HashMap<String, HashSet<String>>();
        queue.add(start);
        HashSet<String> toAddVisitSet = new HashSet<String>();
        while(!queue.isEmpty()){
            String cur = queue.poll();
            levelSize--;

            byte[] curBytes = cur.getBytes();
            for(int i=0;i<curBytes.length;i++){
                byte temp = curBytes[i];
                for(byte b = 'a';b<='z';b++){
                    if(b == temp){
                        continue;
                    }
                    curBytes[i] = b;
                    String tt = new String(curBytes);
                    if(tt.equals(end)){
                        found = true;
                        HashSet set = parentMap.get(tt);
                        if(set == null){
                            set = new HashSet();
                        }
                        set.add(cur);
                        parentMap.put(tt,set);
                        break;
                    }else if(dict.contains(tt)&&!visitSet.contains(tt)){
                        HashSet set = parentMap.get(tt);
                        if(set == null){
                            set = new HashSet();
                        }
                        set.add(cur);
                        parentMap.put(tt, set);
                        toAddVisitSet.add(tt);
                    }
                }
                curBytes[i] = temp;


            }

            if(levelSize == 0){//改圈结束了重新计数
                if(found){
                    break;
                }
                levelSize = toAddVisitSet.size();
                for(String toAdd : toAddVisitSet){
                    queue.add(toAdd);
                    visitSet.add(toAdd);
                }
                toAddVisitSet.clear();
            }
        }

        if(found){
            ArrayList<LinkedList<String>> allList = new ArrayList<LinkedList<String>>();
            LinkedList<String> arrayList = new LinkedList<String>();
            getAllPath(end, start, parentMap, arrayList,allList);
            ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
            for(LinkedList<String> l : allList){
                ArrayList<String> ss = new ArrayList<String>(l);
                ret.add(ss);

            }
            return ret;
        }else{
            return new ArrayList<ArrayList<String>>();
        }
    }

    private static void getAllPath(String cur, String start, HashMap<String, HashSet<String>> parentMap, LinkedList<String> list,ArrayList<LinkedList<String>> allList) {
        list.addFirst(cur);
        if(cur.equals(start)){
            allList.add(list);
            return ;
        }else{
            HashSet<String> parents = parentMap.get(cur);
            for(String parent : parents){
                getAllPath(parent,start,parentMap, (LinkedList<String>) list.clone(),allList);
            }
        }
    }

    public static void main(String args[]){
        HashSet<String> dict = new HashSet<String>();
        String[] testCases = {"hot","dot","dog","lot","log"};
        for(String t :testCases){
            dict.add(t);
        }
        System.out.println(findLadders("hit", "cog", dict));;
    }
}