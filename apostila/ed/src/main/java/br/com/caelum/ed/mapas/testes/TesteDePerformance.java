package br.com.caelum.ed.mapas.testes;

import br.com.caelum.ed.mapas.Carro;
import br.com.caelum.ed.mapas.MapaLista;

public class TesteDePerformance {
    public static void main(String[] args) {
        //0.008s
        MapaLista mapaLista = new MapaLista();
        int numElementos = 15000;
        long init = System.currentTimeMillis();
        for(int i = 0; i < numElementos; i++){
                mapaLista.adiciona( "21314", new Carro("c"));
        }
        long fim = System.currentTimeMillis();
        System.out.println((fim-init)/1000.0);
    }

}
