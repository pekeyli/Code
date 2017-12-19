package JZOffer.ch2;

/**
 * Created by pekey on 2017/12/19.
 */
public class Example8 {

    public static int min(int[] array){
        if(array==null && array.length==0){
            return 0;
        }
        int low = 0;
        int high = array.length-1;
        int mid = 0;

        while(array[low]>=array[high]){
            if((high-low)==1){
                mid = high;
                break;
            }

            if(array[low] == array[mid] &&array[mid]==array[high]){
                for(int i=1;i<array.length;i++){
                    int min =array[0];
                    if(min>array[i]){
                        min = array[i];
                        return min;
                    }
                }
            }

            mid = (low+high)/2;
            if(array[low]<=array[mid]){
                low =mid;
            }else if(array[mid]<=array[high]){
                high = mid;
            }
        }
        return array[mid];
    }

    public static void main(String[] args) {
        int [] array ={0,1,1,1,1};
        System.out.println(min(array));

    }
}
