package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 3/1/14
 * Time: 10:02
 * To change this template use File | Settings | File Templates.
 */
public class RemoveNegativeNum {
    public static void removeNegativeNumFromList(ArrayList<Integer> arrayList){
        if(arrayList == null){
            throw new IllegalArgumentException();
        }
        Iterator<Integer> integerIterator = arrayList.iterator();
        while(integerIterator.hasNext()){
            int curNum = integerIterator.next();
            if(curNum<0){
                integerIterator.remove();
            }
        }
    }

    public static void main(String args[]){
        ArrayList<Integer> aa = new ArrayList<Integer>();
        aa.add(1);
        aa.add(-1);
        aa.add(10);
        removeNegativeNumFromList(aa);
        System.out.println(aa);
    }
}
