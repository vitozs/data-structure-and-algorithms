package br.com.caelum.ed.filas;

import br.com.caelum.ed.vetores.Aluno;

import java.util.LinkedList;

public class FilaParametrizada<T> {
    LinkedList<T> objs = new LinkedList<T>();
    public void insere(T t){
        objs.add(t);
    }
    public T remove(){
        return objs.remove(0);
    }
    public boolean vazia(){
        return objs.isEmpty();
    }
}
