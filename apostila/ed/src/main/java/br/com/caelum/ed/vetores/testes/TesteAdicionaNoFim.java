package br.com.caelum.ed.vetores.testes;

import br.com.caelum.ed.vetores.Aluno;
import br.com.caelum.ed.vetores.Vetor;

public class TesteAdicionaNoFim {
    public static void main(String[] args) {
        Aluno a1 = new Aluno();
        Aluno a2 = new Aluno();
        a1.setNome("Carlos");
        a2.setNome("Roberto");

        Vetor lista = new Vetor();
        for (int i = 0; i < lista.tamanho(); i++){
            lista.adiciona(a1);

        }

    }
}
