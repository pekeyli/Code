package other;

/**
 * Created by pekey on 2017/12/6.
 */
public class sanjiao {

    public static int getHeight(String args[]) throws ParamNotFoundException,NumberFormatException{
        int m;
        if(args.length==0){
            throw new ParamNotFoundException("空值异常，您没有输入参数");
        }
        m=Integer.parseInt(args[0]);
        return m;
    }

    public static void main(String[] args) {
        int size = 0;
        try {
            size = getHeight(args);
        } catch (ParamNotFoundException e) {
            System.out.println(e.getMessage());
        }catch(NumberFormatException e) {
            System.out.println("格式输入异常，请输入数字");
        } catch (Exception e) {
            System.out.println("发生异常，请重新输入");
        }

        for (int i = 0; i < size; i++) {
            for (int x = 0; x < size - i; x++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i*2+1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}

class ParamNotFoundException extends Exception{
    public ParamNotFoundException(String message){
        super(message);
    }
}





