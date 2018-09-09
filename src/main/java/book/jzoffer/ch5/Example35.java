package book.jzoffer.ch5;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by pekey on 2017/12/26.
 */
public class Example35 {
    public static char firstNotRepeatingChar(String s) {
        if(s==null||s.length()<1)
            throw new IllegalArgumentException("Arg should not be null or empty");
        Map<Character, Integer> map = new LinkedHashMap<>();
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c, -2);
            }else{
                map.put(c, i);
            }
        }
        Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
        //记录只出现一次的字符的索引
        int idx = Integer.MAX_VALUE;
        //记录只出现一次的字符
        char result = '\0';
        //找最小索引对应的字符
        for(Map.Entry<Character, Integer> entry:entrySet){
            if(entry.getValue() >= 0 && entry.getValue() < idx){
                idx = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }

    public static int firstNotRepeatingChar1(String s){
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                int time = map.get(s.charAt(i));
                map.put(s.charAt(i),++time);
            }else{
                map.put(s.charAt(i),1);
            }
        }
        int pos = -1;
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if(map.get(c) == 1)
                return j;
        }
        return pos;

    }

    public static void main(String[] args) {
        System.out.println(firstNotRepeatingChar("google"));
    }


}
