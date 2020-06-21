package com.sample.app.ds;

import java.util.ArrayList;

public class Stack {

    ArrayList<Integer> stackList = new ArrayList<>();


    public void push(Integer element){
        stackList.add(element);
        System.out.println("Pushed " +element+ " to Stack");
    }

    public Integer pop(){
        if (stackList.size()>0) {
            Integer element = stackList.get(stackList.size()-1);

            stackList.remove(element);
            System.out.println("Popped element:" + element);
            return element;
        }
        else{
            System.out.println("Pop operation not possible.");
            return -1;
        }
    }

    public static void main(String[] args){

        Stack stack = new Stack();

        stack.push(10);
        stack.pop();
        stack.push(20);
        stack.push(30);
        stack.push(10);
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.push(50);

    }
}
