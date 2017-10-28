public class singleNumb {
    public int singleNumber(int[] A) {
        for(int i=0;i<A.length;i++){
            int j=0;
            boolean flag=false;
            for(;j<A.length;j++){
                if(i!=j && A[i]==A[j] && !flag)
                    flag=true;//第二次出现
                if(i!=j && A[i]==A[j] && flag)
                    break;//第三次出现
            }
            if(j==A.length)
                return A[i];
        }
        return 0;
    }
}