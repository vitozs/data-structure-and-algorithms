package br.com.caelum.ed.conjuntos.testes;

import br.com.caelum.ed.conjuntos.ConjuntoEspelhamento;

import java.util.List;

public class TesteAdiciona {
    public static void main(String[] args) {
        ConjuntoEspelhamento conjunto = new ConjuntoEspelhamento();
        conjunto.adiciona("Rafael");
        conjunto.adiciona("Ana");
        conjunto.adiciona("Paulo");
        conjunto.adiciona("Paulo");

        List<String> palavras = conjunto.pegaTodas();
        System.out.println("antes de remover");
        for (String palavra : palavras) {
            System.out.println(palavra);
        }
        conjunto.remove("Rafael");
        palavras = conjunto.pegaTodas();
        System.out.println("depois de remover");
        for (String palavra : palavras) {
            System.out.println(palavra);
        }
        System.out.println(conjunto.tamanho());
    }
}
