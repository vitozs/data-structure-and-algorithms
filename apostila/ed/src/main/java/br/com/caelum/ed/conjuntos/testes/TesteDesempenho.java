package br.com.caelum.ed.conjuntos.testes;

import br.com.caelum.ed.conjuntos.ConjuntoEspelhamento;

public class TesteDesempenho {
    public static void main(String[] args) {

        //SEM DESEMPENHO - 5.53s
        //COM DESEMPENHO - 0.144s
        long inicio = System.currentTimeMillis();
        ConjuntoEspelhamento conjuntoEspelhamento = new ConjuntoEspelhamento();
        for(int i = 0; i < 50000; i++){
            conjuntoEspelhamento.adiciona("Pamonha" + i);
        }
        for (int i = 0; i < 50000; i++) {
            conjuntoEspelhamento.contem("palavra" + i);
        }
        long fim = System.currentTimeMillis();
        System.out.println("Tempo: " + (fim - inicio) / 1000.0);
    }
}
