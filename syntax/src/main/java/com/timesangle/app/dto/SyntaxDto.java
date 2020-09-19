package com.timesangle.app.dto;

import java.util.Iterator;

public class SyntaxDto{//} implements Iterable{
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SyntaxDto() {
        super();
    }

    public SyntaxDto(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    //@Override
    public Iterator iterator() {
        Iterator iterator = new Iterator() {
            @Override
            public boolean hasNext() {
                return hasNext();
            }

            @Override
            public Object next() {
                return next();
            }
        };
        return iterator;
    }
}
