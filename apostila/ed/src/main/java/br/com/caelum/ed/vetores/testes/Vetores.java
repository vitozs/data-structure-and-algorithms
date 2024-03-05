package br.com.caelum.ed.vetores.testes;

import br.com.caelum.ed.vetores.Aluno;
import br.com.caelum.ed.vetores.Vetor;

import java.util.ArrayList;
import java.util.Vector;

public class Vetores {
    public static void main(String[] args) {
        Vetor vetor = new Vetor();
        Aluno aluno = new Aluno();
        System.out.println("----VETOR 1----");
        System.out.println(vetor.tamanho());
        for (int i = 0; i < 1000; i++){
            vetor.adiciona(aluno);
        }
        System.out.println(vetor.tamanho());

        Vector<Aluno> vetor2 = new Vector<>();
        System.out.println("----VETOR 2----");
        System.out.println(vetor2.size());
        for(int i = 0; i < vetor.tamanho(); i++){
            vetor2.add((Aluno) vetor.pega(i));
        }
        System.out.println(vetor2.size());

        ArrayList<Aluno> vetor3 = new ArrayList<>();
        System.out.println("----VETOR 3----");
        System.out.println(vetor3.size());
        for(Aluno a : vetor2){
            vetor3.add(a);
        }
        System.out.println(vetor3.size());
    }
}
