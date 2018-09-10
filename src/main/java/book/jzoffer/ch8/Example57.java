package book.jzoffer.ch8;

/**
 * Created by pekey on 2018/1/3.
 */
public class Example57 {

    public List deleteDuplication(List pHead)
    {
        if(pHead==null)return null;

        List preNode = null;
        List node = pHead;
        while(node!=null){
            List nextNode = node.next;
            boolean needDelete = false;//判断相邻两个点是否相等
            if(nextNode!=null&&nextNode.data==node.data){
                needDelete = true;
            }
            if(!needDelete){
                preNode = node;
                node = node.next;
            }else{
                int dataue = node.data;
                List toBeDel = node;
                while(toBeDel!=null&&toBeDel.data == dataue){
                    nextNode = toBeDel.next;
                    toBeDel = nextNode;
                    //此处不能少，找到第一个pHead，以后的preNode就不为null了
                    if(preNode==null)
                        pHead = nextNode;
                    else
                        preNode.next = nextNode;
                    node = nextNode;
                }
            }
        }

        return pHead;
    }
    
}
