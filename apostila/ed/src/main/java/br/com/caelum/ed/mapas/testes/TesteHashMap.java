package br.com.caelum.ed.mapas.testes;

import java.util.HashMap;

public class TesteHashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> hash = new HashMap<>();
        hash.put("1", 2);
        hash.put("1", 2);
        hash.put("2", 2);
        hash.put("3", 2);
        System.out.println(hash);


    }
}
