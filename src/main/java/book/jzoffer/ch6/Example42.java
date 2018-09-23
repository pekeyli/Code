package book.jzoffer.ch6;

import java.util.Scanner;

/**
 * Created by pekey on 2018/1/3.
 */
public class Example42 {

    public static String ReverseSentence(String str) {
        if (str == null || str.trim().equals(""))// trim掉多余空格
            return str;
        String[] words = str.split(" ");// 以空格切分出各个单词
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < words.length; i++) {

            buffer.append(reverse1(words[i].toCharArray(), 0, words[i].length() - 1)).append(" ");
        }
        if (buffer.length() > 0)
            buffer.deleteCharAt(buffer.length() - 1);// 删除最后一个空格
        return reverse1(buffer.toString().toCharArray(), 0, buffer.length() - 1);

    }

    private static String reverse1(char[] str, int l, int r) {
        if (l > r)
            return "";
        char tmp;
        while (l < r) {
            tmp = str[l];
            str[l] = str[r];
            str[r] = tmp;
            l++;
            r--;
        }
        return String.valueOf(str);
    }

    public String LeftRotateString(String str, int n) {
        char[] chars = str.toCharArray();
        if (chars.length < n) return "";
        reverse(chars, 0, n - 1);
        reverse(chars, n, chars.length - 1);
        reverse(chars, 0, chars.length - 1);
        StringBuilder sb = new StringBuilder(chars.length);
        for (char c : chars) {
            sb.append(c);
        }
        return sb.toString();
    }

    public void reverse(char[] chars, int low, int high) {
        char temp;
        while (low < high) {
            temp = chars[low];
            chars[low] = chars[high];
            chars[high] = temp;
            low++;
            high--;
        }
    }

    public static String test(String str){
        StringBuilder sb = new StringBuilder();
        String[] temp = str.split(" ");
        for (int i = 0; i < temp.length; i++) {
            sb.append(reverse11(temp[i])+" ");
        }
        return sb.toString().trim();
    }

    public static String reverse11(String temp) {
        char[] str = temp.toCharArray();
        int l = 0;
        int r = str.length-1;
        if (l > r)
            return "";
        char tmp;
        while (l < r) {
            tmp = str[l];
            str[l] = str[r];
            str[r] = tmp;
            l++;
            r--;
        }
        return String.valueOf(str);
    }


    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s=sc.next();
        String s = "ready go";
        System.out.println("|"+test(s)+"|");
    }
}
