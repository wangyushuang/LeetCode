public class canCompleteCirc {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for(int i=0;i<gas.length;i++){
            //从第i个站出发
            int res=gas[i];
            int j=i+1;
            for(;j<=i+gas.length;j++){
                //到达第k个站
                int k=(j>=gas.length) ? j-gas.length : j;
                int kLast=(k==0)?gas.length-1:k-1;//上一站
                if(res<cost[kLast])//进站前油量小于0，则不能从该站出发
                    break;
                res=res-cost[kLast]+gas[k];//剩余油量
            }
            if(j>i+gas.length)
                return i;
        }
        return -1;
    }
}