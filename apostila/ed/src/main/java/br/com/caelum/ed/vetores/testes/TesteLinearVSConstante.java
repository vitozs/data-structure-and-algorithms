package br.com.caelum.ed.vetores.testes;

import br.com.caelum.ed.vetores.Aluno;
import br.com.caelum.ed.vetores.Vetor;

public class TesteLinearVSConstante {
    public static void main(String[] args) {
        contem();
    }

    private static void adiciona(){
        Vetor vetor = new Vetor();
        long inicio = System.currentTimeMillis();
        for(int i = 1; i < 100000; i++) {
            Aluno aluno = new Aluno();
            vetor.adiciona(aluno);
        }
        long fim = System.currentTimeMillis();
        double tempo = (fim - inicio) / 1000.0;
        System.out.println("Tempo em segundos = " + tempo);
    }
    private static void pegaTamanho(){
        Vetor vetor = new Vetor();
        long inicio = System.currentTimeMillis();
        vetor.tamanho();
        long fim = System.currentTimeMillis();
        double tempo = (fim - inicio) / 1000.0;
        System.out.println("Tempo em segundos = " + tempo);
    }
    private static void contem(){
        Vetor vetor = new Vetor();
        long inicio = System.currentTimeMillis();
        for (int i = 1; i < 30000; i++) {
            Aluno aluno = new Aluno();
            vetor.adiciona(aluno);
            if(!vetor.contem(aluno)){
                System.out.println("Erro: aluno "
                        + aluno + " não foi adicionado.");
            }
        }
        // Verificando se o Vetor não encontra alunos não adicionados.
        for (int i = 1; i < 30000; i++) {
            Aluno aluno = new Aluno();
            if(vetor.contem(aluno)){
                System.out.println("Erro: aluno "
                        + aluno + " foi adicionado.");
            }
        }
        long fim = System.currentTimeMillis();
        double tempo = (fim - inicio) / 1000.0;
        System.out.println("Tempo em segundos = " + tempo);
    }

}
