package br.com.caelum.ed.filas;

import br.com.caelum.ed.vetores.Aluno;

import java.util.LinkedList;

public class Fila {
    LinkedList<Aluno> alunos = new LinkedList<Aluno>();
    public void insere(Aluno aluno){
        alunos.add(aluno);
    }
    public Aluno remove(){
        return alunos.remove(0);
    }
    public boolean vazia(){
        return alunos.isEmpty();
    }
}
