//思路：如果当前字符为变量或者为数字，则压栈，如果是运算符，则将栈顶两个元素弹出作相应运算，
//		结果再入栈，最后当表达式扫描完后，栈里的就是结果。
//注意：比较String不能用"=="
import java.util.Stack;
public class evaluateRPN {
    public int evalRPN(String[] tokens) 
    {
        Stack<Integer> stack=new Stack<Integer>();
        int tmp1,tmp2;
        for(int i=0;i<tokens.length;i++)
        {
            if(!(tokens[i].equals("+") || tokens[i].equals("-") 
                 || tokens[i].equals("*") || tokens[i].equals("/")))
            {
                stack.push(Integer.parseInt(tokens[i]));
                continue;
            }
            tmp1=stack.pop();
            tmp2=stack.pop();
            if(tokens[i].equals("+"))
                stack.push(tmp2+tmp1);
            if(tokens[i].equals("-"))
                stack.push(tmp2-tmp1);
            if(tokens[i].equals("*"))
                stack.push(tmp2*tmp1);
            if(tokens[i].equals("/"))
                stack.push(tmp2/tmp1);
        }
        return stack.pop();
    }
}