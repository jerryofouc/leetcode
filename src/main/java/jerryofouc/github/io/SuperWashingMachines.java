package jerryofouc.github.io;

/**
 * Created by xiaojiez on 3/24/17.
 */
public class SuperWashingMachines {
    public static int findMinMoves(int[] machines) {
        int steps = 0;
        int sum = 0;
        for(int i=0;i<machines.length;i++){
            sum += machines[i];
        }
        if(sum%machines.length != 0){
            return -1;
        }
        int avg = sum/machines.length;
        int[] move = new int[machines.length];
        for(int i=0;i+1<machines.length;i++){
            if(machines[i]>avg){
                int a = machines[i] - avg;
                machines[i+1] += a;
                move[i] += a;
                machines[i] = avg;
                steps = Math.max(move[i],steps) ;
            }else {
                int a =avg- machines[i] ;
                machines[i+1] -= a;
                move[i+1] = a;
                machines[i] = avg;
                steps = Math.max(move[i+1],steps) ;
            }
        }

        return steps;

    }



    public static void main(String[] args) {
        int[] machines = new int[]{1,0,5};
        System.out.println(findMinMoves(machines));
    }

}
