package book.jzoffer.ch8;

/**
 * Created by pekey on 2018/1/3.
 */
public class Example51 {

    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers==null||length<0)return false;

        for(int i = 0;i < length; i++){
            if(numbers[i]<0||numbers[i]>length-1)
                return false;
        }

        for(int i = 0;i< length;i++){
            while(numbers[i]!=i){
                if(numbers[i]==numbers[numbers[i]]){
                    duplication[0] = numbers[i];
                    return true;
                }
                else{
                    //没有找到，然后则交换，使该数到正确的位置去
                    swap(numbers,i,numbers[i]);
                }
            }

        }
        return false;
    }

    //交换二数
    private void swap(int[]a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
