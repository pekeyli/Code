package book.jzoffer.ch5;

/**
 * Created by pekey on 2017/12/26.
 */

class List{
    int data;
    List next;

    List(int val) {
        this.data = val;
    }
}

public class Example37 {
    public List FindFirstCommonNode(List pHead1, List pHead2) {
        if (pHead1 == null||pHead2 == null) {
            return null;
        }
        int count1 = 0;
        List p1 = pHead1;
        while (p1!=null){
            p1 = p1.next;
            count1++;
        }
        int count2 = 0;
        List p2 = pHead2;
        while (p2!=null){
            p2 = p2.next;
            count2++;
        }

        int flag = count1 - count2;

        if (flag > 0){
            while (flag>0){
                pHead1 = pHead1.next;
                flag --;
            }
            while (pHead1!=pHead2){
                pHead1 = pHead1.next;
                pHead2 = pHead2.next;
            }
            return pHead1;
        }
        if (flag <= 0){
            while (flag<0){
                pHead2 = pHead2.next;
                flag ++;
            }
            while (pHead1 != pHead2){
                pHead2 = pHead2.next;
                pHead1 = pHead1.next;
            }
            return pHead1;
        }
        return null;
    }
}
