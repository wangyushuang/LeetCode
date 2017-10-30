import java.util.Arrays;
public class candyAllocation {
    public int candy(int[] ratings) {
        int[] num=new int[ratings.length];//每个小孩得到的糖果数目
        int sum=0;//总糖果数
        Arrays.fill(num,1);//每个小孩最初都分1块
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1])//分比左边小孩高，则多分一块
                num[i]=num[i-1]+1;
        }
        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1] && num[i]<=num[i+1])
                num[i]=num[i+1]+1;//分比右边小孩高，则多分一块
        }
        for(int i=0;i<ratings.length;i++)
            sum+=num[i];
        return sum;
    }
}