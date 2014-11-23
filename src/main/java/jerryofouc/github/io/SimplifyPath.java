package jerryofouc.github.io;

import java.util.Iterator;
import java.util.Stack;

/**
 * @author zhangxiaojie
 *         2014-11-22 20:51
 *         功能介绍:
 */
public class SimplifyPath {
    public static void main(String args[]){
        System.out.println(simplifyPath("../"));
    }
    public static String simplifyPath(String path) {
        String[] paths = path.split("/");
        Stack<String> stack = new Stack<String>();
        for(int i=0;i<paths.length;i++){
            if(paths[i].equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }

            }else if(!paths[i].equals(".")&&!paths[i].equals("")){
                stack.push(paths[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("/");
        Iterator<String> iterator = stack.iterator();
        while(iterator.hasNext()){
            sb.append(iterator.next());
            if(iterator.hasNext()){
                sb.append("/");
            }
        }
        return sb.toString();
    }
}
