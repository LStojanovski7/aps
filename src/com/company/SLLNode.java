package com.company;

public class SLLNode<T> {

    public T element;
    public SLLNode<T> next;

    public SLLNode(T elem, SLLNode<T> next){

        this.element = elem;
        this.next = next;
    }

    public T get(){

        return this.element;
    }

    @Override
    public String toString(){

        return this.element.toString();
    }
}
