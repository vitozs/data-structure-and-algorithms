package br.com.caelum.ed.vetores.testes;

import br.com.caelum.ed.vetores.Aluno;
import br.com.caelum.ed.vetores.Vetor;

public class TesteAdicionaPorPosicao {
    public static void main(String[] args) {
        Aluno a1 = new Aluno();
        Aluno a2 = new Aluno();
        Aluno a3 = new Aluno();

        a1.setNome("Carlos");
        a2.setNome("Roberto");
        a2.setNome("Jose");

        Vetor lista = new Vetor();

        lista.adiciona(0,a1);
        lista.adiciona(1,a2);
        lista.adiciona(1,a3);

        System.out.println(lista.toString());

    }
}
