package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaojiez on 6/4/17.
 */
public class FindDuplicateFileinSystem {
    public static List<List<String>> findDuplicate(String[] paths) {
        Map<String,List<String>> map = new HashMap<>();
        for(String path : paths){
            String[] pp = path.split(" ");
            String parentPath = pp[0];
            for(int i=1;i<pp.length;i++){
                String content = pp[i].substring(pp[i].lastIndexOf("(")+1,pp[i].length()-1);
                List<String> a = map.getOrDefault(content,new ArrayList<>());
                a.add(parentPath+"/"+pp[i].substring(0,pp[i].lastIndexOf("(")));
                map.put(content,a);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<String,List<String>> entry : map.entrySet()){
            if(entry.getValue().size()>1){
                result.add(entry.getValue());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] paths = {"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};
        System.out.println(findDuplicate(paths));
    }
}
