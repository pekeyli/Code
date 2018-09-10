package book.jzoffer.ch6;

/**
 * Created by pekey on 2018/1/3.
 */
public class Example42 {

    public String ReverseSentence(String str) {
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

    private String reverse1(char[] str, int l, int r) {
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
}
