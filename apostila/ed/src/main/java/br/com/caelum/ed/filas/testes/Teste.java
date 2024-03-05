package br.com.caelum.ed.filas.testes;

import br.com.caelum.ed.filas.Fila;
import br.com.caelum.ed.filas.FilaParametrizada;
import br.com.caelum.ed.vetores.Aluno;

public class Teste {
    public static void main(String[] args) {
        Aluno aluno = new Aluno();
        FilaParametrizada<Aluno> fila = new FilaParametrizada<>();
        fila.insere(new Aluno());

    }
}
