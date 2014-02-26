package jerryofouc.github.io;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 2/26/14
 * Time: 23:32
 * To change this template use File | Settings | File Templates.
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int start = 0; start < gas.length; start++) {
            if (canCompleteCircuit(start, gas, cost)) {
                return start;
            }
        }
        return -1;
    }

    private boolean canCompleteCircuit(int start, int[] gas, int[] cost) {
        int gasTotal = 0;
        for (int i = start; i < gas.length; i++) {
            gasTotal += gas[i];
            if (gasTotal < cost[i]) {
                return false;
            }
            gasTotal = gasTotal - cost[i];
        }
        for(int i=0;i<start;i++){
            gasTotal += gas[i];
            if (gasTotal < cost[i]) {
                return false;
            }
            gasTotal = gasTotal - cost[i];
        }
        return true;
    }
}
