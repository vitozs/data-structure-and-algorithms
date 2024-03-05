package br.com.caelum.ed.pilhas;

import java.util.LinkedList;
import java.util.List;

public class PilhaGenerica {
    private List<Object> objetos = new LinkedList<Object>();
    public void insere(Object objeto) {
        this.objetos.add(objeto);
    }
    public Object remove() {
        return this.objetos.remove(this.objetos.size() - 1);
    }
    public boolean vazia() {
        return this.objetos.size() == 0;
    }
}