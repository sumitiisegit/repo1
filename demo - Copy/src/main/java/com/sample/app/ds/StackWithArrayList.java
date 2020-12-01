package com.sample.app.ds;

import java.util.ArrayList;

public class StackWithArrayList<T> {

    private ArrayList<T> stackList = new ArrayList<>();

    private static StackWithArrayList stackWithArrayList;

    private StackWithArrayList()
    {

    }

    public static synchronized StackWithArrayList getInstance() {

        if (null == stackWithArrayList) {
            stackWithArrayList = new StackWithArrayList<>();
        }
            return stackWithArrayList;

    }

    public void push(T element){
        stackList.add(element);
        System.out.println("Pushed " +element+ " to Stack");
    }

    public T pop(){
        if (stackList.size()>0) {
            T element = stackList.get(stackList.size()-1);

            stackList.remove(element);
            System.out.println("Popped element:" + element);
            return element;
        }
        else{
            System.out.println("Pop operation not possible.");
            return null;
        }
    }


    public static void main(String[] args){

        StackWithArrayList stack = new StackWithArrayList();

        stack.push(10);
        stack.pop();
        stack.push(20);
        stack.push("St");
        stack.push(10);
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.push(50);

    }
}
