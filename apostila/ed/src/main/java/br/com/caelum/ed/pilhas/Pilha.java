package br.com.caelum.ed.pilhas;

import java.util.LinkedList;

public class Pilha {

    LinkedList<Peca> pecas = new LinkedList<Peca>();
    public void insere(Peca peca){
        pecas.add(peca);
    }
    public Peca remove(){return pecas.remove(pecas.size() - 1);}
    public boolean vazia(){return pecas.isEmpty();}
}
