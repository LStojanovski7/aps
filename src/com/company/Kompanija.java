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

    public void delete(int id){

        if(first == null) {         //AKO E PRAZNA LISTATA

            return;
        }

        if(first.id == id){

            first = first.next;
            first.prev = null;
        }

        if(last.id == id){

            last = last.prev;
            last.next = null;
        }

        DLLNodeVraboten tmp = first;

        while (tmp != null){

            if(tmp.id == id){

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

    public void deleteByPlata(int plata){

        DLLNodeVraboten tmp = first;

        while (tmp != null){

            if(tmp.plata < plata){

                delete(tmp.id);
            }

            tmp = tmp.next;
        }
    }

    public void sortVraboteniPoPlata(){

//        TODO:
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

