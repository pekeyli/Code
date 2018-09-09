package book.jzoffer.ch6;

/**
 * Created by pekey on 2017/12/26.
 */
public class Example38 {

    private static int getNumberOfK(int[] data, int k) {
        int number = 0;
        if(data != null && data.length>0){
            int first = getFirstK(data,k,0,data.length-1);
            int last = getLastK(data,k,0,data.length-1);
            if(first>-1 && last>-1){
                number = last-first+1;
            }
        }
        return number;
    }

    /**
     * 找排序数组中K第一次出现的位置
     *
     * @param data
     * @param k
     * @param start
     * @param end
     * @return
     *
     * */
    private static int getFirstK(int[] data, int k, int start, int end) {
        if(data==null || data.length<1 || start>end)
            return -1;
        int midIdx = start + (end-start)/2;
        int midData = data[midIdx];
        if(midData == k){
            if((midIdx>0 && data[midIdx-1]!=k)||midIdx==0){
                return midIdx;
            }else{
                end = midIdx-1;
            }
        }else if(midData>k){
            end = midIdx-1;
        }else{
            start = midIdx+1;
        }
        return getFirstK(data,k,start,end);
    }

    /**
     * 找排序数组中k最后一次出现的位置
     * */
    private static int getLastK(int[] data, int k, int start, int end) {
        if(data==null||data.length<1||start>end)
            return -1;
        int midIdx = start+(end-start)/2;
        int midData = data[midIdx];
        if(midData == k){
            if((midIdx+1<data.length && data[midIdx+1]!=k)||midIdx==data.length-1){
                return midIdx;
            }else{
                start = midIdx+1;
            }
        }else if(midData<k){
            start = midIdx+1;
        }else{
            end = midIdx-1;
        }
        return	getLastK(data,k,start,end);
    }



    public static void main(String[] args) {
        int[] data = {3, 3, 3, 3};
        System.out.println(getNumberOfK(data,3));
    }
}
