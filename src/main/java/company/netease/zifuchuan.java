package company.netease;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 一个由小写字母组成的字符串可以看成一些同一字母的最大碎片组成的。例如,"aaabbaaac"是由下面碎片组成的:'aaa','bb','c'。
 牛牛现在给定一个字符串,请你帮助计算这个字符串的所有碎片的平均长度是多少。
 */
public class zifuchuan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        ArrayList<String> list = new ArrayList<String>();

        Pattern p = Pattern.compile("([a-z])\\1*");
        Matcher m = p.matcher(s);

        while(m.find()){
            list.add(m.group());
        }

        float len = 0;
        for(String str : list){
            len += str.length();
        }

        float result = len/list.size();

        System.out.println(String.format("%.2f", result));

    }
}
