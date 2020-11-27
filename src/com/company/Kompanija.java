package com.company;

class DLLVraboten {

    public DLLNodeVraboten first;
    public DLLNodeVraboten last;

    public DLLVraboten(){

        this.first = null;
        this.last = null;
    }

    public void insertLast(int id, int plata){

        if(first == null){

            DLLNodeVraboten obj = new DLLNodeVraboten(id,plata, null, null);

            first = obj;
            last = obj;
        }
        else {

            DLLNodeVraboten obj = new DLLNodeVraboten(id, plata, null, null);

            last.next = obj;
            obj.prev = last;
            last = obj;
        }
    }

    public void delete(DLLNodeVraboten node){

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

        DLLNodeVraboten tmp = first;

        while (tmp != null){

            if(tmp == node){

                tmp.next.prev = tmp.prev;
                tmp.prev.next = tmp.next;

                return;
            }

            tmp = tmp.next;
        }
    }

    public void print(){

        DLLNodeVraboten tmp = first;

        while (tmp != null){

            System.out.println(tmp.id + " " + tmp.plata);

            tmp = tmp.next;
        }
    }

    public void deletePomalaPlata(int plata){
        DLLNodeVraboten tmp = first;
        while (tmp != null){
            if(tmp.plata < plata){
                delete(tmp);
            }
            tmp = tmp.next;
        }
        sortVraboteniPoPlata();
    }

    public void sortVraboteniPoPlata(){

        DLLNodeVraboten tmp1 = first;
        DLLNodeVraboten tmp2 = null;
        int tmp;

        while (tmp1.next != null){
            tmp2 = tmp1.next;
            while (tmp2 != null){
                if(tmp1.id <= tmp2.id) {
                    tmp = tmp1.id;
                    tmp1.id = tmp2.id;
                    tmp2.id = tmp;
                }
            }
            tmp2 = tmp2.next;
        }
        tmp1 = tmp1.next;
    }
}

class DLLNodeVraboten {

    public DLLNodeVraboten next;
    public DLLNodeVraboten prev;

    public int id;
    public int plata;

    public DLLNodeVraboten(int id,int plata, DLLNodeVraboten next, DLLNodeVraboten prev){

        this.id = id;
        this.plata = plata;
        this.next = next;
        this.prev = prev;
    }

    @Override
    public String toString(){

        String vraboten = this.id + " " + this.plata;

        return vraboten;
    }
}

