package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args){

        DLL<DLL<Integer>> listi = new DLL<>();

        DLL<Integer> lista1 = new DLL<>();
        DLL<Integer> lista2 = new DLL<>();

        for(int i = 0; i < 4; i++){

            lista1.insertLast(i);
        }

        for (int i = 10; i > 5; i--){

            lista2.insertLast(i);
        }

        listi.insertLast(lista1);
        listi.insertLast(lista2);

        System.out.println(listaOdListi(listi));
    }

    public static int listaOdListi(DLL<DLL<Integer>> lista){

        DLLNode<DLL<Integer>> tmp = lista.first;

        int sum = 0;

        while (tmp != null){

            DLLNode<Integer> tmp1 = tmp.element.first;

            int sum1 = 0;

            while (tmp1 != null){

                sum1 += tmp1.element;

                tmp1 = tmp1.next;
            }

            sum += sum1;

            tmp = tmp.next;
        }

        return sum;
    }

    public static void removeDuplicates(SLL<Integer> list){
        SLLNode<Integer> tmp = list.getFirst();
        SLLNode<Integer> tmp1 = null;

        while (tmp.next != null){
            tmp1 = tmp.next;
            while (tmp1 != null) {
                if (tmp.element == tmp1.element) {
                    list.delete(tmp1);
                }
                tmp1 = tmp1.next;
            }
            tmp = tmp.next;
        }

    }

    //    TODO: SORTIRANJE SO LINK SLL
    public static void sortByLink(SLL<Integer> list){

        SLLNode<Integer> tmp = list.getFirst();

        SLLNode<Integer> tmp1 = null;

        if(tmp == null) return; // DALI E PRAZNA

        while (tmp.next != null){

            tmp1 = tmp.next;

            if(tmp.element > tmp.next.element){

                tmp.next = tmp.next.next;
                tmp1.next = list.getFirst();

                list.setFirstNode(tmp1);
                tmp = list.getFirst();
            }
            else {

                tmp = tmp.next;
            }

        }
    }

    public static void sortPoElement(DLL<Integer> lista){

        DLLNode<Integer> tmp1 = lista.first;
        DLLNode<Integer> tmp2 = null;

        while (tmp1.next != null){

            tmp2 = tmp1.next;

            while (tmp2 != null){

                if(tmp1.element > tmp2.element){

                    Integer tmp = tmp1.element;
                    tmp1.element = tmp2.element;
                    tmp2.element = tmp;
                }
                tmp2 = tmp2.next;
            }
            tmp1 = tmp1.next;
        }
    }

    public static void IzbrisiNeparen(SLL<Integer> list){
        SLLNode<Integer> tmp = list.getFirst();
        int count =0;

        while (tmp != null){
            if(tmp.element % 2 != 0){
                list.delete(tmp);
                count++;
            }
            tmp = tmp.next;
        }

        System.out.println(list.toString());
        System.out.println(count);
    }

    public static DLL<Integer> podeli(DLL<Integer> lista1, DLL<Integer> lista2) {

        DLL<Integer> rezultat = new DLL<>();
        DLLNode<Integer> tmp1 = lista1.first;
        DLLNode<Integer> tmp2 = lista2.last;

        while(tmp1 != null && tmp2 != null) {
            if(tmp1.element % 2 == 0){
                rezultat.insertLast(tmp1.element);
            }
            if(tmp2.element % 2 == 0){
                rezultat.insertLast(tmp2.element);
            }
            tmp1 = tmp1.next;
            tmp2 = tmp2.prev;
        }

        tmp1 = lista1.first;

        while (tmp1 != null){
            if(tmp1.element % 2 != 0) {
                rezultat.insertLast(tmp1.element);
            }
            tmp1 = tmp1.next;
        }

        while (tmp2 != null){
            if(tmp2.element % 2 != 0) {
                rezultat.insertLast(tmp2.element);
            }
            tmp2 = tmp2.prev;
        }

        return rezultat;

    }

    public static int SumaNaNelementi(DLL<Integer>lista, int n, int m){
        DLLNode<Integer> tmp = lista.first;
        int suma = 0;
        int brojac = 1;

        while (tmp != null){
            if(brojac >= n && brojac <=m){
                suma += tmp.element;
            }

            brojac++;
            tmp = tmp.next;
        }
       return suma;
    }

    public static DLL<Integer> BrisenjeNelement(DLL<Integer>lista, int n){
        DLLNode<Integer> tmp = lista.first;
        int pozicija = 1;

        while (tmp != null) {
            if(pozicija == n){
                lista.delete(tmp);
            }
            pozicija++;
            tmp = tmp.next;
        }

        return lista;
    }

    public static void podeliParnost(DLL<Integer> lista, DLL<Integer> lparni, DLL<Integer> lneparni) {

        DLLNode<Integer> tmp;

        tmp = lista.first;


        while (tmp != null) {
            if(tmp.element % 2 == 0){
                lparni.insertLast(tmp.element);
            }
            else {
                lneparni.insertLast(tmp.element);
            }
            tmp =tmp.next;
        }

    }

    public static SLL<Integer> SpoiListi(SLL<Integer> list1,SLL<Integer> list2){
        SLL<Integer> lista = new SLL<>();

        SLLNode<Integer> tmp1 = list1.getFirst();
        SLLNode<Integer> tmp2 = list2.getFirst();

        while (tmp1 != null && tmp2 != null){
            if(tmp1.element < tmp2.element){
                lista.insertLast(tmp1.element);
                tmp1 = tmp1.next;
            }
            else if(tmp1.element > tmp2.element){
                lista.insertLast(tmp2.element);
                tmp2 = tmp2.next;
            }
            else {
                lista.insertLast(tmp1.element);
                tmp1 = tmp1.next;
                tmp2 = tmp2.next;
            }
        }

        if(tmp1 != null){
            while (tmp1 != null){
                lista.insertLast(tmp1.element);
                tmp1 = tmp1.next;
            }
        }
        if(tmp2 != null){
            while (tmp2 != null){
                lista.insertLast(tmp2.element);
                tmp2 = tmp2.next;
            }
        }
        return lista;
    }

    public static float Prosek(DLL<Integer> lista1, DLL<Integer> lista2){

        int sum1 = 0;
        int sum2 = 0;

        DLLNode<Integer> tmp1, tmp2;

        tmp1 = lista1.first;
        tmp2 = lista2.first;

        while (tmp1 != null){

            sum1 += tmp1.element;

            tmp1 = tmp1.next;
        }

        while (tmp2 != null){

            sum2 += tmp2.element;

            tmp2 = tmp2.next;
        }

        float avg1 = (float) sum1 / lista1.length();
        float avg2 = (float) sum2 / lista2.length();

        return avg1 + avg2;
    }

    public static DLL<Integer> Irena(DLL<Integer> lista1, DLL<Integer> lista2){

        float avg = Prosek(lista1, lista2);

        DLLNode<Integer> tmp1 = lista1.first;
        DLLNode<Integer> tmp2 = lista2.last;

        DLL<Integer> novaLista = new DLL<>();

        float sum1 = 0;
        float sum2 = 0;

        while (tmp1 != null){

            sum1 += tmp1.element;

            if(sum1 < avg){

                novaLista.insertLast(tmp1.element);
            }
            else break;


            tmp1 = tmp1.next;
        }

        while (tmp2 != null){

            sum2 += tmp2.element;

            if(sum2 < avg){

                novaLista.insertLast(tmp2.element);
            }
            else break;

            tmp2 = tmp2.prev;
        }

        return novaLista;
    }

    public static int Palindrom(DLL<Integer> list){

        DLLNode<Integer> tmp1 = list.first;
        DLLNode<Integer> tmp2 = list.last;

        String result1 = null;
        String result2 = null;

        while (tmp1 != null && tmp2 != null){

            result1 += tmp1.element.toString();
            result2 += tmp2.element.toString();

            tmp1 = tmp1.next;
            tmp2 = tmp2.prev;
        }

        if(result1.equals(result2))
            return 1;
        else
            return 0;
    }

    public static SLL<Integer> merge(SLL<Integer> list1, SLL<Integer> list2){

        SLL<Integer> list = new SLL<>();

        SLLNode<Integer> tmp1 = list1.getFirst();
        SLLNode<Integer> tmp2 = list2.getFirst();

        while (tmp1 != null){

            list.insertLast(tmp1.element);

            tmp1 = tmp1.next;
        }
        while (tmp2 != null){

            list.insertLast(tmp2.element);

            tmp2 = tmp2.next;
        }

        return list;
    }
}
