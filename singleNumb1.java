public class singleNumb1 {
    public int singleNumber(int[] A) {
        for(int i=0;i<A.length;i++){
            int j=0;
            for(;j<A.length;j++){
                if(i!=j && A[i]==A[j])
                    break;
            }
            if(j==A.length)
                return A[i];
        }
        return 0;
    }
}