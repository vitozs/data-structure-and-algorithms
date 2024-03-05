package br.com.caelum.ed.listaLigada.testes;

import br.com.caelum.ed.listaLigada.ListaLigada;

public class TesteAdicionaNoFim {
    public static void main(String[] args) {
        ListaLigada lista = new ListaLigada();
        lista.adiciona("Rafael");
        lista.adiciona("Paulo");
        System.out.println(lista);
        lista.remove(1);
        System.out.println(lista);

    }
}
