//动态规划
//1.字符串s从位置0到位置i需要最少切片的次数，与i能否与之前字符组成回文有关
//2.如果i能与之前字符组成回文，则切片次数可能是回文之前的最小切片数+1
public class minCut_palindrome {
    public int minCut(String s) {
        int len=s.length();
        if(s==null || len<2)
            return 0;
        boolean[][] isPalin=new boolean[len][len];//isPalin[i][j]:s从i到j是否为回数
        int [] minCut=new int[len];//minCut[i]:s从位置0到位置i最少需要切多少次
        minCut[0]=0;
        for(int i=1;i<len;i++){
            minCut[i]=i;//最多需要切i次
            for(int j=i;j>=0;j--){
                if(s.charAt(i)==s.charAt(j) && (i-j<2 || isPalin[j+1][i-1])){
                    isPalin[j][i]=true;
                    if(j==0)
                        minCut[i]=0;
                    else
                        minCut[i]=Math.min(minCut[i],minCut[j-1]+1);
                }
            }
        }
        return minCut[len-1];
    }
}