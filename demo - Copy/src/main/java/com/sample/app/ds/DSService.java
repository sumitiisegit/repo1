package com.sample.app.ds;

import com.sample.app.ds.list.LinkedList;
import org.springframework.stereotype.Service;

@Service
public class DSService<T> {


    public void push(T element) {

        StackWithArrayList.getInstance().push(element);

    }
    public T pop(){
        return (T) StackWithArrayList.getInstance().pop();
    }

    public void addInLL(T element)
    {
        LinkedList.getInstance().add(element);

        LinkedList.getInstance().show();
    }

    public void removeFromEndLL()
    {
        LinkedList.getInstance().removeFromEnd();

        LinkedList.getInstance().show();
    }


}
