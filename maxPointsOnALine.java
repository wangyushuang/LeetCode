/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
//思路：参考 https://segmentfault.com/a/1190000005678407
//	1.利用HashMap,Key为斜率（用String表示），Value为该斜率的点数
//	2.表达斜率最有效的是用最简分式，因此利用两个整数表示斜率，再将其转化为String
//	3.对每个点，都计算一下该点和其他点连线的斜率，这样对于这个点来说，相同斜率的直线有多少条，
//		就意味着有多少个点在同一条直线上，因为这些直线是相同的。
//		另外，如果计算过点A和点B的直线，当算到点B时，就不用再和A连线了，因为AB这条直线上的点数已经都计算过了。
import java.util.HashMap;
public class maxPointsOnALine {
    public int maxPoints(Point[] points) 
    {
        if(points.length<=2)
            return points.length;
        int result=0;
        for(int i=0;i<points.length-1;i++)
        {
            HashMap<String,Integer> map=new HashMap<String,Integer>();
            int pSame=1;//the same point
            int pMax=0;//maximum number of points lie on the same straight line through points[i]
            for(int j=i+1;j<points.length;j++)
            {
                int dx=points[i].x-points[j].x;
                int dy=points[i].y-points[j].y;
                if(dx==0 && dy==0)
                    pSame++;
                else
                {
                    String key=slopToString(dx,dy);
                    map.put(key,map.containsKey(key)?map.get(key)+1:1);
                    if(map.get(key)>pMax)
                        pMax=map.get(key);
                }
            }
            if(pMax+pSame>result)
                result=pMax+pSame;
        }
        return result;
    }
    public int getGcd(int a, int b )//greatest common divisor
    {
        if(a<0) a=-a;
        if(b==0)
            return a;
        return getGcd(b, a%b);
    }
    public String slopToString(int a, int b)
    {
        String sign;
        if((a>0 && b>0) || (a<0 && b<0))
            sign="+";
        else
            sign="-";
        int gcd=getGcd(a,b);
        return sign+String.valueOf(Math.abs(a)/gcd)+"/"+String.valueOf(Math.abs(b)/gcd);
    }
}