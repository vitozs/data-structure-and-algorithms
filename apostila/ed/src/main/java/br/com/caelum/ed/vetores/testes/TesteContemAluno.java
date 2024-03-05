package br.com.caelum.ed.vetores.testes;

import br.com.caelum.ed.vetores.Aluno;
import br.com.caelum.ed.vetores.Vetor;

public class TesteContemAluno {
    public static void main(String[] args) {
        Vetor lista = new Vetor();
        Aluno a1 = new Aluno();
        a1.setNome("Alex");
        lista.adiciona(a1);
        Aluno a2 = new Aluno();
        a2.setNome("Jorge");
        lista.adiciona(a2);
        Aluno a3 = new Aluno();
        a3.setNome("Vivian");

        System.out.println(lista.contem(a1));
        System.out.println(lista.contem(a2));
        System.out.println(lista.contem(a3));

    }
}
