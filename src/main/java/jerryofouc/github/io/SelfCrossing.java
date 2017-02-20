package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaojiez on 2/19/17.
 */
public class SelfCrossing {
    public static boolean isSelfCrossing(int[] x) {
        if(x == null || x.length <4){
            return false;
        }
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> p = new ArrayList<>();
        p.add(0);p.add(0);p.add(0);p.add(x[0]);
        paths.add(p);
        p = new ArrayList<>();p.add(0);p.add(x[0]);p.add(-x[1]);p.add(x[0]);
        paths.add(p);p = new ArrayList<>();p.add(-x[1]);p.add(x[0]);p.add(-x[1]);p.add(x[0]-x[2]);
        paths.add(p);
        if(x[0]-x[2]>=0){
            if(-x[1]+x[3]>=0){
                return true;
            }else {
                p = new ArrayList<>();p.add(-x[1]);p.add(x[0]-x[2]);p.add(-x[1]+x[3]);p.add(x[0]-x[2]);
                return jailTranverse(x,3,paths);
            }
        }else {
            int xx = paths.get(2).get(2)+x[3];p = new ArrayList<>();p.add(paths.get(2).get(2));p.add(paths.get(2).get(3));p.add(xx);p.add(paths.get(2).get(3));
            paths.add(p);
            if(xx<paths.get(0).get(0)){
                paths.remove(0);
                return jailTranverse(x,4,paths);
            }else if(xx==paths.get(0).get(0)){
                paths.get(1).set(1,paths.get(0).get(1));
                paths.get(1).set(3,paths.get(0).get(1));
                paths.remove(0);
                return jailTranverse(x,4,paths);
            }else {
                boolean notJail = true;
                for(int i=4;i<x.length;i++){
                    if(notJail){
                        if(i%4 == 0){
                            int yy = paths.get(paths.size()-1).get(1)+x[i];p = new ArrayList<>();p.add(paths.get(paths.size()-1).get(2));p.add(paths.get(paths.size()-1).get(3));p.add(paths.get(paths.size()-1).get(2));p.add(yy);
                            paths.add(p);
                            if(yy<paths.get(0).get(1)){
                                paths.remove(0);
                                paths.remove(0);
                                return jailTranverse(x,i+1,paths);
                            }else if(yy>=paths.get(0).get(1)&&yy<=paths.get(0).get(3)){
                                paths.remove(1);
                                paths.remove(1);
                                return jailTranverse(x,i+1,paths);
                            }else {
                                paths.remove(0);
                            }
                        }else if(i%4==1){
                            xx = paths.get(paths.size()-1).get(0)-x[i];p = new ArrayList<>();p.add(paths.get(paths.size()-1).get(2));p.add(paths.get(paths.size()-1).get(3));p.add(xx);p.add(paths.get(paths.size()-1).get(3));
                            paths.add(p);
                            if(xx>paths.get(0).get(0)){
                                paths.remove(0);
                                paths.remove(0);
                                return jailTranverse(x,i+1,paths);
                            }else if(xx <= paths.get(0).get(0) && xx >= paths.get(0).get(2)){
                                paths.remove(1);
                                paths.remove(1);
                                return jailTranverse(x,i+1,paths);
                            }else {
                                paths.remove(0);
                            }
                        }else if(i%4 == 2){
                            int yy = paths.get(paths.size()-1).get(1)-x[i];p = new ArrayList<>();p.add(paths.get(paths.size()-1).get(2));p.add(paths.get(paths.size()-1).get(3));p.add(paths.get(paths.size()-1).get(2));p.add(yy);
                            paths.add(p);
                            if(yy>paths.get(0).get(1)){
                                paths.remove(0);
                                paths.remove(0);
                                return jailTranverse(x,i+1,paths);
                            }else if(yy<=paths.get(0).get(1)&&yy>=paths.get(0).get(3)){
                                paths.remove(1);
                                paths.remove(1);
                                return jailTranverse(x,i+1,paths);
                            }else {
                                paths.remove(0);
                            }
                        }else if(i%4==1){
                            xx = paths.get(paths.size()-1).get(0)+x[i];p = new ArrayList<>();p.add(paths.get(paths.size()-1).get(2));p.add(paths.get(paths.size()-1).get(3));p.add(xx);p.add(paths.get(paths.size()-1).get(3));
                            paths.add(p);
                            if(xx<paths.get(0).get(2)){
                                paths.remove(0);
                                paths.remove(0);
                                return jailTranverse(x,i+1,paths);
                            }else if(xx >= paths.get(0).get(2) && xx <= paths.get(0).get(0)){
                                paths.remove(1);
                                paths.remove(1);
                                return jailTranverse(x,i+1,paths);

                            }else {
                                paths.remove(0);
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private static boolean jailTranverse(int[] x,int i,List<List<Integer>> paths){
        List p ;
        for(;i<x.length;i++){
            if(i%4 == 0){
                int y = paths.get(2).get(3)+x[i];
                if(y>=paths.get(0).get(1)){
                    return true;
                }else {
                    paths.remove(0);p = new ArrayList<>();p.add(paths.get(paths.size()-1).get(2));p.add(paths.get(paths.size()-1).get(3));p.add(paths.get(paths.size()-1).get(2));p.add(y);paths.add(p);
                }
            }else if(i%4 == 1){
                int xx = paths.get(2).get(2)-x[i];
                if(xx<=paths.get(0).get(0)){
                    return true;
                }else {
                    paths.remove(0);p = new ArrayList<>();p.add(paths.get(paths.size()-1).get(2));p.add(paths.get(paths.size()-1).get(3));p.add(xx);p.add(paths.get(paths.size()-1).get(3));paths.add(p);
                }
            }else if(i%4 == 2){
                int y = paths.get(2).get(3)-x[i];
                if(y<=paths.get(0).get(1)){
                    return true;
                }else {
                    paths.remove(0);p = new ArrayList<>();p.add(paths.get(paths.size()-1).get(2));p.add(paths.get(paths.size()-1).get(3));p.add(paths.get(paths.size()-1).get(2));p.add(y);paths.add(p);
                }
            }else if(i%4 == 3){
                int xx = paths.get(2).get(2)+x[i];
                if(xx>=paths.get(0).get(0)){
                    return true;
                }else {
                    paths.remove(0);
                    p = new ArrayList<>();p.add(paths.get(paths.size()-1).get(2));p.add(paths.get(paths.size()-1).get(3));p.add(xx);p.add(paths.get(paths.size()-1).get(3));paths.add(p);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] x= new int[]{1,1,2,2,3,1,1};
        System.out.println(isSelfCrossing(x));
    }
}
