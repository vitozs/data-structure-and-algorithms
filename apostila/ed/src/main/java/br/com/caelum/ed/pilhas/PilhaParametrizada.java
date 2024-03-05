package br.com.caelum.ed.pilhas;

import java.util.LinkedList;

public class PilhaParametrizada<T> {

    LinkedList<T> pecas = new LinkedList<T>();
    public void insere(T peca){
        pecas.add(peca);
    }
    public T remove(){return pecas.remove(pecas.size() - 1);}
    public boolean vazia(){return pecas.isEmpty();}
}
