package book.jzoffer.ch4;

import java.util.Stack;

/**
 * Created by pekey on 2017/12/22.
 */
public class Example21 {

    public static class StackWithMin<T extends Comparable<T>>{
        //数据栈，用于存放插入的数据
        private Stack<T> dataStack;
        //最小数位置栈，存放数据栈中最小的数的位置
        private Stack<Integer> minStack;

        public StackWithMin() {
            this.dataStack = new Stack<>();
            this.minStack = new Stack<>();
        }

        public T pop(){
            //如果栈已经为空,再出栈抛出异常
            if(dataStack.isEmpty())
                throw new RuntimeException("The stack is already empty");
            //如果有数据，最小数位置和数据栈必定是相同的元素个数
            //两个栈同时出栈
            minStack.pop();
            return dataStack.pop();
        }

        public void push(T t){
            //如果入栈的元素为空就抛出异常
            if(t == null)
                throw new RuntimeException("Element can be null");
            if(dataStack.isEmpty()){
                dataStack.push(t);
                minStack.push(0);
            }else{
                //如果数据栈中有数据
                //获取数据栈中的最小元素
                T e = dataStack.get(minStack.peek());
                //将t入栈
                dataStack.push(t);
                //如果插入的数据比栈中的最小元素小
                if(t.compareTo(e)<0){
                    minStack.push(dataStack.size()-1);
                }else{
                    minStack.push(minStack.peek());
                }
            }
        }

        public T min(){
            //如果最小数位置栈已经为空（数据栈中已经没有数据了），则抛出异常
            if(minStack.isEmpty())
                throw new RuntimeException("No element is stack");
            //获取数据栈中最小的元素，并且返回结果
            return dataStack.get(minStack.peek());
        }
    }

    Stack data=new Stack();
    Stack min=new Stack();

    public void push(int node) {
        if(min.empty()){
            min.push(node);
        }else{
            int top=(int)min.peek();
            if(node<top){
                min.push(node);
            }else{
                min.push(top);
            }
        }
        data.push(node);
    }

    public void pop() {
        if(!(data.empty())){
            data.pop();
            min.pop();
        }
    }

    public int min() {
        if(min.empty()){
            return 0;
        }
        return (int)min.peek();
    }

    public static void main(String[] args) {
//        StackWithMin<Integer> stack =  new StackWithMin<>();
//        stack.push(3);
//        System.out.println(stack.min());
//        stack.push(4);
//        System.out.println(stack.min());
//        stack.push(2);
//        System.out.println(stack.min());
//        stack.pop();
//        System.out.println(stack.min());
//        stack.pop();
//        System.out.println(stack.min());
//        stack.push(0);
//        System.out.println(stack.min());

        Example21 emp = new Example21();
        emp.push(2);
        System.out.println(emp.min());
        emp.push(3);
        System.out.println(emp.min());
        emp.push(4);
        System.out.println(emp.min());
        emp.push(1);
        System.out.println(emp.min());
        emp.push(2);
        System.out.println(emp.min());

    }

}

