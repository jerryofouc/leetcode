package jerryofouc.github.io;

import java.util.*;

/**
 * Created by xiaojiez on 1/15/17.
 */
public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> stringListMap = new HashMap<String, List<String>>();
        for(int i=0;i<strs.length;i++){
            String a = strs[i];
            char[] arrays = a.toCharArray();
            char[] copyArray = new char[arrays.length];
            System.arraycopy(arrays,0,copyArray,0,arrays.length);
            Arrays.sort(copyArray);
            if(stringListMap.containsKey(new String(copyArray))){
                stringListMap.get(new String(copyArray)).add(a);
            }else {
                List<String> list = new ArrayList<String>();
                list.add(a);
                stringListMap.put(new String(copyArray),list);
            }
        }
        List<List<String>> result = new ArrayList<List<String>>();
        for(List<String> v:stringListMap.values()){
            result.add(v);
        }
        return result;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }
}
