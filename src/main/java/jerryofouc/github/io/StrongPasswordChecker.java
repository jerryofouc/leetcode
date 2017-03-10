package jerryofouc.github.io;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * Created by xiaojiez on 3/10/17.
 */
public class StrongPasswordChecker {
    static class Cell{
        int i;
        int j;

        public Cell(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    public static int strongPasswordChecker(String s) {
        TreeMap<Integer,Integer> numMap = new TreeMap<>();
        if(s.length() == 0){
            return 6;
        }
        char last = s.charAt(0);
        boolean isSame = false;
        int num = 1;

        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==last){
                isSame = true;
                num++;
            }else {
                if(isSame){
                    if(num >= 3){
                       Integer n =  numMap.get(num);
                       if(n == null){
                           n = 0;
                       }
                       numMap.put(num,++n);
                    }
                    num = 1;
                }
                isSame = false;
            }
            last = s.charAt(i);
        }
        if(isSame){
            if(num >= 3){
                Integer n =  numMap.get(num);
                if(n == null){
                    n = 0;
                }
                numMap.put(num,++n);
            }
        }

        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasDigit = false;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>='a' && s.charAt(i)<='z'){
                hasLower = true;
            }
            if(s.charAt(i)>='A' && s.charAt(i)<='Z'){
                hasUpper = true;
            }

            if(s.charAt(i)>='0' && s.charAt(i)<='9'){
                hasDigit = true;
            }
        }

        int hasDiffChar = (hasLower?0:1)+(hasUpper?0:1)+(hasDigit?0:1);
        if(s.length()<6){
            int needToAdd = 6-s.length();
            if(numMap.size() == 0){
                if(needToAdd>=hasDiffChar){
                    return needToAdd;
                }else {
                    return hasDiffChar;
                }
            }else {
                Integer a = numMap.firstEntry().getKey();
                if(a == 5){
                    return 2;
                }else {
                    return 6-s.length();
                }
            }
        }else if(s.length()>20){
            int needToDelete = s.length()-20;
            PriorityQueue<Cell> priorityQueue = new PriorityQueue<>(new Comparator<Cell>() {
                @Override
                public int compare(Cell o1, Cell o2) {
                    if(o1.j<o2.j){
                        return -1;
                    }else if(o1.j>o2.j){
                        return 1;
                    }else {
                        return 0;
                    }
                }
            });
            for(Map.Entry<Integer,Integer> entry : numMap.entrySet()){
                for(int i=0;i<entry.getValue();i++){
                    int k = entry.getKey()%3+1;
                    priorityQueue.add(new Cell(entry.getKey(),k));
                }
            }

            int temp = needToDelete;
            while (!priorityQueue.isEmpty()){
                Cell c = priorityQueue.poll();
                if(temp - c.j>=0){
                    temp = temp-c.j;
                    if(c.i-c.j>=3){
                        priorityQueue.add(new Cell(c.i-c.j, 3));
                    }
                }else {
                    if(c.i>=3){
                        priorityQueue.add(c);
                    }
                    break;
                }
            }
            int update = 0;
            for(Cell c : priorityQueue){
                update += c.i/3;
            }
            update = Math.max(update,hasDiffChar);

            return needToDelete+update;

        }else {
            int update = 0;
            for(Map.Entry<Integer,Integer> entry : numMap.entrySet()){
                for(int i=0;i<entry.getValue();i++){
                    update += entry.getKey()/3;
                }
            }
            update = Math.max(update,hasDiffChar);
            return update;
        }
    }

    public static void main(String[] args) {
        System.out.println(strongPasswordChecker("aaaaaaaAAAAAA6666bbbbaaaaaaABBC"));
    }


}
