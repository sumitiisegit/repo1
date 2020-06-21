package com.sample.app.ds;

import com.sample.app.ds.list.LinkedList;

import java.util.ArrayList;

public class StackWithLinkedList<T> {

    private LinkedList<T> stackList = LinkedList.getInstance();

    private static StackWithLinkedList stackWithLinkedList;

    private StackWithLinkedList()
    {
    }

    public static synchronized StackWithLinkedList getInstance() {

        if (null == stackWithLinkedList) {
            stackWithLinkedList = new StackWithLinkedList<>();
        }
            return stackWithLinkedList;

    }

    public void push(T element){
        stackList.add(element);
        System.out.println("Pushed " +element+ " to Stack");
    }

    public T pop(){
        if (stackList.getSize()>0) {
            T element = stackList.removeFromEnd();
            System.out.println("Popped element:" + element);
            return element;
        }
        else{
            System.out.println("Pop operation not possible.");
            return null;
        }
    }


    public static void main(String[] args){

        StackWithLinkedList stack = new StackWithLinkedList();

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
