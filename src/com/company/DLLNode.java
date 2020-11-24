package com.company;

public class DLLNode<T> {

    public DLLNode<T> next;
    public DLLNode<T> prev;

    public T element;

    public DLLNode(T element, DLLNode<T> next, DLLNode<T> prev){

        this.element = element;
        this.next = next;
        this.prev = prev;
    }

    public T getElement(){

        return element;
    }

    @Override
    public String toString(){

        return this.element.toString();
    }
}
