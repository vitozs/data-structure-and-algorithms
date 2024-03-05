package br.com.caelum.ed.filas;


import br.com.caelum.ed.vetores.Aluno;

import java.util.LinkedList;
import java.util.Objects;

public class FilaGenerica {
    LinkedList<Object> alunos = new LinkedList<Object>();
    public void insere(Object aluno){
        alunos.add(aluno);
    }
    public Object remove(){
        return alunos.remove(0);
    }
    public boolean vazia(){
        return alunos.isEmpty();
    }
}
