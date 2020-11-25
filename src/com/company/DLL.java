package com.company;

public class DLL<T> {

    public DLLNode<T> first;
    public DLLNode<T> last;

    public DLL(){

        this.first = null;
        this.last = null;
    }

    public DLLNode<T> find(T element){

        DLLNode<T> tmp = first;

        while (tmp != null){

            if(tmp.element == element){

                return tmp;
            }

            tmp = tmp.next;
        }

        return null;
    }

    public int length(){

        int count = 0;

        DLLNode<T> tmp = first;

        while (tmp != null){

            count++;

            tmp = tmp.next;
        }

        return count;
    }

    public void insertFirst(T element){

        if(first == null){

            DLLNode<T> obj = new DLLNode<>(element,null, null);

            first = obj;
            last = obj;
        }
        else {

            DLLNode<T> obj = new DLLNode<>(element,first, null);

            first.prev = obj;
            first = obj;
        }
    }

    public void deleteFirst(){

        first = first.next;
        first.prev = null;
    }

    public void deleteLast(){

        last = last.prev;
        last.next = null;
    }

    public void insertLast(T element){

        if(first == null){

            DLLNode<T> obj = new DLLNode<>(element, null, null);

            first = obj;
            last = obj;
        }
        else {

            DLLNode<T> obj = new DLLNode<>(element, null, null);

            last.next = obj;
            obj.prev = last;
            last = obj;
        }
    }

    public void delete(DLLNode<T> node){

        if(first == null) {         //AKO E PRAZNA LISTATA

            return;
        }

        if(first == node){

            first = first.next;
            first.prev = null;
        }

        if(last == node){

            last = last.prev;
            last.next = null;
        }

        DLLNode<T> tmp = first;

        while (tmp != null){

            if(tmp == node){

                tmp.next.prev = tmp.prev;
                tmp.prev.next = tmp.next;

                return;
            }

            tmp = tmp.next;
        }
    }



    @Override
    public String toString(){

        String out = "";

        DLLNode<T> tmp = first;

        while (tmp != null){

            out += tmp.getElement() + " ";

            tmp = tmp.next;
        }

        return out;
    }
}
