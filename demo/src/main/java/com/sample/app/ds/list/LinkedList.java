package com.sample.app.ds.list;

public class LinkedList<T> {

    private static LinkedList linkedList;

    private LinkedList() {
    }

    ;

    public static LinkedList getInstance() {
        if (null == linkedList)
            linkedList = new LinkedList();

        return linkedList;
    }


    private Node<T> head;

    public void add(T element) {
        if (null == head) {
            head = createNode(element);
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            Node temp = createNode(element);
            current.next = temp;
        }
    }

    public T removeFromEnd() {
        Node<T> last;
        if (null == head)
            return null;
        if (null == head.next) {
            last = head;
            head = null;
            return last.element;
        }

        Node<T> current = head;
        Node<T> temp = head;
        Node prev = head;
        while (current.next != null) {
            prev = temp;
            temp = current;
            current = current.next;
        }
        last = temp.next;
        temp.next = null;
        return last.element;
    }

    public Node<T> createNode(T element) {
        Node<T> node = new Node();
        node.element = element;
        node.next = null;
        return node;
    }

    public int getSize() {
        int size = 0;
        if (null != head) {
            Node<T> current = head;
            while (current != null) {
                current = current.next;
                size++;
            }
        }
        return size;
    }

    public void show() {
        System.out.println("Printing Linked List:");

        if (null == head) {
            System.out.println("Empty list");
            return;
        }
        Node<T> current = head;
        while (current.next != null) {
            System.out.print(" " + current.element);
            current = current.next;
        }
        System.out.print(" " + current.element);

        System.out.println();

    }


}
