package com.company;

public class SLL<T> {

    private SLLNode<T> first;

    public SLL(){

        this.first = null;
    }

    public SLLNode<T> getFirst(){

        return this.first;
    }

    public SLLNode<T> getLast(){

        SLLNode<T> tmp = first;

        while (tmp != null){

            if(tmp.next == null){

                break;
            }

            tmp = tmp.next;
        }

        return tmp;
    }

    public void insertFirst(T element){

        if(first == null){

            SLLNode<T> ob = new SLLNode<>(element, null);
            first = ob;
        }
        else if(first != null){

            SLLNode<T> ob = new SLLNode<>(element, first);
            first = ob;
        }
    }

    public void insertLast(T element){

        if(first == null){

            insertFirst(element);
        }
        else if(first != null){

            SLLNode<T> ob = new SLLNode<>(element, null);

            SLLNode<T> tmp = first;

            while (tmp != null){

                if(tmp.next == null){

                    tmp.next = ob;
                    return;
                }

                tmp = tmp.next;
            }
        }
    }

    public SLLNode<T> find(T element){

        SLLNode<T> tmp = first;

        while (tmp != null){

            if(tmp.element == element){

                break;
            }

            tmp = tmp.next;
        }

        return tmp;
    }

    public void deleteFirst(){

        first = first.next;
    }

    public void deleteLast(){

        SLLNode<T> tmp = first;

        while (tmp != null){

            if(tmp.next.next == null){

                tmp.next = null;
                return;
            }

            tmp = tmp.next;
        }
    }

    public void delete(T element){

        if(first.element == element){

            first = first.next;
            return;
        }

        SLLNode<T> tmp = first;

        while (tmp != null){

            if(tmp.next.element == element){

                tmp.next = tmp.next.next;
                return;
            }

            tmp = tmp.next;
        }
    }

    @Override
    public String toString(){

        String output = "";

        SLLNode<T> tmp = first;

        while (tmp != null){

            output += tmp.element.toString() + " ";

            tmp = tmp.next;
        }

        return output;
    }

    public void print(){

        SLLNode<T> tmp = first;
        String output = "";

        while (tmp != null){

            output += tmp.element + " ";

            tmp = tmp.next;
        }

        System.out.println(output);
    }

    public void sort(){

        SLLNode<T> tmp = first;

        while (tmp != null){

            SLLNode<T> tmp2 = tmp;

            while (tmp2 != null){

            }
        }
    }

    public int length(){

        int size = 0;

        SLLNode<T> tmp = first;

        while (tmp != null){

            size++;

            tmp = tmp.next;
        }

        return size;
    }

    public void mirror(int n, int m) {

        SLLNode<T> tmp = first;
        SLLNode<T> predN = null;
        SLLNode<T> posleM = null;
        SLLNode<T> next = null;
        SLLNode<T> prev = null;
        SLLNode<T> N = null;
        SLLNode<T> M = null;

        int count = 1;

        while (tmp != null) {

            if(count == n){

                N = tmp;
            }

            if(count == m){

                M = tmp;
            }

            count++;

            tmp = tmp.next;
        }

        tmp = first;

        while (tmp != null){

            if(tmp.next == N){

                predN = tmp;
            }

            tmp = tmp.next;
        }

        posleM = M.next;

        tmp = N;

        while (tmp != posleM){

            next = tmp.next;
            tmp.next = prev;
            prev = tmp;
            tmp = next;
        }

        predN.next = M;
        N.next = posleM;
    }
}
