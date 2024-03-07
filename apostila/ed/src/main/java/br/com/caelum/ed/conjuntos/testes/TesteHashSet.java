package br.com.caelum.ed.conjuntos.testes;

import java.util.HashSet;

public class TesteHashSet {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("Teste1");
        hashSet.add("Teste2");
        hashSet.add("Teste1");
        System.out.println(hashSet);
    }
}
