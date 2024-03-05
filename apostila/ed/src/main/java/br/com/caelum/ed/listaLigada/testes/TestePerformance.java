package br.com.caelum.ed.listaLigada.testes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

public class TestePerformance {
    static ArrayList<String> vetor = new ArrayList<String>();
    static LinkedList<String> lista = new LinkedList<String>();
    static int numeroDeElementos = 40000;

    public static void main(String[] args) {


        //Adicionando primeiro
        //0.133
        addFirstVetor();
        //0.007
        addFirstLista();

        //Percorrendo
        //0.002
        percorrendoVetor();
        //0.545
        percorrendLista();

        //Removendo primeiro
        //0.123
        removendoVetor();
        //0.004
        removendoLista();

    }

    static private void addFirstVetor(){
        long init = System.currentTimeMillis();
        for (int i = 0; i < numeroDeElementos; i++){
            vetor.add(0, "testeeee");
        }
        long end = System.currentTimeMillis();
        System.out.println("Vetor: " + (end - init)/1000.0);}
    static private void addFirstLista(){
        long init = System.currentTimeMillis();
        for (int i=0; i < numeroDeElementos; i++){
            lista.addFirst("Testeee");
        }

        long end = System.currentTimeMillis();
        System.out.println("Lista: " + (end - init)/1000.0);}

    static private void percorrendoVetor(){
        long init = System.currentTimeMillis();
        for (int i=0; i < numeroDeElementos; i++){
            vetor.get(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("Vetor: " + (end - init)/1000.0);
    }

    static private void percorrendLista(){
        long init = System.currentTimeMillis();
        for (int i=0; i < numeroDeElementos; i++){
            lista.get(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("Lista: " + (end - init)/1000.0);
    }

    static private void removendoVetor(){
        long init = System.currentTimeMillis();
        for (int i=0; i < numeroDeElementos; i++){
            vetor.remove(0);
        }
        long end = System.currentTimeMillis();
        System.out.println("Vetor: " + (end - init)/1000.0);
    }

    static private void removendoLista(){
        long init = System.currentTimeMillis();
        for (int i = 0; i < numeroDeElementos; i++){
            lista.remove(0);
        }
        long end = System.currentTimeMillis();
        System.out.println("Lista: " + (end - init)/1000.0);
    }
}
