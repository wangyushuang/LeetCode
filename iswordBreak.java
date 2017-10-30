import java.util.Set;
import java.util.HashMap;
public class iswordBreak {
    public boolean wordBreak(String s, Set<String> dict) {
        if(s.length()==0)
            return false;
        return wordBreakCore(s,dict,new HashMap<String,Boolean>());
    }
    public boolean wordBreakCore(String s, Set<String> dict, HashMap<String,Boolean> map){
        boolean isSeq=false;
        if(s.length()==0)
            return true;
        if(map.containsKey(s))
            return map.get(s);
        for(String word:dict){
            if(s.startsWith(word))
                isSeq=isSeq || wordBreakCore(s.substring(word.length()),dict,map);
        }
        map.put(s,isSeq);
        return isSeq;
    }
}